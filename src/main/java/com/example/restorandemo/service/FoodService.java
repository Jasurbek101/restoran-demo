package com.example.restorandemo.service;

import com.example.restorandemo.dto.FoodDTO;
import com.example.restorandemo.dto.FoodResponseDTO;
import com.example.restorandemo.entity.BatchEntity;
import com.example.restorandemo.entity.FoodEntity;
import com.example.restorandemo.exception.AlreadyExistsException;
import com.example.restorandemo.mapper.FoodMapper;
import com.example.restorandemo.repository.FoodRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FoodService {
    private final FoodRepository foodRepository;
    private final BatchService batchService;

    public FoodResponseDTO createFood(FoodDTO foodDTO) {
        Optional<FoodEntity> food = foodRepository.findByName(foodDTO.getName());
        if (food.isPresent()) {
            throw new AlreadyExistsException(String.format(" Food Already exist with name [%s]", foodDTO.getName()));
        }
        FoodEntity foodEntity = FoodMapper.converToEntity(foodDTO);
        BatchEntity batch = batchService.createBatch(foodEntity.getBatch());
        if (batch != null) {
            foodEntity.setBatch(batch);
            FoodEntity savedFood = foodRepository.save(foodEntity);
            return FoodMapper.converToResponseDto(savedFood);
        }
        return null;
    }

    public List<FoodResponseDTO> getAllFoods() {
        List<FoodEntity> foodEntities = foodRepository.findAll();
        return foodEntities.stream().map(FoodMapper::converToResponseDto).toList();
    }

    public FoodResponseDTO getFoodById(Long id) {
        Optional<FoodEntity> foodEntity = foodRepository.findById(id);
        return foodEntity.map(FoodMapper::converToResponseDto).orElse(null);
    }

    public FoodResponseDTO deleteFoodById(Long id) {
        Optional<FoodEntity> optionalFood = foodRepository.findById(id);
        if (optionalFood.isPresent()) {
            BatchEntity batch = optionalFood.get().getBatch();
            batchService.deleteBatchById(batch.getId());
            foodRepository.deleteById(id);
        }
        return optionalFood.map(FoodMapper::converToResponseDto).orElse(null);
    }

}

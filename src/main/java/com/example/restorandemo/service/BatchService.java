package com.example.restorandemo.service;

import com.example.restorandemo.dto.BatchDTO;
import com.example.restorandemo.entity.BatchEntity;
import com.example.restorandemo.exception.RecordNotFoundException;
import com.example.restorandemo.mapper.BatchMapper;
import com.example.restorandemo.repository.BatchRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BatchService {
    private final BatchRepository batchRepository;

    public BatchEntity createBatch(BatchEntity batchEntity){
        return batchRepository.save(batchEntity);
    }

    public BatchEntity deleteBatchById(Long id){
        Optional<BatchEntity> batchEntity = batchRepository.findById(id);
        if (batchEntity.isPresent())
            batchRepository.deleteById(id);
        return batchEntity.orElse(null);
    }
}
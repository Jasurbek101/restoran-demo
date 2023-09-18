package com.example.restorandemo.controller;

import com.example.restorandemo.dto.ApiResponse;
import com.example.restorandemo.dto.FoodDTO;
import com.example.restorandemo.dto.FoodResponseDTO;
import com.example.restorandemo.entity.FoodEntity;
import com.example.restorandemo.service.FoodService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/food")
@RequiredArgsConstructor
public class FoodController {
    private final FoodService foodService;

    @PostMapping
    public ApiResponse<FoodResponseDTO> createFood(@RequestBody FoodDTO foodDTO) {
        FoodResponseDTO savedFood = foodService.createFood(foodDTO);
        if (savedFood == null)
            return ApiResponse.<FoodResponseDTO>builder()
                    .status(500)
                    .message(" Food Unsuccesfully Added ")
                    .success(false)
                    .build();
        else
            return ApiResponse.<FoodResponseDTO>builder()
                    .status(200)
                    .message(" Food Succesfully Added ")
                    .success(true)
                    .data(savedFood)
                    .build();
    }

    @GetMapping
    public ApiResponse<List<FoodResponseDTO>> getFoodList() {
        List<FoodResponseDTO> foodResponseDTOS = foodService.getAllFoods();
        if (foodResponseDTOS == null)
            return ApiResponse.<List<FoodResponseDTO>>builder()
                    .status(404)
                    .message(" Food List is NULL ")
                    .success(false)
                    .build();
        else
            return ApiResponse.<List<FoodResponseDTO>>builder()
                    .status(200)
                    .message(" There is Food entity list ")
                    .success(true)
                    .data(foodResponseDTOS)
                    .build();
    }

    @GetMapping("/{id}")
    public ApiResponse<FoodResponseDTO> getFoodById(@PathVariable Long id) {
        FoodResponseDTO foodResponseDTO = foodService.getFoodById(id);
        if (foodResponseDTO == null)
            return ApiResponse.<FoodResponseDTO>builder()
                    .status(4045)
                    .message(" Food Not Found ")
                    .success(false)
                    .build();
        else
            return ApiResponse.<FoodResponseDTO>builder()
                    .status(200)
                    .message(" There is Food ResponseDTO ")
                    .success(true)
                    .data(foodResponseDTO)
                    .build();
    }

    @DeleteMapping("/{id}")
    public ApiResponse<FoodResponseDTO> deleteFoodById(@PathVariable Long id) {
        FoodResponseDTO foodResponseDTO = foodService.deleteFoodById(id);
        if (foodResponseDTO == null)
            return ApiResponse.<FoodResponseDTO>builder()
                    .status(500)
                    .message(" Food Unsuccsessfull Deleted ")
                    .success(false)
                    .build();
        else
            return ApiResponse.<FoodResponseDTO>builder()
                    .status(200)
                    .message(" Food Succsessfull Deleted ")
                    .success(true)
                    .data(foodResponseDTO)
                    .build();
    }

}
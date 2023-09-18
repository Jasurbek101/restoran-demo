package com.example.restorandemo.controller;

import com.example.restorandemo.dto.ApiResponse;
import com.example.restorandemo.dto.TableDTO;
import com.example.restorandemo.entity.TableEntity;
import com.example.restorandemo.service.TableService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/table")
public class TableController {
    private final TableService tableService;

    @PostMapping
    public ApiResponse<TableEntity> createTable(@RequestBody TableDTO tableDTO){
        TableEntity table = tableService.createTable(tableDTO);
        if (table == null)
            return ApiResponse.<TableEntity>builder()
                    .message( " Table Does not saved")
                    .status(500)
                    .success(false)
                    .build();
        else
            return ApiResponse.<TableEntity>builder()
                    .message( " Table Succesfully added ")
                    .status(200)
                    .success(true)
                    .data(table)
                    .build();
    }

    @GetMapping
    public ApiResponse<List<TableEntity>> getAllTables(){
        List<TableEntity> allTables = tableService.getAllTables();
        if (allTables == null)
            return ApiResponse.<List<TableEntity>>builder()
                    .message( " Table List is null ")
                    .status(404)
                    .success(false)
                    .build();
        else
            return ApiResponse.<List<TableEntity>>builder()
                    .message( " Table List !!! ")
                    .status(200)
                    .success(true)
                    .data(allTables)
                    .build();
    }

    @GetMapping("/{id}")
    public ApiResponse<TableEntity> getTableById(@PathVariable Long id){
        TableEntity table = tableService.getTableById(id);
        if (table == null)
            return ApiResponse.<TableEntity>builder()
                    .message( " Table not found ")
                    .status(404)
                    .success(false)
                    .build();
        else
            return ApiResponse.<TableEntity>builder()
                    .message( " Table !!! ")
                    .status(200)
                    .success(true)
                    .data(table)
                    .build();
    }

    @DeleteMapping("/{id}")
    public ApiResponse<TableEntity> deleteTableById(@PathVariable Long id){
        TableEntity table = tableService.deleteTableById(id);
        if (table == null)
            return ApiResponse.<TableEntity>builder()
                    .message( " Table does not deleted ")
                    .status(404)
                    .success(false)
                    .build();
        else
            return ApiResponse.<TableEntity>builder()
                    .message( " Table succesfully deleted !!! ")
                    .status(200)
                    .success(true)
                    .data(table)
                    .build();
    }


}

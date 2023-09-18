package com.example.restorandemo.service;

import com.example.restorandemo.dto.TableDTO;
import com.example.restorandemo.entity.TableEntity;
import com.example.restorandemo.mapper.TableMapper;
import com.example.restorandemo.repository.TableRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TableService {
    private final TableRepository tableRepository;

    public TableEntity createTable(TableDTO tableDTO) {
        TableEntity tableEntity = TableMapper.convertToEntity(tableDTO);
        return tableRepository.save(tableEntity);
    }

    public List<TableEntity> getAllTables(){
        return tableRepository.findAll();
    }

    public TableEntity getTableById(Long id){
        Optional<TableEntity> tableEntity = tableRepository.findById(id);
        return tableEntity.orElse(null);
    }

    public TableEntity changeStateById(Long id){
        Optional<TableEntity> table = tableRepository.findById(id);
        if (table.isPresent()) {
            TableEntity tableEntity = table.get();
            tableEntity.setState(!tableEntity.isState());
            return tableRepository.save(tableEntity);
        }
        return table.get();
    }

    public TableEntity deleteTableById(Long id){
        Optional<TableEntity> tableEntity = tableRepository.findById(id);
        if (tableEntity.isPresent()) {
            tableRepository.deleteById(id);
        }
        return tableEntity.orElse(null);
    }

}

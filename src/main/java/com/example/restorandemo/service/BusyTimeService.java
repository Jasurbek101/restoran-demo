package com.example.restorandemo.service;

import com.example.restorandemo.dto.BusyTimeDTO;
import com.example.restorandemo.entity.BusyTimeEntity;
import com.example.restorandemo.mapper.BusyTimeMapper;
import com.example.restorandemo.repository.BusyTimeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BusyTimeService {

    private final BusyTimeRepository busyTimeRepository;

    public BusyTimeEntity createBusyTime(BusyTimeDTO busyTimeDTO){
        BusyTimeEntity busyTimeEntity = BusyTimeMapper.convertToEntity(busyTimeDTO);
        return busyTimeRepository.save(busyTimeEntity);
    }

}

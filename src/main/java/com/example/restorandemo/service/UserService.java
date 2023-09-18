package com.example.restorandemo.service;

import com.example.restorandemo.dto.UserDTO;
import com.example.restorandemo.entity.UserEntity;
import com.example.restorandemo.mapper.UserMapper;
import com.example.restorandemo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public UserDTO createUser(UserDTO userDTO) {
        Optional<UserEntity> optionalUser = userRepository.findByPhone(userDTO.getPhone());
        if (optionalUser.isPresent()) {
            return userDTO;
        }

        UserEntity newUser = UserMapper.converDtoToEntity(userDTO);
        UserEntity savedUser = userRepository.save(newUser);
        return UserMapper.converEntityToDto(savedUser);
    }

    public List<UserDTO> getUsersList(){
        List<UserEntity> allUsers = userRepository.findAll();
        return allUsers.stream().map(UserMapper::converEntityToDto).toList();
    }

    public UserDTO getUserByPhone(String phone) {
        Optional<UserEntity> userEntity = userRepository.findByPhone(phone);
        return userEntity.map(UserMapper::converEntityToDto).orElse(null);
    }

    public UserDTO getUserById(Long id) {
        Optional<UserEntity> userEntity = userRepository.findById(id);
        return userEntity.map(UserMapper::converEntityToDto).orElse(null);
    }

    public UserDTO deleteUserById(Long id) {
        Optional<UserEntity> userEntity = userRepository.findById(id);
        if (userEntity.isPresent())
            userRepository.deleteById(id);
        return userEntity.map(UserMapper::converEntityToDto).orElse(null);
    }

    public UserDTO deleteUserByPhone(String phone) {
        Optional<UserEntity> userEntity = userRepository.findByPhone(phone);
        if (userEntity.isPresent())
            userRepository.deleteByPhone(phone);
        return userEntity.map(UserMapper::converEntityToDto).orElse(null);
    }

}
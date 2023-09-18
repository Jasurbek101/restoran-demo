package com.example.restorandemo.controller;

import com.example.restorandemo.dto.ApiResponse;
import com.example.restorandemo.dto.UserDTO;
import com.example.restorandemo.repository.UserRepository;
import com.example.restorandemo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping
    public ApiResponse<UserDTO> createUser(@RequestBody UserDTO userDTO) {
        UserDTO user = userService.createUser(userDTO);
        if (user == null)
            return ApiResponse.<UserDTO>builder()
                    .status(500)
                    .message(" Food Unsuccesfully Added ")
                    .success(false)
                    .build();
        else
            return ApiResponse.<UserDTO>builder()
                    .status(200)
                    .message(" Food Succesfully Added ")
                    .success(true)
                    .data(user)
                    .build();
    }

    @GetMapping("/{id}")
    public ApiResponse<UserDTO> getUserById(@PathVariable Long id) {
        UserDTO userDTO = userService.getUserById(id);
        if (userDTO == null)
            return ApiResponse.<UserDTO>builder()
                    .status(404)
                    .message(" User Not Found ")
                    .success(false)
                    .build();
        else
            return ApiResponse.<UserDTO>builder()
                    .status(200)
                    .message(" This is a user !!! ")
                    .success(true)
                    .data(userDTO)
                    .build();
    }

    @GetMapping
    public ApiResponse<List<UserDTO>> getUsersList() {
        List<UserDTO> usersList = userService.getUsersList();
        if (usersList == null)
            return ApiResponse.<List<UserDTO>>builder()
                    .status(404)
                    .message(" User List Not Found ")
                    .success(false)
                    .build();
        else
            return ApiResponse.<List<UserDTO>>builder()
                    .status(200)
                    .message(" This is a user !!! ")
                    .success(true)
                    .data(usersList)
                    .build();
    }

    @DeleteMapping("/{id}")
    public ApiResponse<UserDTO> deleteUserById(@PathVariable Long id) {
        UserDTO userDTO = userService.deleteUserById(id);
        if (userDTO == null)
            return ApiResponse.<UserDTO>builder()
                    .status(404)
                    .message(" User doe bot deleted ")
                    .success(false)
                    .build();
        else
            return ApiResponse.<UserDTO>builder()
                    .status(200)
                    .message(" This is a user !!! ")
                    .success(true)
                    .data(userDTO)
                    .build();
    }


}

package com.juniordev.sistema_de_agendamento.controller;

import com.juniordev.sistema_de_agendamento.model.User;
import com.juniordev.sistema_de_agendamento.model.dto.UserDto;
import com.juniordev.sistema_de_agendamento.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
    @PostMapping
    public User create(@RequestBody UserDto userDto){
         return userService.create(userDto);
    }
    @GetMapping
    public List<User> listAll(){
        return userService.listUser();
    }
}

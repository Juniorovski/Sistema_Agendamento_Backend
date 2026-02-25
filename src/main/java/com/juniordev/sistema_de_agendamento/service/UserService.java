package com.juniordev.sistema_de_agendamento.service;

import com.juniordev.sistema_de_agendamento.model.User;
import com.juniordev.sistema_de_agendamento.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public User create(User user){
        return userRepository.save(user);
    }

}

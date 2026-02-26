package com.juniordev.sistema_de_agendamento.service;

import com.juniordev.sistema_de_agendamento.model.Company;
import com.juniordev.sistema_de_agendamento.model.User;
import com.juniordev.sistema_de_agendamento.model.dto.UserDto;
import com.juniordev.sistema_de_agendamento.repository.CompanyRepository;
import com.juniordev.sistema_de_agendamento.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final CompanyRepository companyRepository;

    public UserService(UserRepository userRepository, CompanyRepository companyRepository){
        this.userRepository = userRepository;
        this.companyRepository = companyRepository;
    }
    //cria novo usuario
    public User create(UserDto userDto){
        Company company = new Company();
        company.setName(userDto.getName());
        company.setEmail(userDto.getEmail());
        company = companyRepository.save(company);

        if (userRepository.existsByEmail(userDto.getEmail())){
            throw new RuntimeException("email já existe!");
        }

        User user = new User();
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setCompany(company);

        return userRepository.save(user);
    }
    //lista todos usuarios
    public List<User> listUser(){
        return userRepository.findAll();
    }

}

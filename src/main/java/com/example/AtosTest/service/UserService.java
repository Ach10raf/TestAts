package com.example.AtosTest.service;

import com.example.AtosTest.DTO.UserDto;
import com.example.AtosTest.DTO.UserTransformer;
import com.example.AtosTest.Exception.CountryNotAllowedException;
import com.example.AtosTest.Exception.UserNotAdultException;
import com.example.AtosTest.Exception.UserNotFoundException;
import com.example.AtosTest.entity.User;
import com.example.AtosTest.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;

@Service
public class UserService {

    private static final int AGE_MIN= 18 ;
    private static final String PAYS_AUTORISE ="France";


    private final UserRepository userRepository;
    private final UserTransformer usertransformer;

    public UserService(UserRepository userRepository, UserTransformer usertransformer){
         this.userRepository = userRepository;
        this.usertransformer = usertransformer;
    }


    public UserDto create(UserDto dto) {

        if (!dto.getCountry().equalsIgnoreCase(PAYS_AUTORISE)){
            throw new CountryNotAllowedException();
        }

        int age = Period.between(dto.getBirthdate(), LocalDate.now()).getYears();
        if (age < AGE_MIN){
            throw new UserNotAdultException();
        }

        User user = usertransformer.toEntity(dto);
        User saved = userRepository.save(user);

        return usertransformer.toDto(saved);
    }


    public UserDto getById(Long id){
        User user = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException());

        return usertransformer.toDto(user);
    }

}

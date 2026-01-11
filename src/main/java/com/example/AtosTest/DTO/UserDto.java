package com.example.AtosTest.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

        private Long id;

        @NotBlank
        private String username;

        @NotNull
        private LocalDate birthdate;

        @NotBlank
        private String country;

        private String phoneNumber;
        private String gender;

}

package com.example.AtosTest;

import com.example.AtosTest.DTO.UserDto;
import com.example.AtosTest.Exception.CountryNotAllowedException;
import com.example.AtosTest.Exception.UserNotAdultException;
import com.example.AtosTest.repository.UserRepository;
import com.example.AtosTest.DTO.UserTransformer;
import com.example.AtosTest.service.UserService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

	@Mock
	UserRepository repository;

	@Mock
	UserTransformer transformer;

	@InjectMocks
	UserService service;

	@Test
	void not_french() {
		UserDto dto = new UserDto();
		dto.setCountry("Maroc");
		dto.setBirthdate(LocalDate.of(2002, 1, 1));

		assertThrows(CountryNotAllowedException.class, () -> service.create(dto));
	}

	@Test
	void minor() {
		UserDto dto = new UserDto();
		dto.setCountry("France");
		dto.setBirthdate(LocalDate.now().minusYears(10));

		assertThrows(UserNotAdultException.class, () -> service.create(dto));
	}

}



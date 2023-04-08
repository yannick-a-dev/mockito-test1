package com.mocktotest.mockitotest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.mocktotest.mockitotest.entity.User;
import com.mocktotest.mockitotest.repository.UserRepository;
import com.mocktotest.mockitotest.service.UserService;

@RunWith(SpringRunner.class)
@SpringBootTest
class MockitoTestApplicationTests {

	@Autowired
	private UserService userService;

	@MockBean
	private UserRepository userRepository;

	@Test
	public void getUsersTest() {
		when(userRepository.findAll())
				.thenReturn(Stream.of(new User(376, "Essola", 31, "Cameroun"), new User(958, "Nouma", 40, "UK"))
						.collect(Collectors.toList()));
		assertEquals(2, userService.getUsers().size());
	}
	@Test
	public void getUserByAddressTest() {
		String address = "Yaounde";
		when(userRepository.findByAddress(address)).thenReturn(Stream.of(new User(376, "Essola", 31, "Cameroun"))
				.collect(Collectors.toList()));
		assertEquals(1, userService.getUserByAddress(address).size());
	}
	
	@Test
	public void saveUserTest() {
		User user = new User(999,"Nouma", 23, "Doula");
		when(userRepository.save(user)).thenReturn(user);
		assertEquals(user, userService.addUser(user));
	}
	
	@Test
	public void deleteUserTest() {
		User user = new User(999,"Nouma", 23, "Doula");
		userService.deleteUser(user);
		verify(userRepository,times(1)).delete(user);
	}

	@Test
	void contextLoads() {
	}

}

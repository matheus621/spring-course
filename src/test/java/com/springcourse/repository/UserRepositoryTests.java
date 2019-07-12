package com.springcourse.repository;

import java.util.Optional;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.springcourse.domain.User;
import com.springcourse.domain.enums.Role;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTests {
	
	@Autowired private UserRepository userRepository;
	
	public void saveTest() {
		User user = new User(null, "Matheus", "matheus621cardoso@gmail.com", "123", Role.ADMINISTRATOR, null, null);
		User createdUser = userRepository.save(user);
		
		assertThat(createdUser.getId()).isEqualTo(1L);
		
	}
	
	public void updateTest() {
		User user = new User(1L,"Matheus Cardoso", "matheus621cardoso@gmail.com", "123", Role.ADMINISTRATOR, null, null)
		User updateUser = userRepository.save(user);
		
		assertThat(updateUser.getName()).isEqualTo("Matheus Cardoso");
	}
	
	public void getByIdTest() {
		Optional<User> result = userRepository.findById(1L);	
		User user = result.get();
		
		assertThat(user.getPassword()).isEqualTo("123");
	}
	
	public void listTest() {
		
	}
	
	public void loginTest() {
		
	}

}

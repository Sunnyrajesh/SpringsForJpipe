package com.testing.SpringBootForDeployment;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.testing.SpringBootForDeployment.Repo.*;
import com.testing.SpringBootForDeployment.Controller.UserController;

import com.testing.SpringBootForDeployment.Model.*;
@SpringBootTest

class SpringBootForDeploymentApplicationTests {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private UserController userController;
	
	@Test
	void TestUser() {
		User user = new User();       
			
		user.setName("Pannam Rajesh");
	    user.setEmail("sunnyrajesh@gmail.com");
	    assertEquals("User added successfully", userController.addUser(user));  

		
	}
	@Test
	void testDeleteUser() {
	    long userId = 14; // Assuming user with ID 14 exists

	    if (userRepository.existsById(userId)) {
	        ResponseEntity<String> response = userController.deleteUser(userId);
	        assertEquals(HttpStatus.OK, response.getStatusCode());
	        assertEquals("User deleted successfully", response.getBody());
	    } else {
	        ResponseEntity<String> response = userController.deleteUser(userId);
	        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
	        assertEquals("User not found", response.getBody());
	    }
	}


}

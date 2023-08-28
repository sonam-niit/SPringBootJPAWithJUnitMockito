package com.scb.samplecrud;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.scb.samplecrud.entity.User;
import com.scb.samplecrud.service.UserService;

@SpringBootTest
class UserTestJUnit {

	@Autowired
	private UserService userService;

	@Test
	public void testAddUser() {
		// Create
		User newUser = new User("John Doe", "john@example.com", "123 Main St");
		User createdUser = userService.addUser(newUser);
		assertNotNull(createdUser);
		assertNotNull(createdUser.getId());
	}

	@Test
	public void testRetriveUser() {
		// Read
		User retrievedUser = userService.getUserById(4L);
		assertNotNull(retrievedUser);
		assertEquals("John Doe", retrievedUser.getName());
	}

	@Test
	public void testUpdateUser() {
		User updatedUser = userService.updateUser(new User("Jane Smith", "jane@example.com", "456 Elm St"), 4L);
		assertNotNull(updatedUser);
		assertEquals("Jane Smith", updatedUser.getName());
	}

	@Test
	public void testDeleteUser() {
		// Delete
		assertTrue(userService.deleteById(4L));
		assertFalse(userService.deleteById(4L)); // Second delete should return false

		assertNull(userService.getUserById(4L)); // User should no longer exist
	}
}

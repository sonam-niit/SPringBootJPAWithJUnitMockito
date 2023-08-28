package com.scb.samplecrud;

import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.scb.samplecrud.entity.User;
import com.scb.samplecrud.repo.UserRepository;
import com.scb.samplecrud.service.UserServiceImpl;


public class UserServiceTest {

	@Mock
	private UserRepository userRepo;
	@InjectMocks
	private UserServiceImpl userService;
	
	User u1=new User(1001L,"Krunal","a@a.com","India");
    User u2=new User(1002L, "Alex", "alex@gmail.com", "US");
    User u3=new User(1003L, "Mike", "mike@gmail.com", "UK");
    
	@BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }
	
	@Test
    public void getAllCustomers_success() {
        //Mock
        List<User> users=new ArrayList<>(Arrays.asList(u1,u2,u3));
        // It is my MOCK method to check what getAllCustomers() returns
        Mockito.when(userRepo.findAll()).thenReturn(users);  
        
        //When
        // Calling actual method of customerservice.getAllCustomers();
        List<User> userssReturned=userService.getAllUsers();   
        //Then
        Assertions.assertNotNull(userssReturned);
        Assertions.assertEquals(userssReturned.size(), 3);
        Assertions.assertEquals(userssReturned.get(1).getEmail(), "alex@gmail.com");
    }
	
	@Test
    public void getCustomerById_success() {
        //Mock
        User user=u3;                       
        Mockito.when(userRepo.findById(1003L)).thenReturn(Optional.of(user));
        //When
        User userReturned=userService.getUserById(1003L);
        //Then
        Assertions.assertNotNull(userReturned);
        //Assertions.assertEquals(customerReturned.getAccountCreationDate(), LocalDate.parse("2020-12-12"));
        Assertions.assertEquals(userReturned.getAddress(), "UK");
        Assertions.assertEquals(userReturned.getName(), "Mike");
    }
	
	@Test
    public void addUser_success() {
        //Mock
        User user=u1;
        Mockito.when(userRepo.save(user)).thenReturn(user);
        //When 
        User result=userService.addUser(user);
        //Then
        Assertions.assertNotNull(user);
        Assertions.assertEquals(user, result);
    }
	
	@Test
    public void updateUser_success() {
        User user=new User("Mike Devid","Mike@microsoft.com","Newyork US");
        user.setId(1003L);
        Mockito.when(userRepo.findById(1003L)).thenReturn(Optional.of(user));
        Mockito.when(userRepo.save(user)).thenReturn(user);
        
        User result=userService.updateUser(user,1003L);
        
        Assertions.assertNotNull(user);
        Assertions.assertEquals("Newyork US", result.getAddress());
        Assertions.assertEquals("Mike@microsoft.com", result.getEmail());
    }
	
	@Test
    public void deleteUser_success() {
		User userToDelete = new User();
		Mockito.when(userRepo.findById(1003L)).thenReturn(Optional.of(userToDelete));
		Mockito.doNothing().when(userRepo).deleteById(1003L);
        boolean result = userService.deleteById(1003L);
        
        Assertions.assertTrue(result);
        verify(userRepo, times(1)).findById(1003L);
        verify(userRepo, times(1)).deleteById(1003L);
    }
	@Test
    public void deleteUser_failed() {
		
		Mockito.when(userRepo.findById(1004L)).thenReturn(Optional.empty());
	
        boolean result = userService.deleteById(1004L);
        
        Assertions.assertFalse(result);
        verify(userRepo, times(1)).findById(1004L);
        verify(userRepo, never()).deleteById(anyLong());
    }
}



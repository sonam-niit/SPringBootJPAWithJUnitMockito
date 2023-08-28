package com.scb.samplecrud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.scb.samplecrud.entity.User;
import com.scb.samplecrud.service.UserService;
import com.scb.samplecrud.utility.APISuccessPayload;

@RestController
@RequestMapping("/api/user")
public class UserController {

	@Autowired
	UserService userService;
	
	@PostMapping
	public ResponseEntity<User> addNewUser(@RequestBody User user) {
		User newUser=userService.addUser(user);
		return new ResponseEntity<User>(newUser,HttpStatus.CREATED);
	}
	@GetMapping
	public ResponseEntity<APISuccessPayload> getAllUsers(){
		List<User> list= userService.getAllUsers();
		APISuccessPayload payload= new APISuccessPayload();
		payload.setBody(list);
		payload.setStatus(200);
		payload.setSuccess(true);
		payload.setException(false);
		payload.setMessage("Customer Found");
		
		ResponseEntity<APISuccessPayload> response = new ResponseEntity<APISuccessPayload>(payload,HttpStatus.OK);
        return response;
	}
	
//	@GetMapping
//	public ResponseEntity<List<User>> getAllUsers(){
//		return new ResponseEntity<List<User>>(userService.getAllUsers(),
//				HttpStatus.OK);
//	}
	@GetMapping("{id}")
	public ResponseEntity<Object> getUserById(@PathVariable Long id){
		User found= userService.getUserById(id);
		if(found!=null) {
			return new ResponseEntity<Object>(found,HttpStatus.OK);
		}else {
			return new ResponseEntity<Object>("User not Available with give Id",
					HttpStatus.NOT_FOUND);
		}
	}
	@DeleteMapping("{id}")
	public ResponseEntity<Object> deleteUserById(@PathVariable Long id){
		if(userService.deleteById(id)) {
			return new ResponseEntity<Object>("User Deleted Successfully",HttpStatus.OK);
		}else {
			return new ResponseEntity<Object>("User not Available with given Id to Delete",
					HttpStatus.NOT_FOUND);
		}
	}
	
	@PutMapping("{id}")
	public ResponseEntity<User> updateUserById(@RequestBody User user, @PathVariable Long id){
		
		return new ResponseEntity<User>(userService.updateUser(user, id),HttpStatus.OK);
		
	}
}






















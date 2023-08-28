package com.scb.samplecrud.service;

import java.util.List;

import com.scb.samplecrud.entity.User;

public interface UserService {

	//adduser, updateuser,deleteuser, getallusers, getuserbyid
	
	public User addUser(User user);
	public List<User> getAllUsers();
	public User getUserById(Long id);
	public boolean deleteById(Long id);
	public User updateUser(User user, Long id);
}

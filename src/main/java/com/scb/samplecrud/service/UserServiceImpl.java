package com.scb.samplecrud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scb.samplecrud.entity.User;
import com.scb.samplecrud.repo.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository repo;

	@Override
	public User addUser(User user) {
		return repo.save(user);
	}

	@Override
	public List<User> getAllUsers() {
		return repo.findAll();
	}

	@Override
	public User getUserById(Long id) {
		if (repo.findById(id).isPresent()) {
			return repo.findById(id).get();
		} else {
			return null;
		}
	}

	@Override
	public boolean deleteById(Long id) {
		if (repo.findById(id).isPresent()) {
			repo.deleteById(id);
			return true;
		} else {
			return false;
		}
	}

	@Override
	public User updateUser(User user, Long id) {
		User old = repo.findById(id).get();
		old.setAddress(user.getAddress());
		old.setName(user.getName());

		return repo.save(old);
	}

}

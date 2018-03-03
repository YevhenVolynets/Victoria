package ua.victoria.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import ua.victoria.app.entity.User;
import ua.victoria.app.repository.UserRepository;
import ua.victoria.app.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	private UserRepository userRepository;
	
	@Autowired
	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public void saveUser(User user) {
		userRepository.save(user);
	}

	@Override
	public List<User> findAllUsers() {
		
		return userRepository.findAll();
	}

	@Override
	public User findUserById(int id) {
		
		return userRepository.findOne(id);
	}

	@Override
	public User findUserByLogin(String login) {
		
		return userRepository.findUserByLogin(login);
	}

	
}

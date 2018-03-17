 package ua.victoria.app.service.impl;

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


import ua.victoria.app.entity.UserEntity;
import ua.victoria.app.repository.UserRepository;
import ua.victoria.app.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	
	private UserRepository userRepository;
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	public UserServiceImpl(UserRepository userRepository,PasswordEncoder passwordEncoder) {
		this.userRepository = userRepository;
		this.passwordEncoder = passwordEncoder;
	}

	@Override
	public void saveUser(UserEntity user) {
		String password = user.getPassword();
		user.setPassword(passwordEncoder.encode(password));
		userRepository.save(user);
	}

	@Override
	public List<UserEntity> findAllUsers() {
		
		return userRepository.findAll();
	}

	@Override
	public UserEntity findUserById(int id) {
		
		return userRepository.findOne(id);
	}

	@Override
	public UserEntity findUserByLogin(String login) {
		
		return userRepository.findUserByLogin(login);
	}

	@Override
	public void createFolder(UserEntity user) {
		String id = user.getId().toString();
		  File file = new File("D:\\tmp\\"+id);
	        if (!file.exists()) {
	            if (file.mkdir()) {
	                System.out.println("Directory is created!");
	            } else {
	                System.out.println("Failed to create directory!");
	            }
	        }
		
	}

	@Override
	public UserEntity findUserByEmail(String email) {
		
		return userRepository.findUserByEmail(email);
	}

	
}

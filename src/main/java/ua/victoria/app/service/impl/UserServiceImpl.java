 package ua.victoria.app.service.impl;

import java.io.File;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;



import ua.victoria.app.domain.mail.Mail;
import ua.victoria.app.entity.UserEntity;
import ua.victoria.app.repository.UserRepository;
import ua.victoria.app.service.EmailService;
import ua.victoria.app.service.UserService;
import ua.victoria.app.service.utils.TokenGenerator;

@Service
public class UserServiceImpl implements UserService{

	private EmailService emailService;
	private UserRepository userRepository;
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	public UserServiceImpl(UserRepository userRepository,PasswordEncoder passwordEncoder, EmailService emailService) {
		this.userRepository = userRepository;
		this.passwordEncoder = passwordEncoder;
		this.emailService = emailService;
	}

	@Override
	@Transactional
	public void saveUser(UserEntity user) {
		String password = user.getPassword();
		user.setPassword(passwordEncoder.encode(password));
		String token = TokenGenerator.generate(100);
		user.setToken(token);
		user.setActivated(false);
		
		userRepository.save(user);
		
		sendEmail(token, user);
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

	private void sendEmail(String token,UserEntity entity) {
		String domain = "http://localhost:8090/";
		Mail mail = new Mail();
		mail.setTo(entity.getEmail());
		mail.setSubject("You are successfully registered");
		mail.setContent("Please verify your email by this link "
		+domain
		+"/verify?token="
		+token+"&userid="
		+entity.getId());
		emailService.sendMessage(mail);
	}
	
}

package ua.victoria.app.service;

import java.util.List;


import ua.victoria.app.entity.UserEntity;

public interface UserService {
	
	void saveUser(UserEntity user);
	
	List<UserEntity> findAllUsers();
	
	UserEntity findUserById(int id);

	UserEntity findUserByLogin(String login);
	
	UserEntity findUserByEmail(String email);
	
	void updateUser(UserEntity user);

	void forgotPass(UserEntity entity);
	
	void updateAfterForgot(UserEntity user);

}

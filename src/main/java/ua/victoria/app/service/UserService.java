package ua.victoria.app.service;

import java.util.List;


import ua.victoria.app.entity.User;

public interface UserService {
	
void saveUser(User user);
	
	List<User> findAllUsers();
	
	User findUserById(int id);

	User findUserByLogin(String login);


}

package ua.victoria.app.mapper;

import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;

import ua.victoria.app.entity.UserEntity;



public interface UserMapper {

	public static User toSecurityUser(UserEntity user) {
		return new User(
				user.getEmail(),
				user.getPassword(),
				AuthorityUtils.createAuthorityList(String.valueOf(user.getUserRole()))
				);
		
	}
	
	
	
}

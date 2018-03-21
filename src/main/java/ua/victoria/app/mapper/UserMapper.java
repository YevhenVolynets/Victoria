package ua.victoria.app.mapper;

import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;



import ua.victoria.app.domain.RegisterRequest;
import ua.victoria.app.entity.UserEntity;
import ua.victoria.app.entity.UserRole;



public interface UserMapper {

	public static User toSecurityUser(UserEntity user) {
		return new User(
				user.getEmail(),
				user.getPassword(),
				AuthorityUtils.createAuthorityList(String.valueOf(user.getUserRole()))
				);
		
	}  
	public static UserEntity registerToEntity(RegisterRequest request) {
		UserEntity entity = new UserEntity();
		entity.setEmail(request.getEmail());
		entity.setPassword(request.getPassword());
		entity.setUserRole(UserRole.ROLE_USER);
		
		return entity;
	}
	
	
}

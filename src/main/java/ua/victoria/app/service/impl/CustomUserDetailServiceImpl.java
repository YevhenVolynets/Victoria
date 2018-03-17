package ua.victoria.app.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


import ua.victoria.app.entity.UserEntity;
import ua.victoria.app.mapper.UserMapper;
import ua.victoria.app.repository.UserRepository;



@Service("userDetailService")
public class CustomUserDetailServiceImpl implements UserDetailsService{

	@Autowired 
	private UserRepository userRepository;
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		UserEntity user = userRepository.findUserByEmail(email);
		if(user == null) throw new UsernameNotFoundException("User not found");
		
		return UserMapper.toSecurityUser(user);
	}

}

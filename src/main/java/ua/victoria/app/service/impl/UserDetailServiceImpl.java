package ua.victoria.app.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.victoria.app.entity.UserDetail;
import ua.victoria.app.repository.UserDetailRepository;
import ua.victoria.app.service.UserDetailService;

@Service
public class UserDetailServiceImpl implements UserDetailService{

	@Autowired
	private UserDetailRepository userDetailRepository; 
	
	@Override
	public void saveUserDetail(UserDetail userDetail) {
		
		userDetailRepository.save(userDetail);
	}

	@Override
	public UserDetail findById(int id) {
		
		return userDetailRepository.findOne(id);
	}

}

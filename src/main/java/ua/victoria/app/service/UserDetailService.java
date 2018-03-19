package ua.victoria.app.service;

import ua.victoria.app.entity.UserDetail;

public interface UserDetailService {
	 
	void saveUserDetail(UserDetail userDetail);
	
	UserDetail findById(int id);

}

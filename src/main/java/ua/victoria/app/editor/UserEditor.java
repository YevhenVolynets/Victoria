package ua.victoria.app.editor;

import java.beans.PropertyEditorSupport;

import ua.victoria.app.entity.User;
import ua.victoria.app.service.UserService;

public class UserEditor extends PropertyEditorSupport{
	
	private final UserService userService;

	public UserEditor(UserService userService) {
		this.userService = userService;
	}

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		User user = userService.findUserById(Integer.valueOf(text));
		setValue(user);
	}
	
	

}

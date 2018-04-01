package ua.victoria.app.service;

import java.util.List;

import ua.victoria.app.entity.Photo;

public interface PhotoService {
	
	void savePhoto(Photo photo);
	
	List<Photo> findllPhoto();
	
	List<Photo> findPhotoByTag(String tag);

}

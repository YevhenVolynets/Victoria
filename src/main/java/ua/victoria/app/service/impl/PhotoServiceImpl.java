package ua.victoria.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.victoria.app.entity.Photo;
import ua.victoria.app.repository.PhotoRepository;
import ua.victoria.app.service.PhotoService;

@Service
public class PhotoServiceImpl implements PhotoService{

	@Autowired
	private PhotoRepository photoRepository;
	
	@Override
	public void savePhoto(Photo photo) {
		photoRepository.save(photo);
		
	}

	@Override
	public List<Photo> findllPhoto() {
		
		return photoRepository.findAll();
	}

	@Override
	public List<Photo> findPhotoByTag(String tag) {
		
		return photoRepository.findPhotoByTag(tag);
	}

}

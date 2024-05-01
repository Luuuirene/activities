package com.activities_photo.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.activities_photo.model.PhotoRepository;
import com.activities_photo.model.PhotoVO;
import com.activity.hibernate.util.CompositeQuery.Photo_Compositegory;

@Service
public class PhotoService {
	
	@Autowired
	PhotoRepository photoRepository;
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public void addPhoto(PhotoVO photoVO) {
		photoRepository.save(photoVO);
		
	}
	
	public void updatePhoto(PhotoVO photoVO) {
		photoRepository.save(photoVO);
	}
	
	public void deletePhoto(Integer activityPhotoId) {
		if (photoRepository.existsById(activityPhotoId)) {
			photoRepository.deleteById(activityPhotoId);
		}
	}
	
	public PhotoVO getOnePhoto(Integer activityPhotoId) {
		Optional<PhotoVO> optional = photoRepository.findById(activityPhotoId);
		return optional.orElse(null);
	}
	
	public List<PhotoVO> getAll(){
		return photoRepository.findAll();
	}

	public List<PhotoVO> getAll(Map<String, String[]> map){
		return Photo_Compositegory.getAllPhotoVOs(map, sessionFactory.openSession());
	}
	
}

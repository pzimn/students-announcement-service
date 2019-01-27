package com.student.service.web.service.facade;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.student.service.web.model.Announcement;
import com.student.service.web.service.facade.api.AnnouncementService;

@Repository
public class AnnouncementServiceImpl implements AnnouncementService {

	@Override
	public Announcement findOne(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Announcement save(Announcement announcement) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Announcement announcement) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Announcement> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Announcement> findAllWithGivenCategory(Integer catId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Announcement> findAllDownParentCategory(Integer catId) {
		// TODO Auto-generated method stub
		return null;
	}


}

package com.student.service.web.service.facade;

import com.student.service.web.model.Announcement;
import com.student.service.web.repository.AnnouncementRepository;
import com.student.service.web.service.facade.api.AnnouncementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("announcementService")
@Transactional
public class AnnouncementServiceImpl implements AnnouncementService {

    @Autowired
    private AnnouncementRepository announcementRepository;

    @Override
    public Announcement findOne(Integer id) {
        return announcementRepository.findOne(id);
    }

    @Override
    public Announcement save(Announcement announcement) {
        return announcementRepository.save(announcement);
    }

    @Override
    public void update(Announcement announcement){
        save(announcement);
    }

    @Override
    public void deleteById(Integer id){
        announcementRepository.delete(id);
    }

    @Override
    public void deleteAll(){
        announcementRepository.deleteAll();
    }

    @Override
    public List<Announcement> findAll(){
        return announcementRepository.findAll();
    }

}

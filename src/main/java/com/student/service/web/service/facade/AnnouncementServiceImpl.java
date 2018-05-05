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

    public Announcement findById(Integer id) {
        return announcementRepository.findOne(id);
    }

    public void saveAnnouncement(Announcement announcement) {
        announcementRepository.save(announcement);
    }

    public void updateAnnouncement(Announcement announcement){
        saveAnnouncement(announcement);
    }

    public void deleteAnnouncementById(Integer id){
        announcementRepository.delete(id);
    }

    public void deleteAllAnnouncements(){
        announcementRepository.deleteAll();
    }

    public List<Announcement> findAllAnnouncements(){
        return announcementRepository.findAll();
    }

    public boolean isAnnouncementExist(Announcement announcement) {
        //return findByName(announcement.getName()) != null;
        return false; //todo
    }
}

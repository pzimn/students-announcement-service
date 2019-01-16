package managers;

import com.student.service.web.model.Announcement;

public interface UserManager {
    public boolean addAnnouncment();

    public boolean removeAnnouncement(int announcementId);

    public boolean modifyAnnouncement(int announcementId);

}

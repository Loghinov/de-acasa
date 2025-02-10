package org.deacasa.service.Impl;

import org.deacasa.entity.Notification;
import org.deacasa.repository.NotificationRepo;
import org.deacasa.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class NotificationServiceImpl implements NotificationService {
    private final NotificationRepo notificationRepo;
    @Autowired
    public  NotificationServiceImpl(NotificationRepo notificationRepo){this.notificationRepo=notificationRepo;}

    @Override
    public List<Notification> getAllNotifications() {
        return notificationRepo.findAll();
    }

    @Override
    public Notification getNotificationById(Long id) {
        return notificationRepo.findById(id)
                .orElseThrow(() ->new RuntimeException("Notification not found"));
    }

    @Override
    public Notification saveNotification(Notification notification) {
        return notificationRepo.save(notification);
    }

    @Override
    public Notification updateNotification(Long id, Notification notification) {
        Notification notification1=getNotificationById(id);
        notification1.setNotificationDateTime(notification.getNotificationDateTime());
        notification1.setUserId(notification.getUserId());
        notification1.setMessage(notification.getMessage());
        notification1.setReadStatus(notification.getReadStatus());
        return notificationRepo.save(notification);
    }

    @Override
    public void deleteNotification(Long id) {
        notificationRepo.deleteById(id);

    }
}

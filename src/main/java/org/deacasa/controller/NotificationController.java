package org.deacasa.controller;

import lombok.RequiredArgsConstructor;
import org.deacasa.entity.Notification;
import org.deacasa.service.NotificationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notifications")
@RequiredArgsConstructor
public class NotificationController {

    private final NotificationService notificationService;

    // Получение всех уведомлений
    @GetMapping("/get-all")
    public List<Notification> getAllNotifications() {
        return notificationService.getAllNotifications();
    }

    // Получение уведомления по ID
    @GetMapping("/get/{id}")
    public Notification getNotificationById(@PathVariable Long id) {
        return notificationService.getNotificationById(id);
    }

    // Создание нового уведомления
    @PostMapping("/save")
    public Notification saveNotification(@RequestBody Notification notification) {
        return notificationService.saveNotification(notification);
    }

    // Обновление уведомления
    @PutMapping("/update/{id}")
    public Notification updateNotification(@PathVariable Long id, @RequestBody Notification notification) {
        return notificationService.updateNotification(id, notification);
    }

    // Удаление уведомления
    @DeleteMapping("/delete/{id}")
    public void deleteNotification(@PathVariable Long id) {
        notificationService.deleteNotification(id);
    }
}

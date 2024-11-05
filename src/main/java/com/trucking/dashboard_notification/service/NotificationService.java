package com.trucking.dashboard_notification.service;

import com.trucking.dashboard_notification.model.Notification;
import com.trucking.dashboard_notification.repository.NotificationRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/***
 * Service class for managing notifications.
 * Provides methods for retrieving, saving, and deleting notifications.
 ***/
@Service
public class NotificationService {

    /*** Logger instance for logging actions within this service ***/
    private static final Logger logger = LoggerFactory.getLogger(NotificationService.class);

    /*** Repository dependency for accessing notification data ***/
    @Autowired
    private NotificationRepository notificationRepository;

    /***
     * Retrieves all notifications from the database.
     *
     * @return a list of all notifications
     ***/
    public List<Notification> findAll() {
        logger.info("Retrieving all notifications from the database");
        return notificationRepository.findAll();
    }

    /***
     * Retrieves a notification by its ID.
     *
     * @param id the ID of the notification to retrieve
     * @return an Optional containing the notification if found, or empty if not
     ***/
    public Optional<Notification> findById(Long id) {
        logger.info("Retrieving notification with ID: {}", id);
        return notificationRepository.findById(id);
    }

    /***
     * Saves a notification to the database.
     * If the notification has an ID, it will be updated; if not, a new notification will be created.
     *
     * @param notification the notification to save
     * @return the saved notification
     ***/
    public Notification save(Notification notification) {
        logger.info("Saving notification: {}", notification);
        return notificationRepository.save(notification);
    }

    /***
     * Deletes a notification by its ID.
     *
     * @param id the ID of the notification to delete
     ***/
    public void deleteById(Long id) {
        logger.info("Deleting notification with ID: {}", id);
        notificationRepository.deleteById(id);
    }
}

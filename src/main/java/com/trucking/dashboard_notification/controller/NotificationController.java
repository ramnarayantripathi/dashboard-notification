package com.trucking.dashboard_notification.controller;

import com.trucking.dashboard_notification.model.Notification;
import com.trucking.dashboard_notification.service.NotificationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/***
 * Controller class for managing notifications.
 * Provides REST endpoints for creating, retrieving, updating, and deleting notifications.
 ***/
@RestController
@RequestMapping("/api/notifications")
public class NotificationController {

    /*** Logger instance for logging activities in this controller ***/
    private static final Logger logger = LoggerFactory.getLogger(NotificationController.class);

    /*** Service layer dependency for handling notification operations ***/
    @Autowired
    private NotificationService notificationService;

    /***
     * Retrieves a list of all notifications.
     *
     * @return a list of all notifications
     ***/
    @GetMapping
    public List<Notification> getAllNotifications() {
        logger.info("Fetching all notifications");
        return notificationService.findAll();
    }

    /***
     * Retrieves a notification by its ID.
     *
     * @param id the ID of the notification to retrieve
     * @return the notification if found, or a 404 Not Found response if not
     ***/
    @GetMapping("/{id}")
    public ResponseEntity<Notification> getNotificationById(@PathVariable Long id) {
        logger.info("Fetching notification with ID: {}", id);
        return notificationService.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> {
                    logger.warn("Notification with ID: {} not found", id);
                    return ResponseEntity.notFound().build();
                });
    }

    /***
     * Creates a new notification.
     *
     * @param notification the notification to create
     * @return the created notification
     ***/
    @PostMapping
    public Notification createNotification(@RequestBody Notification notification) {
        logger.info("Creating new notification: {}", notification);
        return notificationService.save(notification);
    }

    /***
     * Updates an existing notification.
     *
     * @param id           the ID of the notification to update
     * @param notification the notification data to update
     * @return the updated notification if found, or a 404 Not Found response if the notification does not exist
     ***/
    @PutMapping("/{id}")
    public ResponseEntity<Notification> updateNotification(@PathVariable Long id, @RequestBody Notification notification) {
        logger.info("Updating notification with ID: {}", id);

        // Check if the notification with the specified ID exists
        if (!notificationService.findById(id).isPresent()) {
            logger.warn("Notification with ID: {} not found for update", id);
            return ResponseEntity.notFound().build();
        }

        // Set the ID of the notification to update
        notification.setId(id);

        // Save the updated notification
        Notification updatedNotification = notificationService.save(notification);
        logger.info("Notification with ID: {} updated successfully", id);

        return ResponseEntity.ok(updatedNotification);
    }

    /***
     * Deletes a notification by its ID.
     *
     * @param id the ID of the notification to delete
     * @return a 204 No Content response if the notification is successfully deleted,
     *         or a 404 Not Found response if the notification does not exist
     ***/
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNotification(@PathVariable Long id) {
        logger.info("Deleting notification with ID: {}", id);

        // Check if the notification with the specified ID exists
        if (!notificationService.findById(id).isPresent()) {
            logger.warn("Notification with ID: {} not found for deletion", id);
            return ResponseEntity.notFound().build();
        }

        // Delete the notification
        notificationService.deleteById(id);
        logger.info("Notification with ID: {} deleted successfully", id);

        return ResponseEntity.noContent().build();
    }
}

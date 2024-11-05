package com.trucking.dashboard_notification.repository;

import com.trucking.dashboard_notification.model.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

/***
 * Repository interface for Notification entities.
 * Extends JpaRepository to provide CRUD operations and additional JPA functionalities.
 ***/
public interface NotificationRepository extends JpaRepository<Notification, Long> {

    /***
     * JpaRepository provides standard CRUD operations:
     * - `findAll()`: Retrieve all notifications.
     * - `findById(Long id)`: Retrieve a notification by its ID.
     * - `save(Notification notification)`: Save or update a notification.
     * - `deleteById(Long id)`: Delete a notification by its ID.
     *
     * Additional custom queries can be defined here if needed.
     ***/

}

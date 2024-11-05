package com.trucking.dashboard_notification.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

/***
 * Entity class representing a notification.
 * Maps to the "notifications" table in the database.
 ***/
@Entity
@Table(name = "notifications")
@Getter
@Setter
public class Notification {

    /*** Unique identifier for each notification. ***/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /*** Title of the notification. ***/
    private String title;

    /*** Message content of the notification. ***/
    private String message;

    /***
     * Indicates whether the notification has been read.
     * Mapped to the "read" column in the database, with column name adjusted to avoid conflicts with reserved keywords.
     ***/
    @Column(name = "`read`") // Renamed to avoid conflict with SQL reserved keyword
    private boolean isRead;

    // Getters and Setters generated automatically by Lombok

    /***
     * Default constructor for the Notification entity.
     * Required by JPA specifications.
     ***/
    public Notification() {
        // Default constructor
    }

    /***
     * Parameterized constructor for creating a new Notification.
     *
     * @param title   the title of the notification
     * @param message the message content of the notification
     * @param isRead  the read status of the notification
     ***/
    public Notification(String title, String message, boolean isRead) {
        this.title = title;
        this.message = message;
        this.isRead = isRead;
    }
}

package com.lorena.api.topics;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Date;

@Entity
public class Topic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String message;
    private Date creationDate;
    private String status;
    private String author;
    private String course;

    // Constructors, getters, and setters

    public Topic(String title, String message, String author, String course) {
        this.title = title;
        this.message = message;
        this.author = author;
        this.course = course;
        this.creationDate = new Date();
        this.status = "NOT_ANSWERED";
    }

    public Topic() {
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getMessage() {
        return message;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public String getStatus() {
        return status;
    }

    public String getAuthor() {
        return author;
    }

    public String getCourse() {
        return course;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    @Override
    public String toString() {
        return "Topic{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", message='" + message + '\'' +
                ", creationDate=" + creationDate +
                ", status='" + status + '\'' +
                ", author='" + author + '\'' +
                ", course='" + course + '\'' +
                '}';
    }

}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

/**
 *
 * @author Nguyen Dep Trai
 */
public class FeedBack {

    private int feedbackID;
    private int userID;
    private int lesson_id;
    private int feedbackTypeID;
    private LocalDateTime  createAt;

    public FeedBack(int feedbackID, int userID, int lesson_id, int feedbackTypeID, LocalDateTime  createAt) {
        this.feedbackID = feedbackID;
        this.userID = userID;
        this.lesson_id = lesson_id;
        this.feedbackTypeID = feedbackTypeID;
        this.createAt = createAt;
    }

    public FeedBack(int userID, int lesson_id, int feedbackTypeID, LocalDateTime createAt) {
        this.userID = userID;
        this.lesson_id = lesson_id;
        this.feedbackTypeID = feedbackTypeID;
        this.createAt = createAt;
    }

    public int getFeedbackID() {
        return feedbackID;
    }

    public void setFeedbackID(int feedbackID) {
        this.feedbackID = feedbackID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public int getLesson_id() {
        return lesson_id;
    }

    public void setLesson_id(int lesson_id) {
        this.lesson_id = lesson_id;
    }

    public int getFeedbackTypeID() {
        return feedbackTypeID;
    }

    public void setFeedbackTypeID(int feedbackTypeID) {
        this.feedbackTypeID = feedbackTypeID;
    }

    public LocalDateTime getCreateAt() {
        return createAt;
    }

    public void setCreateAt(LocalDateTime  createAt) {
        this.createAt = createAt;
    }

    @Override
    public String toString() {
        return "FeedBack{" + "feedbackID=" + feedbackID + ", userID=" + userID + ", lesson_id=" + lesson_id + ", feedbackTypeID=" + feedbackTypeID + ", createAt=" + createAt + '}';
    }

}

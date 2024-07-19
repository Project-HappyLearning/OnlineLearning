/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Nguyen Dep Trai
 */
public class FeedBackType {
    private int feedbackTypeID;
    private String feedbackType, feedbackIcon;

    public FeedBackType(int feedbackTypeID, String feedbackType, String feedbackIcon) {
        this.feedbackTypeID = feedbackTypeID;
        this.feedbackType = feedbackType;
        this.feedbackIcon = feedbackIcon;
    }

    public int getFeedbackTypeID() {
        return feedbackTypeID;
    }

    public void setFeedbackTypeID(int feedbackTypeID) {
        this.feedbackTypeID = feedbackTypeID;
    }

    public String getFeedbackType() {
        return feedbackType;
    }

    public void setFeedbackType(String feedbackType) {
        this.feedbackType = feedbackType;
    }

    public String getFeedbackIcon() {
        return feedbackIcon;
    }

    public void setFeedbackIcon(String feedbackIcon) {
        this.feedbackIcon = feedbackIcon;
    }

    @Override
    public String toString() {
        return "FeedBackType{" + "feedbackTypeID=" + feedbackTypeID + ", feedbackType=" + feedbackType + ", feedbackIcon=" + feedbackIcon + '}';
    }
}

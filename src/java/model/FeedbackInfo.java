/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.time.LocalDateTime;

/**
 *
 * @author Nguyen Dep Trai
 */
public class FeedbackInfo {
    private String cusName, type, classes, courseTitle, module;
    private LocalDateTime date;

    public FeedbackInfo(String cusName, String type, String classes, String courseTitle, String module, LocalDateTime date) {
        this.cusName = cusName;
        this.type = type;
        this.classes = classes;
        this.courseTitle = courseTitle;
        this.module = module;
        this.date = date;
    }

    public String getCusName() {
        return cusName;
    }

    public void setCusName(String cusName) {
        this.cusName = cusName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getClasses() {
        return classes;
    }

    public void setClasses(String classes) {
        this.classes = classes;
    }

    public String getCourseTitle() {
        return courseTitle;
    }

    public void setCourseTitle(String courseTitle) {
        this.courseTitle = courseTitle;
    }

    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "FeedbackInfo{" + "cusName=" + cusName + ", type=" + type + ", classes=" + classes + ", courseTitle=" + courseTitle + ", module=" + module + ", date=" + date + '}';
    }
    
}

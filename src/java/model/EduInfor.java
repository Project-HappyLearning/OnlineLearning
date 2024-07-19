/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author admin
 */
public class EduInfor {
    private int id;
    private String title,linkInfor;

    public EduInfor(int id, String title, String linkInfor) {
        this.id = id;
        this.title = title;
        this.linkInfor = linkInfor;
    }

    public EduInfor() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLinkInfor() {
        return linkInfor;
    }

    public void setLinkInfor(String linkInfor) {
        this.linkInfor = linkInfor;
    }

    
    
}
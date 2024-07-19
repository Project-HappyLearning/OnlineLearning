/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import controller.auth.BaseAuthenticationController;
import dal.ContentDBContext;
import dal.LessonDBContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import model.Content;
import model.Lesson;

@WebServlet("/cousrse/contentLesson")
public class contentLessonController extends BaseAuthenticationController{


    protected void doPostProcess(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
    }


    protected void doGetProcess(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ContentDBContext coDB = new ContentDBContext();
        int lesson_id = Integer.parseInt(req.getParameter("lesson_id"));
        Content content = coDB.getContentByLessonId(lesson_id);
           LessonDBContext lDB = new LessonDBContext();
         Lesson lesson = lDB.get(lesson_id);
            req.setAttribute("lesson", lesson);
        req.setAttribute("content", content);
        req.getRequestDispatcher("./contentLesson.jsp").forward(req, resp);
    }

    @Override
    protected void processPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPostProcess(req, resp);
    }

    @Override
    protected void processGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGetProcess(req, resp);
    }
    
}
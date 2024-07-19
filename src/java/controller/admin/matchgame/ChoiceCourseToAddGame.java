/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller.admin.matchgame;

import controller.auth.BaseAuthorizationController;
import dal.CourseDBContext;
import dal.LessonDBContext;
import dal.ModuleDBContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import model.Account;
import model.Course;
import model.Lesson;
import model.Module;

@WebServlet("/admin/ChoiceCourseToAddGameImage")
public class ChoiceCourseToAddGame extends BaseAuthorizationController{

    @Override
    protected void processPost(HttpServletRequest req, HttpServletResponse resp, Account account) throws ServletException, IOException {
        int module_id = Integer.parseInt(req.getParameter("module"));
        LessonDBContext lDB = new LessonDBContext();
        ModuleDBContext mDB = new ModuleDBContext();
        Module module = mDB.get(module_id);
        ArrayList<Lesson> lessons = lDB.listLessonByModuleID(module_id);
        req.getSession().setAttribute("module_game", module);
        req.getSession().setAttribute("lessonsToAddGame", lessons);
        req.getRequestDispatcher("./choiceGameLession.jsp").forward(req, resp);
    }

    @Override
    protected void processGet(HttpServletRequest req, HttpServletResponse resp, Account account) throws ServletException, IOException {
        int course_id = Integer.parseInt(req.getParameter("course"));
        CourseDBContext cDB = new CourseDBContext();
        Course course = cDB.get(course_id);
        ModuleDBContext mDB = new ModuleDBContext();
        ArrayList<Module> modules = mDB.listModuleByCourseID(course_id);
        req.getSession().setAttribute("modulesToAddGame", modules);
        req.getSession().setAttribute("course_game", course);
        req.getRequestDispatcher("./choiceGameLession.jsp").forward(req, resp);
    }
    
}

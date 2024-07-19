/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller.auth;

import controller.payment.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import model.User;

@WebServlet("/signup/sendMail")
public class enterMailController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String regexEmail = "\\b[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}\\b";
        User newUser = (User) req.getSession().getAttribute("newUser");
        String recipient = newUser.getParent_email();
        if (recipient.matches(regexEmail)) {
            // Get recipient email address and message from form data
            String verifyCode = getRandomNumberString();
            String message = messageProcess(verifyCode);

            HttpSession verifyPremium = req.getSession();
            verifyPremium.setAttribute("verifyCode", verifyCode);
            verifyPremium.setMaxInactiveInterval(2*60);

            // Set up mail server and authentication
            String host = "smtp.gmail.com";
              String user = "luongndhe172441@fpt.edu.vn";
            String password = "crrc qgsy ytcr dqav";

            // Create properties object for the mail session
            Properties props = new Properties();
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.host", host);
            props.put("mail.smtp.port", "587");

            // Create mail session and authenticate with credentials
            Session session = Session.getInstance(props, new Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(user, password);
                }
            });

            try {
                // Create message and set recipient, subject, and message body
                Message msg = new MimeMessage(session);
                msg.setFrom(new InternetAddress(user));
                msg.setRecipient(Message.RecipientType.TO, new InternetAddress(recipient));
                msg.setSubject("Account Verification");
                msg.setContent(message, "text/html; charset=utf-8");

                // Send message
                javax.mail.Transport.send(msg);

                // Redirect to success page
                req.getRequestDispatcher("./confirmEmail.jsp").forward(req, resp);
            } catch (MessagingException e) {
                // Redirect to error page
                resp.getWriter().print("chúng tôi không thể gửi mã code đến email của bạn");
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String regexEmail = "\\b[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}\\b";
        User newUser = (User) req.getSession().getAttribute("newUser");
//        System.out.println(newUser.getParent_email());
        String recipient = newUser.getParent_email();
        if (recipient.matches(regexEmail)) {
            // Get recipient email address and message from form data
            String verifyCode = getRandomNumberString();
            String message = messageProcess(verifyCode);

            HttpSession verifyPremium = req.getSession();
            verifyPremium.setAttribute("verifyCode", verifyCode);
            verifyPremium.setMaxInactiveInterval(60);

            // Set up mail server and authentication
            String host = "smtp.gmail.com";
              String user = "luongndhe172441@fpt.edu.vn";
            String password = "crrc qgsy ytcr dqav";

            // Create properties object for the mail session
            Properties props = new Properties();
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.host", host);
            props.put("mail.smtp.port", "587");

            // Create mail session and authenticate with credentials
            Session session = Session.getInstance(props, new Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(user, password);
                }
            });

            try {
                // Create message and set recipient, subject, and message body
                Message msg = new MimeMessage(session);
                msg.setFrom(new InternetAddress(user));
                msg.setRecipient(Message.RecipientType.TO, new InternetAddress(recipient));
                msg.setSubject("Xác minh Account");
                msg.setContent(message, "text/html; charset=utf-8");

                // Send message
                javax.mail.Transport.send(msg);

                // Redirect to success page
                req.getRequestDispatcher("./confirmEmail.jsp").forward(req, resp);
            } catch (MessagingException e) {
                // Redirect to error page
                resp.getWriter().print("chúng tôi không thể gửi mã code đến email của bạn");
            }
        }
    }

    public static String getRandomNumberString() {
        // It will generate 6 digit random Number.
        // from 0 to 999999
        Random rnd = new Random();
        int number = rnd.nextInt(999999);

        // this will convert any number sequence into 6 character.
        return String.format("%06d", number);
    }

    /**
     *
     * @param verifyCode
     * @return
     */
    public static String messageProcess(String verifyCode) {
        String message = "Xin chào,\n"
                + "Đây là mã xác nhận để đăng ký tài khoản, vui lòng không chia sẻ cho bất kì ai\n"
                + "Mã xác nhận của bạn là: " + verifyCode;

        return message;
    }

}

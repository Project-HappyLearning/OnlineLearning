package controller.forgetPassword;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/forgetPassword/verifyCode")
public class VerifyCode extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }
    
    private void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String verifyCode = req.getParameter("confirm").trim();
        
        HttpSession session = req.getSession();
        String generatedCode = (String) session.getAttribute("passGen");
        
        if (verifyCode.equals(generatedCode)) {
            req.getRequestDispatcher("../forgetPassword/verifySuccessful.jsp").forward(req, resp);
        } else {
            req.getRequestDispatcher("../forgetPassword/verifyFail.jsp").forward(req, resp);
        }
    }
}

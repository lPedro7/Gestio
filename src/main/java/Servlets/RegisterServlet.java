package Servlets;


import Service.UserService;
import Service.UserServiceImplementation;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(value = "/register")
public class RegisterServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/jsp/register.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String user = req.getParameter("username");
        String pass = req.getParameter("password");
        String pass1 = req.getParameter("password1");
        UserService us = new UserServiceImplementation();


       if (us.checkUserExists(user)){
       }else {
           if (pass.equals(pass1)){
                us.createUser(user,pass);
               RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/jsp/login.jsp");
               dispatcher.forward(req, resp);
           }else {
               RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/jsp/register.jsp");
               dispatcher.forward(req, resp);
           }
       }

     //   RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/jsp/login.jsp");
      //  dispatcher.forward(req, resp);
    }


}

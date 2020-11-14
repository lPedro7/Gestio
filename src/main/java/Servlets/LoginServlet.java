package Servlets;


import DAO.NotaDAO;
import Java.Database;
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

@WebServlet(value = "/login")
public class LoginServlet extends HttpServlet {

    public static void main(String[] args) {
        UserService us = new UserServiceImplementation();
        System.out.println(us.checkLogin("pedro", "pedro"));
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/jsp/login.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String user = req.getParameter("username");
        String pass = req.getParameter("password");
        PrintWriter pw = resp.getWriter();
        UserService us = new UserServiceImplementation();

        pw.println(user);
        pw.println(pass);

        if (us.checkLogin(user, pass)) {
            pw.println("LOGIN OK");
        } else {
            pw.println("LOGIN NOT OK");
       }


     //   RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/jsp/login.jsp");
      //  dispatcher.forward(req, resp);
    }


}

package Servlets;


import Model.Nota;
import Service.NotaService;
import Service.NotaServiceImplementation;
import Service.UserService;
import Service.UserServiceImplementation;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

@WebServlet(value = "/mainpage")
public class MainPageServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/jsp/mainpage.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        LinkedList<Nota> notas = new LinkedList<Nota>();
        NotaService ns = new NotaServiceImplementation();

        int userId = (int) req.getAttribute("id");

        notas = ns.getNotas(userId);



    }


}

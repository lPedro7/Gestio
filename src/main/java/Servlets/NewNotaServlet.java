package Servlets;


import Model.Nota;
import Service.NotaService;
import Service.NotaServiceImplementation;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;

@WebServlet(value = "/newNote")
public class NewNotaServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/jsp/newNote.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        NotaService ns = new NotaServiceImplementation();
        String titulo = req.getParameter("titulo");
        String text = req.getParameter("text");
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        System.out.println(formatter.format(date));
        String creationDate = formatter.format(date);

        HttpSession session = req.getSession();
        int ownerId = (int) session.getAttribute("id");


        ns.createNota(titulo,text,ownerId,creationDate);

    }


}

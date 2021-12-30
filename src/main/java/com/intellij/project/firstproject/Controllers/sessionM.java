package com.intellij.project.firstproject.Controllers;

import org.springframework.boot.web.servlet.server.Session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/sessionM/*")
public class sessionM extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name=req.getParameter("name");
        String grad=req.getParameter("grad");
        String teach=req.getParameter("teach");
        req.getSession().setAttribute("na",name);
        req.getSession().setAttribute("grad",grad);
        req.getSession().setAttribute("teach",teach);
        req.getRequestDispatcher("/WEB-INF/display.jsp").forward(req,resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().invalidate();
        req.getRequestDispatcher("/WEB-INF/display.jsp").forward(req,resp);
    }
}

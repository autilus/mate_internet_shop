package com.nautilus.servlets;

import com.nautilus.factory.UserServiceFactory;
import com.nautilus.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/users")
public class UserServlet extends HttpServlet {
    private static final UserService userService = UserServiceFactory.getUserService();

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("users", userService.findAll());
        request.getRequestDispatcher("users.jsp").forward(request, response);
    }
}


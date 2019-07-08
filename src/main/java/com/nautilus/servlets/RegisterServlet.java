package com.nautilus.servlets;

import com.nautilus.factory.UserServiceFactory;
import com.nautilus.model.User;
import com.nautilus.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/register")
public class RegisterServlet extends HttpServlet {
    private UserService userService = UserServiceFactory.getUserService();
    private User user;
    private Long id = 1L;

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("register.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws IOException, ServletException {
        try {
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            String repeatPassword = request.getParameter("rpassword");
            if (password.equals(repeatPassword)) {
                user = new User();
                user.setLogin(email);
                user.setPassword(password);
                userService.save(user);
                request.getRequestDispatcher("users.jsp").forward(request, response);
            } else {
                request.setAttribute("email", email);
                request.setAttribute("error", "passwors are not equal.");
                request.getRequestDispatcher("register.jsp").forward(request, response);
            }
        } catch (NumberFormatException ex) {
            request.setAttribute("valid", "Enter the correct values.");
            request.getRequestDispatcher("register.jsp").forward(request, response);
        }
    }
}
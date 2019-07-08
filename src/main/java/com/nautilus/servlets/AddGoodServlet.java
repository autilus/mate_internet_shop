package com.nautilus.servlets;

import com.nautilus.factory.GoodServiceFactory;
import com.nautilus.model.Good;
import com.nautilus.service.GoodService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/addgood")
public class AddGoodServlet extends HttpServlet {
    private GoodService goodService = GoodServiceFactory.getProductService();
    private Good good;

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("addgood.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws IOException, ServletException {
        try {
            String name = request.getParameter("name");
            String description = request.getParameter("description");
            Double price = Double.valueOf(request.getParameter("price"));
            good = new Good();
            good.setName(name);
            good.setDescription(description);
            good.setPrice(price);
            goodService.save(good);
            request.getRequestDispatcher("goods.jsp").forward(request, response);
        } catch (NumberFormatException e) {
            request.setAttribute("valid", "Enter the correct values.");
            request.getRequestDispatcher("addgood.jsp").forward(request, response);
        }
    }
}

package com.nautilus.servlets;

import com.nautilus.factory.GoodServiceFactory;
import com.nautilus.service.GoodService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/goods")
public class GoodsServlet extends HttpServlet {
    private final GoodService goodService = GoodServiceFactory.getProductService();
    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("products", goodService.findAll());
        request.getRequestDispatcher("products.jsp").forward(request, response);
    }
}
<%@ page import="java.io.PrintWriter" %>
<%@ page import="java.util.List" %>
<%@ page import="com.nautilus.model.Good" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>All products</title>
</head>
<body>
<%
    PrintWriter printWriter = response.getWriter();
    printWriter.write("<center>\n<h3>All Products</h3>");
    printWriter.write("<button><a href=\"/addproduct\"> Add Product </a> </button>");
    printWriter.write("<button><a href=\"/users\"> All Users </a> </button>");
    printWriter.write("<table border = 1>" +
            "<tr>" +
            "<th> Name </th>" +
            "<th> Description </th>" +
            "<th> Price </th>" +
            "</tr>");
    List<Good> products = (List<Good>) request.getAttribute("products");
    if (!products.isEmpty()) {
        for (Good product : products) {
            printWriter.write("<tr>");
            printWriter.write("<td>" + product.getName() + "</td>");
            printWriter.write("<td>" + product.getDescription() + "</td>");
            printWriter.write("<td>" + product.getPrice() + "</td>");
            printWriter.write("</tr>");
        }
    }
    printWriter.write("</table>");
    printWriter.write("</center>");
%>
</body>
</html>
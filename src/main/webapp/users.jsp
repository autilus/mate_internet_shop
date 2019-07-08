<%@ page import="com.nautilus.model.User" %>
<%@ page import="java.io.PrintWriter" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>All users</title>
</head>
<body>
<%
    List<User> users = (List<User>) request.getAttribute("users");
    PrintWriter printWriter = response.getWriter();
    printWriter.write("<center>\n<h3>All Users</h3>");
    printWriter.write("<button><a href=\"/register\"> Registration </a> </button>");
    printWriter.write("<button><a href=\"/products\"> All Products </a> </button>");
    printWriter.write("<table border = 1>" +
            "<tr>" +
            "<th> Email </th>" +
            "<th> Password </th>" +
            "</tr>");
    if (!users.isEmpty()) {
        for (User user : users) {
            printWriter.write("<tr>");
            printWriter.write("<td>" + user.getLogin() + "</td>");
            printWriter.write("<td>" + user.getPassword() + "</td>");
            printWriter.write("</tr>");
        }
    }
    printWriter.write("</table>");
    printWriter.write("</center>");
%>
</body>
</html>
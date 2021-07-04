<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration</title>
</head>
<body>
<center>
    <h2>User Registration</h2>
    <%
        String error = (String) request.getAttribute("error");
        String valid = (String) request.getAttribute("valid");
        if (valid != null) {
            response.getWriter().write(valid);
        }
        if (error != null) {
            response.getWriter().write(error);
        }
    %>
    <form action="/register" method="post">
        Email:<br>
        <input type="email" name="email" value="${email}">
        <br>
        Password:<br>
        <input type="password" name="password" value="">
        <br>
        Repeat password:<br>
        <input type="password" name="rpassword" value="">
        <br><br>
        <input type="submit" value="Sign Up">
    </form>
</center>
</body>
</html>
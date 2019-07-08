<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add product</title>
</head>
<body>
<center>
    <h2>Add Product</h2>
    <%
        response.getWriter().write("<center>");
        String validFields = (String) request.getAttribute("valid");
        if (validFields != null) {
            response.getWriter().write(validFields);
        }
        response.getWriter().write("</center>");
    %>
    <form action="/addproduct" method="POST">
        Name:<br>
        <input type="text" name="name" value="">
        <br>
        Description:<br>
        <input type="text" name="description" value="">
        <br>
        Price:<br>
        <input name="price" type="number" step="0.01"/> <br>
        <br><br>
        <input type="submit" value="Add product">
    </form>
</center>
</body>
</html>
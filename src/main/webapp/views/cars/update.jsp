<%@ page import="se.distansakademin.models.Car" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% var car = (Car) request.getAttribute("car"); %>
<html>
<head>
    <title>Update car</title>
</head>
<body>

<h1>Update car</h1>



<form action="${pageContext.request.contextPath}/cars" method="post">
    <input type="text" name="make" placeholder="Make" value="<%= car.getMake() %>"> <br>
    <input type="text" name="model" placeholder="Model" value="<%= car.getModel() %>"> <br>

    <input type="hidden" name="action" value="update">
    <input type="hidden" name="id" value="<%= car.getId() %>">

    <button type="submit">Update</button>
</form>

<br>

<form action="${pageContext.request.contextPath}/cars" method="post">
    <input type="hidden" name="action" value="delete">
    <input type="hidden" name="id" value="<%= car.getId() %>">

    <input type="submit" value="Delete">
</form>

</body>
</html>

<%@ page import="se.distansakademin.models.Car" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Cars index</title>
</head>
<body>

<h1>Cars index</h1>

<% for (Car car : (List<Car>) request.getAttribute("cars")) { %>

    <p>
        <%= car.getMake() %>
        <%= car.getModel() %>
        <a href="?action=update&id=<%= car.getId() %>">Update</a>
    </p>

<% } %>

<br>

<a href="?action=create">Create car</a>

</body>
</html>

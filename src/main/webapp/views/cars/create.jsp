<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create car</title>
</head>
<body>

<h1>Create SOMETHING SOMETHING car</h1>

<form action="${pageContext.request.contextPath}/cars" method="post">
    <input type="text" name="make" placeholder="Make"> <br>
    <input type="text" name="model" placeholder="Model"> <br>
    <button type="submit">Create</button>
</form>

</body>
</html>

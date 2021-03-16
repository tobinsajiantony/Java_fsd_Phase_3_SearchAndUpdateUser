<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
<style>
table, th, td {
  border: 1px solid black;
}
</style>
</head>
<body>
<h2>Users</h2>

<form action="updateUser" method="post">
  <input type="hidden" id="id" name="id" value="${user.id}"><br>
  <label for="name">First name:</label><br>
  <input type="text" id="name" name="name" value="${user.name}"><br>
  <label for="email">Email:</label><br>
  <input type="text" id="email" name="email" value="${user.email}"><br>
  <label for="password">Password:</label><br>
  <input type="text" id="password" name="password" value="${user.password}"><br><br>
  <input type="submit" value="Update">
</form> 

</body>
</html>


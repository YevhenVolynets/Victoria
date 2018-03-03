<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 <link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
<title>User</title>
</head>
<body>

<h1>User List</h1>
<table class="table-striped" border="1">
 <c:forEach items="${usersList}"  var="user">
 
<tr><td>Login:</td> <td>${user.login}</td></tr>
<tr><td>Password:</td>  <td>${user.password}</td> </tr>
<tr><td>User role:</td>  <td>${user.userRole}</td> </tr>
<tr><td>&#032</td><td>	&#182</td></tr>
</c:forEach> 
</table>

</body>
</html>
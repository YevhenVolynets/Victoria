<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style>
.error{
	color:red;
}
</style>

<title>User Add</title>
</head>
<body>

<h1>Add User</h1>

<%-- <form:form 
		action="${pageContext.request.contextPath}/user/add"
		method="POST"
		modelAttribute="userModel">

 Login:     <form:input path="login" />	<form:errors  path="login" cssClass="error"/> <br>
 Password:  <form:password path="password"/> <form:errors  path="password" cssClass="error"/> <br>
 User role: <form:select path="userRole">
 <form:options items="${userRoles}"/>
 </form:select>
 <br>

<input type="submit" value="Create user">
</form:form>  --%>
 
</body>
</html>
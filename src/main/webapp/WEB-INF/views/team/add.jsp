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

<title>Insert title here</title>
</head>
<body>

<h1>Add Team</h1>

<form:form
		action="${pageContext.request.contextPath}/team/add"
		method="POST"
		modelAttribute="teamModel">

 Name Team: <form:input path="nameTeam"/>	<form:errors  path="nameTeam" cssClass="error"/> <br>

<input type="submit" value="Create team">
</form:form> 
 
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="..\taglib.jsp" %>
<div style="display: flex; justify-content: center;align-items: center;">
<div>
<h2 class="text-white">Add player</h2>
<form:form 
action="${pageContext.request.contextPath}/admin/addPlayer"
		method="POST"
		modelAttribute="add">
		
<p class="text-white">Ім`я:</p><form:input path="firstName"/><br>
<p class="text-white">Прізвище:</p><form:input path="lastName"/><br>
<p class="text-white">Номер на шортах:</p><form:input path="numberShirt"/><br>

<p class="text-white"> Позиція:</p> <form:select path="amplua">
			<form:options  items="${ampluaList}" itemLabel="amplua.val" />
</form:select>

<input type="submit" value="Відправити"/>

</form:form>

</div>
</div>
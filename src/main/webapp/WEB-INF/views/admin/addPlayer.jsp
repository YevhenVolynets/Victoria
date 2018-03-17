
<%@ include file="..\taglib.jsp" %>


<h2>Add player</h2>
<form:form 
action="${pageContext.request.contextPath}/admin/addPlayer"
		method="POST"
		modelAttribute="add">
Ім`я:<form:input path="firstName"/><br>
Прізвище:<form:input path="lastName"/><br>
Номер на шортах:<form:input path="numberShirt"/><br>

 Позиція: <form:select path="amplua">
			<form:options  items="${ampluaList}" itemLabel="amplua.val" />
<%--  <c:forEach var = "amplua1" items= "${ampluaList}">
<form:option  value="${amplua1.getAmplua().getVal()}"></form:option>
</c:forEach>  --%>
</form:select>

<input type="submit" value="Відправити"/>
</form:form>


<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/taglib.jsp" %>

<form:form action="${pageContext.request.contextPath}/admin/saveFootballer" method="POST" modelAttribute="onePlayer" cssStyle="margin-top:40px" >
<div class="panel panel-default">
  <div class="panel-heading">  <h2 align="center" style="color: white">${onePlayer.firstName}  ${onePlayer.lastName}</h2>  </div>
   <div class="panel-body">
<form:hidden path="id"/>
		

 <p>Кіл-сть матчів:</p> <form:input  path="statistics.countMatch"/> <br/><hr>
<p>Голи:</p> <form:input  path="statistics.goal"/><br/><hr> 
<p>Результативні паси:</p> <form:input path="statistics.assistPass"/> <br/><hr>
<p>Жовті картки:</p> <form:input path="statistics.countYellowCard"/> <br/><hr>
<p>Червоні картки:</p> <form:input path="statistics.countRedCard"/> <br/><hr>
<input type="submit" value="Зберегти" class="btn-lg"/>
</div>
</div>
</form:form>
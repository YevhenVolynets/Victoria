<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="..\taglib.jsp" %>

<form:form action="${pageContext.request.contextPath}/admin/saveCalendar" method="POST" modelAttribute="oneModel" cssStyle="margin-top:40px" >
<form:hidden path="id"/>
<p class="text-white">Номер туру:</p>  <form:input path="numberTour" /> <br/><hr>
<p class="text-white">Ліга:</p>
<form:select path="ligue">
<form:options  items="${ligueList}" itemLabel="val"/>
</form:select><br/><hr>
  <p class="text-white">Дата гри:</p> <input type="date" name="dateGame1" /><br/><hr> 
 <p class="text-white">Команда дома:</p> <form:input  path="teamHome.nameTeam" readonly="true"/> <br/><hr>
<p class="text-white">Команда в гостях:</p> <form:input  path="teamGuest.nameTeam" readonly="true"/><br/><hr> 
<p class="text-white">Рахунок(Господарі):</p> <form:input path="scoreHome"/> <br/><hr>
<p class="text-white">Рахунок(Гості):</p> <form:input path="scoreGuest"/> <br/><hr>
<input type="submit" value="Зберегти" class="btn-lg"/>

</form:form>

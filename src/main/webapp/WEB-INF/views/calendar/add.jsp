<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@ include file="/WEB-INF/views/taglib.jsp" %>
<br><br><br><br>


 <form:form action="${pageContext.request.contextPath}/admin/saveNewCalendar" method="POST" modelAttribute="calendarModel" cssStyle="margin-top:40px" >
 <p class="text-white">Номер туру:</p>  <form:input path="numberTour" /> <br/><hr>
 <p class="text-white">Ліга:</p>
 <form:select path="ligue">
 <form:options  items="${ligueList}"  itemLabel="val"/>
 </form:select><br/><hr>
  <p class="text-white">Дата гри:</p> <input type="date" name="date" /><br/><hr> 
  <p class="text-white">Команда дома:</p> 
 <form:select path="teamHome">
 <form:options  items="${teamsModel}" itemLabel="nameTeam" itemValue="id"/>
 </form:select><br/><hr> 
 <p class="text-white">Команда в гостях:</p>
 <form:select path="teamGuest">
 <form:options  items="${teamsModel}" itemLabel="nameTeam"  itemValue="id"/>
 </form:select><br/><hr> 

<p class="text-white">Рахунок(Господарі):</p> <form:input path="scoreHome"/> <br/><hr>
<p class="text-white">Рахунок(Гості):</p> <form:input path="scoreGuest"/> <br/><hr>
<input type="submit" value="Зберегти" class="btn-lg"/>

</form:form>

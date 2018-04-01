<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/taglib.jsp" %>
<br><br><br><br>
   <div class="btn btn-default">
   <a href="${rootURL}/admin/calendar/add">Додати</a>
   </div>

<table class="table table-stripped" style="color:white;margin-top:10px;">
<tr>
<th>Номер туру</th>
<th>Ліга</th>
<th>Дата гри</th>
<th>Команда дома-Команда в гостях</th>
<th>Рахунок</th>
<th></th>

</tr>
<c:forEach var="one" items="${calendarListModel}" >

 <tr>
<td>${one.numberTour }</td>
<td>${one.ligue.val }</td>
<td>${one.dateGame }</td>
<td>${one.teamHome.nameTeam } - ${one.teamGuest.nameTeam }</td>
<td>${one.scoreHome } - ${one.scoreGuest }</td>
<td>
<a href="${rootURL}/admin/calendar/edit?id=${one.id}">Редагувати</a>
</td>
</tr> 

</c:forEach>
</table>
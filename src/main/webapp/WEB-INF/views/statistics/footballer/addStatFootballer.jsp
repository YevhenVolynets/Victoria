<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="/WEB-INF/views/taglib.jsp" %>
<!DOCTYPE html>

<p class="text-white"> Команда:</p>
<form:form method="GET" action="${rootURL}/admin/addStatisticsPlayer">
<select id="mySelectId"  name="team" onchange="changeFunc()">
<c:forEach items="${teamssModel}" var="team">
<option  value="${team.id }">
${team.nameTeam}
</option>
</c:forEach>
</select>
<input type="submit" value="Знайти гравців"/>
</form:form>
<%-- <select id="mySelectId2"  >
<c:forEach items="${teamssModel[19].footballers}" var="player">
<option value="${player.id }">
${player.firstName} ${player.lastName}
</option>
</c:forEach>
</select> --%>

<script>
 selectedValue = null;
function changeFunc() {
	var selectBox = document.getElementById("mySelectId");
    selectedValue = selectBox.options[selectBox.selectedIndex].value;
  /*   alert(selectedValue); */
    
   }
</script>
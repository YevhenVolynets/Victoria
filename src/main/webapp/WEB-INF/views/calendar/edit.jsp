<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/taglib.jsp" %>

	<c:url var="firstUrl" value="${pageContext.request.contextPath}/admin/editCalendar/pages/1?field=${sortByField}&sort=${sortDirection}&total=${totalPerPage}" />
	<c:url var="lastUrl" value="${pageContext.request.contextPath}/admin/editCalendar/pages/${calendarList.totalPages}?field=${sortByField}&sort=${sortDirection}&total=${totalPerPage}" />
	<c:url var="prevUrl" value="${pageContext.request.contextPath}/admin/editCalendar/pages/${currentIndex - 1}?field=${sortByField}&sort=${sortDirection}&total=${totalPerPage}" />
	<c:url var="nextUrl" value="${pageContext.request.contextPath}/admin/editCalendar/pages/${currentIndex + 1}?field=${sortByField}&sort=${sortDirection}&total=${totalPerPage}" />


<br><br><br><br>
<div style="display:flex;justify-content: space-between;align-content: flex-end;">
   <div class="btn btn-default btn-lg" style="height: 50%;">
   <a href="${rootURL}/admin/calendar/add">Додати</a>
   </div>
<ul class="pagination">
			<c:choose>
				<c:when test="${currentIndex == 1}">
					<li class="disabled"><a href="#">&lt;&lt;</a></li>
					<li class="disabled"><a href="#">&lt;</a></li>
					<li class="disabled"><a href="${firstUrl}">1</a></li>
				</c:when>
				<c:otherwise>
					<li><a href="${firstUrl}">&lt;&lt;</a></li>
					<li><a href="${prevUrl}">&lt;</a></li>
				</c:otherwise>
			</c:choose>
			<c:forEach var="i" begin="${beginIndex}" end="${endIndex}">
				<c:url var="pageUrl" value="${pageContext.request.contextPath}/admin/editCalendar/pages/${i+1}" />
				<c:choose>
					<c:when test="${i+1 == currentIndex}">
						<li class="disabled"><a href="${pageUrl}?field=${sortByField}&sort=${sortDirection}&total=${totalPerPage}"><c:out value="${i+1}" /></a></li>
					</c:when>
					<c:otherwise>
						<li><a href="${pageUrl}?field=${sortByField}&sort=${sortDirection}&total=${totalPerPage}"><c:out value="${i+1}" /></a></li>
					</c:otherwise>
				</c:choose>
			</c:forEach>

			<c:choose>
				<c:when test="${currentIndex == calendarList.totalPages}">
					<li class="disabled"><a href="#">&gt;</a></li>
					<li class="disabled"><a href="#">&gt;&gt;</a></li>
				</c:when>
				<c:otherwise>
					<li><a href="${nextUrl}">&gt;</a></li>
					<li><a href="${lastUrl}">&gt;&gt;</a></li>
				</c:otherwise>
			</c:choose>
		</ul>
		
		
		<form method="get" class="form-inline form-group">
			<div class="form-group">
				<label class="sr-only" for="sortByField">Sort By Field</label> 
				<select class="form-control" id="sortByField" name = "field">
					<option value="${sortByField}">${sortByField}</option>
					<option value="id">id</option>
					<option value="teamHome">Команда-господар</option>
					<option value="teamGuest">Команда-гість</option>
					<option value="dateGame">Дата</option>
					<option value="scoreHome">Рахунок вдома</option>
					<option value="scoreGuest">Рахунок в гостях</option>
				</select>
				
				<label class="sr-only" for="sortBy">Sort By</label> 
				<select class="form-control" id="sortBy" name = "sort">
					<option value="${sortDirection}">${sortDirection}</option>
					<option value="asc">ASC</option>
					<option value="desc">DESC</option>
				</select>
				
				<label class="sr-only" for="elementsBy">Results by page</label> 
				<select class="form-control" id="elementsBy" name = "total">
					<option value="${totalPerPage}">${totalPerPage}</option>
					<option value="10">10</option>
					<option value="15">15</option>
					<option value="20">20</option>
					<option value="30">30</option>
				</select>
				<input type="submit" value="Sort" class="btn btn-primary">
			</div>
		</form>
		
	</div>	
<table class="table table-stripped exotic-table" style="color:white;margin-top:10px;">
<thead>
<th>Номер туру</th>
<th>Ліга</th>
<th>Дата гри</th>
<th>Команда дома-Команда в гостях</th>
<th>Рахунок</th>
<th></th>

</thead>
<c:forEach var="one" items="${calendarListByPageSize}" >

 <tbody>
<td>${one.numberTour }</td>
<td>${one.ligue.val }</td>
<td>${one.dateGame }</td>
<td>${one.teamHome.nameTeam } - ${one.teamGuest.nameTeam }</td>
<td>${one.scoreHome } - ${one.scoreGuest }</td>
<td>
<a href="${rootURL}/admin/calendar/edit?id=${one.id}">Редагувати</a>
</td>
</tbody> 

</c:forEach>
</table>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/taglib.jsp" %>

<table class="table  exotic-table">
				
				<tr class="panel-heading">
					<th>Номер</th>
					<th>Футболіст</th>
					<th>Позиція</th>
					<th>Кіл-сть матчів</th>
					<th>Кіл-сть голів</th>
					<th>Кіл-сть пасів</th>
					<th>Кіл-сть ж. к.</th>
					<th>Кіл-сть ч. к.</th>
					<th></th>
					

				</tr>
				

				<tbody class="panel-body">
					<c:forEach var="player" items="${listPlayer}">
						<tr onclick="window.location.href=''; return false">
							<td>${player.numberShirt}</td>
							<td>${player.firstName} ${player.lastName}</td> 
							 <td>${player.amplua.amplua.val}</td> 
							<td>${player.statistics.countMatch}</td>
							<td>${player.statistics.goal}</td>
							<td>${player.statistics.assistPass}</td>
							<td>${player.statistics.countYellowCard}</td>
							<td>${player.statistics.countRedCard}</td>
							<td><a href="${rootURL}/admin/footballer/statistics/edit?id=${player.id}">Редагувати</a></td>
						</tr>
					</c:forEach>
					</tbody>
			</table>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ include file="/WEB-INF/views/taglib.jsp" %>
     
     <br><br>
     <div class="btn btn-lg" onclick="window.location.href='/team/${oneTeam.id}/map'; return false" style="background-color: black;color:white">Відкрити мапу</div>>
     
     <h2 align="center" style ="color:white">Загальна статистика</h2>
<table class="table table-bordered table-responsive" style="font-size: 20px; text-align: center ;">
<thead>
      <tr class="active">
        <th>Ліга</th>
        <th>Позиція</th>
        <th>Кіл-сть ігор</th>
        <th>Виграшів</th>
        <th>Нічий</th>
        <th>Програшів</th>
        <th>Забито/Пропущено</th>
        <th>Очки</th>
        
        
      </tr>
    </thead>
    <tbody>
      <tr class="info">
        <td>${oneTeam.statistics.ligue.val}</td>
        <td>${oneTeam.statistics.ratingPosition}</td>
        <td>${oneTeam.statistics.countMatch}</td>
        <td>${oneTeam.statistics.winMatch}</td>
         <td>${oneTeam.statistics.drawMatch}</td>
          <td>${oneTeam.statistics.loseMatch}</td>
        <td>${oneTeam.statistics.scoredGoal}-${oneTeam.statistics.missedGoal}</td>
         <td>${oneTeam.statistics.point}</td> 
      </tr>
    </tbody>
    </table>
    
    <br><br>
      <h2 align="center" style ="color:white">Проведені матчі</h2>
    
    <table class="table table-bordered table-responsive" style="font-size: 20px; text-align: center ;">
<thead>
      <tr class="active">
        <th>Номер туру</th>
        <th>Дата</th>
        <th>Команда дома</th>
        <th>Рахунок</th>
        <th>Команда гості</th>
        

      </tr>
    </thead>
    <tbody>
<c:forEach  var="game" items="${gameHome}" >
<tr class="info">
<td>${game.numberTour }</td>
<td>${game.dateGame }</td>
<td>${game.teamHome.nameTeam }</td>
<td>${game.scoreHome } - ${game.scoreGuest }</td>
<td>${game.teamGuest.nameTeam }</td>

</tr>
</c:forEach>
<c:forEach  var="game" items="${gameGuest}" >
<tr class="info">
<td>${game.numberTour }</td>
<td>${game.dateGame }</td>
<td>${game.teamHome.nameTeam }</td>
<td>${game.scoreHome } - ${game.scoreGuest }</td>
<td>${game.teamGuest.nameTeam }</td>

</tr>
</c:forEach>
</tbody>
</table>
<br><br>
      <h2 align="center" style ="color:white">Статистика гравців</h2>

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
					

				</tr>
				

				<tbody class="panel-body">
					<c:forEach var="player" items="${bombardirs}">
						<tr onclick="window.location.href=''; return false">
							<td>${player.numberShirt}</td>
							<td>${player.firstName} ${player.lastName}</td> 
							 <td>${player.amplua.amplua.val}</td> 
							<td>${player.statistics.countMatch}</td>
							<td>${player.statistics.goal}</td>
							<td>${player.statistics.assistPass}</td>
							<td>${player.statistics.countYellowCard}</td>
							<td>${player.statistics.countRedCard}</td>
						</tr>
					</c:forEach>
					</tbody>
			</table>
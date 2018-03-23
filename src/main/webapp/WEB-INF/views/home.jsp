<%@ include file="taglib.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<style>
.news-comments-icon {
    background: url(https://www.ua-football.com/imgs/comment.svg) no-repeat;
    padding-left: 15px;
    font-size: 11px;
    font-weight: 700;
    color: #bbc0c2;
}
.listNews{
border: 1px solid black;
color:green;
width: 300px;
margin: 10px;
text-align: left;

}
</style>
     
 <div class="row firstRow " style="display:flex; justify-content:space-between; ;align-items: center;">

 
<div class="panel panel-default listNews">
  <div class="panel-heading">  <h4 >Новини</h4>  </div>
   <div class="panel-body">
       
 
<c:forEach items="${list1}" var="oneLink">
${oneLink}

</c:forEach>


</div>
</div>

<div><iframe width="560" height="315" src="https://www.youtube.com/embed/-OFmUZ-eH1Y" frameborder="1" allow="autoplay; encrypted-media" allowfullscreen></iframe></div>
</div>

<div style="width: 500px">
<div class="mytable">
		<div class="panel panel-default text-center">


			<table class="table  exotic-table">
				
				<tr class="panel-heading" style="text-align: center;"> 
					<th>П</th>
					<th>Команда</th>
					<th>І</th>
					<th>В</th>
					<th>Н</th>
					<th>П</th>
					<th>M</th>
					
					<th>O</th>

				</tr>
				

				<tbody class="panel-body">
					<c:forEach var="stat" items="${listStat2}">
						<tr>
							<td>${stat.ratingPosition}</td>
							<td>${stat.team.nameTeam}</td>
							<td>${stat.countMatch}</td>
							<td>${stat.winMatch}</td>
							<td>${stat.drawMatch}</td>
							<td>${stat.loseMatch}</td>
							<td>${stat.scoredGoal} - ${stat.missedGoal}</td>
							<td>${stat.point}</td>
						</tr>
					</c:forEach>
					</tbody>
			</table>
		</div>

</div>

</div>


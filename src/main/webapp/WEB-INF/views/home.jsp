<%@ include file="taglib.jsp"%>
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

.listNews {
	border: 1px solid black;
	color: green;
	width: 300px;
	margin: 10px;
	text-align: left;
}
</style>

 <div class=""
	style="display: flex; justify-content: space-between;; align-items: center;"> 

<!-- start pars -->
	<div class="panel panel-default listNews">
		<div class="panel-heading">
			<h4>Новини світу</h4>
		</div>
		<div class="panel-body">


			<c:forEach items="${list1}" var="oneLink">
${oneLink}

</c:forEach>


		</div>
	</div>
<!-- end pars -->

<!-- start news -->
	
		<c:forEach items="${mainnews}" var="post">
		<div class="post" style="width: 30%; border: 5px outset gray; border-radius: 10px; background: rgba(44,36,44,0.5);text-align: center;">
			<!-- <div class="col-sm-6 col-md-4"> -->
				<div class="blog-box">
					<div class="blog-box-image">
						<img src="data:img/png; base64, ${post.pathToFoto}"
							class="img-responsive" alt="">
					</div>
					<div class="blog-box-content">
						<h4>
							<a href="#" style="color: white">${post.title}</a>
						</h4>
						<a href="${rootURL}/news/${post.id}"
							class="btn btn-default site-btn">Read More</a>
					</div>
				</div>
			<!-- </div> -->

</div>

		</c:forEach>
	
<!-- end news -->
</div> 



	<!-- <div><iframe width="560" height="315" src="https://www.youtube.com/embed/-OFmUZ-eH1Y" frameborder="1" allow="autoplay; encrypted-media" allowfullscreen></iframe></div>
</div> -->

<div style="display: flex; justify-content: space-around; align-items: center;">

<!-- start team point -->
<div style="width: 40%; font-size: 20px">
	<div class="mytable">
		<div class="panel panel-default text-center">


			<table class="table  exotic-table" >



	<thead class="panel-heading" style="text-align: center;">
				<i>Турнірна таблиця</i>
				</thead>
				<thead class="panel-heading" style="text-align: center;">
					<th>П</th>
					<th>Команда</th>
					<th>І</th>
					<th>В</th>
					<th>Н</th>
					<th>П</th>
					<th>M</th>

					<th>O</th>

				</thead>


				<tbody class="panel-body">
					<c:forEach var="stat" items="${listStat2}">
						<tr
							onclick="window.location.href='/team/${stat.id}'; return false">
							<td>${stat.ratingPosition}</td>
							<td>${stat.team.nameTeam}</td>
							<td>${stat.countMatch}</td>
							<td>${stat.winMatch}</td>
							<td>${stat.drawMatch}</td>
							<td>${stat.loseMatch}</td>
							<td>${stat.scoredGoal}- ${stat.missedGoal}</td>
							<td>${stat.point}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>

	</div>

</div>
<!-- end team point -->

<!-- start table goals -->
	<table class="table  exotic-table" style="width: 30%; font-size: 20px">
		<tr>
			<td>Топ-5 голеадорів клубу</td>
		</tr>
		<c:forEach var="player" items="${footballtat}">

			<tr onclick="window.location.href=''; return false">

				<td><img src="/resources/img/soccer_ball.ico" width="20%" />
					${player.firstName} ${player.lastName}:<br>
					${player.statistics.goal} голів в ${player.statistics.countMatch}
					матчах</td>

			</tr>
		</c:forEach>

	</table>
<!-- end table goals -->

</div>

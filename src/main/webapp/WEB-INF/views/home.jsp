<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Home page</title>
<%-- <link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" rel="stylesheet"> --%>  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"> </script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"> </script>

    <title>Starter Template for Bootstrap</title>
    
    <style>
.navbar{
    margin-bottom: 0;
    border-radius: 0;
}
.footer{
    background-color: black;
    color: white;
    padding: 15px;
}
.context{
	background-color: azure;
    height: 600px;
}
.imgVictoria{
	height: 400%;
    margin-top: -10px;
}
</style>
</head>
<body>

 <nav class="navbar navbar-inverse" role="navigation">
	<!-- Brand and toggle get grouped for better mobile display -->
	<div class="navbar-header">
		<button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse">
			<span class="sr-only">Toggle navigation</span>
			<span class="icon-bar"></span>
			<span class="icon-bar"></span>
			<span class="icon-bar"></span>
		</button>
		<a class="navbar-brand" href="#"><img  class="imgVictoria" src="https://srv3.imgonline.com.ua/result_img/imgonline-com-ua-Transparent-backgr-N9MxD1pyQhesiwU.png" alt="ico"></a>
	</div>

	<!-- Collect the nav links, forms, and other content for toggling -->
	<div class="collapse navbar-collapse navbar-ex1-collapse">
		<ul class="nav navbar-nav">
			<li class="dropdown active">
				<a href="#" class="dropdown-toggle" data-toggle="dropdown">ГОЛОВНА <b class="caret"></b></a>
				<ul class="dropdown-menu">
					<li><a href="#">Новини</a></li>
					<li><a href="#">Фото</a></li>
					<li><a href="#">Відео</a></li>
					<li><a href="#">Соціальні мережі</a></li>
				</ul>
			</li>
			<li class="dropdown">
				<a href="#" class="dropdown-toggle" data-toggle="dropdown">КОМАНДИ <b class="caret"></b></a>
				<ul class="dropdown-menu">
					<li><a href="#">Вікторія - 2004</a></li>
					<li><a href="#">Вікторія - 2009</a></li>
					
				</ul>
			</li>
			<li class="dropdown">
				<a href="#" class="dropdown-toggle" data-toggle="dropdown">МАТЧІ <b class="caret"></b></a>
				<ul class="dropdown-menu">
					<li><a href="#">Останній матч</a></li>
					<li><a href="#">Турнірна таблиця</a></li>
					<li><a href="#">Статистика гравців</a></li>
				</ul>
			</li>
			
            <li class="dropdown">
				<a href="#" class="dropdown-toggle" data-toggle="dropdown">КЛУБ <b class="caret"></b></a>
				<ul class="dropdown-menu">
					<li><a href="#">Керівництво</a></li>
					<li><a href="#">Історія</a></li>
					<li><a href="#">Символіка</a></li>
					<li><a href="#">Контакти</a></li>
				</ul>
			</li>
			<li><a href="#">МАГАЗИН</a></li>
			
		</ul>
		 <ul class="nav navbar-nav navbar-right">
      <li><a href="#" role="button"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
      <!--<li><a data-toggle="pill" href="#menu1">Вхід</a></li>-->
      <li><a href="#" role="button"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
   <!--<li><a data-toggle="pill" href="#menu2">Реєстрація</a></li>-->
    </ul>
		
	</div><!-- /.navbar-collapse -->
</nav>

<div class="container-fluid text-center">
<div class="row context">
<h1>Hello world</h1>
</div>
</div>

<footer class = "footer text-center">
	<p>Footer text</p>
</footer>

</body>
</html>

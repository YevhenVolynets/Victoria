<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
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
 .navbar {
            margin-bottom: 0;
            border-radius: 0;
        }

        .footer {
            background-color: black;
            color: white;
            padding: 15px;
            display: flex;
            justify-content: space-between;
            font-family: cursive;
            font-size: 12px;
        }

        .context {
            background-color: azure;
            height: 600px;
        }

        .imgVictoria {
            height: 400%;
            margin-top: -10px;
            margin-right: 10px;


        }

        .headerText {
            width: 160px;
            text-align: center;
        }
        
        .firstRow{
            margin-top: 0px;
            height: 900px;
        }
        
        .backfoto{
            background-image: url(https://cdn1.img.rsport.ru/images/110049/35/1100493585.jpg);
            background-repeat: no-repeat;
            background-size: cover;
           
        }
        
        .mylogin{
            width: 300px;
            
        }
        
        .myRegisration{
            width: 300px;
          
        }
        .dropdown-menu {
            background-color: dimgrey;
            
        }
        .dropdown-menu>li>a{
            color: azure;
            font-size: 16px;
            margin: 10px 0 10px 0;
        }
        
        .panel-default>.panel-heading{
           background-color:#363636; 
            border-color: black;
            text-align: center;
            color: azure;
        }
        .error{
	color:red;
	font-style: italic;
	font-size: 16px;
	font-weight: bold;
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
		<a class="navbar-brand" href="/"><img  class="imgVictoria" src="http://preview.ibb.co/nh3aSn/imgonline_com_ua_Transparent_backgr_6_NWv_Tw_AL9j.png" alt="ico"></a>
	</div>

	<!-- Collect the nav links, forms, and other content for toggling -->
	<div class="collapse navbar-collapse navbar-ex1-collapse">
		<ul class="nav navbar-nav">
			<li class="dropdown  headerText">
				<a href="#" class="dropdown-toggle" data-toggle="dropdown">ГОЛОВНА <b class="caret"></b></a>
				<ul class="dropdown-menu">
					<li><a href="${pageContext.request.contextPath}/news/">Новини</a></li>
					<li><a href="${pageContext.request.contextPath}/photos">Фото</a></li>
					<li><a href="${pageContext.request.contextPath}/video">Відео</a></li>
					<li><a href="${pageContext.request.contextPath}/social">Соціальні мережі</a></li>
				</ul>
			</li>
			
			<li class="dropdown headerText">
				<a href="#" class="dropdown-toggle" data-toggle="dropdown">КОМАНДИ <b class="caret"></b></a>
				<ul class="dropdown-menu">
					<li><a href="${pageContext.request.contextPath}/victoria-2004">Вікторія - 2004</a></li>
					<li><a href="${pageContext.request.contextPath}/victoria-2009">Вікторія - 2009</a></li>
					
				</ul>
			</li>
			<li class="dropdown headerText">
				<a href="#" class="dropdown-toggle" data-toggle="dropdown">МАТЧІ <b class="caret"></b></a>
				<ul class="dropdown-menu">
					<li><a href="#">Останній матч</a></li>
					<li><a href="#">Турнірна таблиця</a></li>
					<li><a href="#">Статистика гравців</a></li>
				</ul>
			</li>
			
            <li class="dropdown headerText">
				<a href="#" class="dropdown-toggle" data-toggle="dropdown">КЛУБ <b class="caret"></b></a>
				<ul class="dropdown-menu">
					<li><a href="${pageContext.request.contextPath}/leadership">Керівництво</a></li>
					<li><a href="${pageContext.request.contextPath}/history">Історія</a></li>
					<li><a href="${pageContext.request.contextPath}/symbols">Символіка</a></li>
					<li><a href="${pageContext.request.contextPath}/contacts">Контакти</a></li>
				</ul>
			</li>
			<li class="headerText"><a href="${pageContext.request.contextPath}/shop">МАГАЗИН</a></li>
			
		</ul>
	<ul class="nav navbar-nav navbar-right">
                <li><a href="#" role="button" class="dropdown-toggle" data-toggle="dropdown"><span class="glyphicon glyphicon-user"></span> Sign Up</a>
                <div class="login-panel panel panel-default dropdown-menu myRegisration" >
                    <div class="panel-heading">
                        <h3 class="panel-title">Sign Up</h3>
                    </div>
                    <div class="panel-body">
                        <form:form
		action="${pageContext.request.contextPath}/"
		method="POST"
		modelAttribute="userModelka">
                            <fieldset>
                               <div class="form-group">
                                
                                    <input class="form-control" placeholder="Username" name="login" type="text" autofocus="">
                                    <%-- <form:input path="login" />	 --%><form:errors  path="login" cssClass="error"/>
                                </div>
                                <div class="form-group">
                                    <input class="form-control" placeholder="E-mail" name="email" type="email" autofocus="">
                                  <%--   <form:input path="email" />	 --%>
                                </div>
                                <div class="form-group">
                                    <input class="form-control" placeholder="Password" name="password" type="password" value="">
                                	<%-- <form:password path="password"/> --%><form:errors  path="password" cssClass="error"/>
                                </div>
                                <div class="form-group">
                                    <input class="form-control" placeholder=" Confirm Password" name="password2" type="password" value="">
                                </div>
                                
                                <input type="submit" class="btn btn-sm btn-success" style="margin-left: 25%;width: 50%" value="Register now"/>
                                
                                 
                            </fieldset>
                        </form:form>
                    </div>
                </div>
                
                </li>
                
                <li class="dropdown"><a href="#" role="button" class="dropdown-toggle" data-toggle="dropdown" ><span class="glyphicon glyphicon-log-in"></span> Login</a>

                
                <div class="login-panel panel panel-default dropdown-menu mylogin" >
                    <div class="panel-heading">
                        <h3 class="panel-title">Sign In</h3>
                    </div>
                    <div class="panel-body">
                        <form:form
		action="${pageContext.request.contextPath}/user/login"
		method="POST"
		modelAttribute="userModelka">
                            <fieldset>
                                <div class="form-group">
                                    <input class="form-control" placeholder="login" name="login" type="text" autofocus="">
                                </div>
                                <div class="form-group">
                                    <input class="form-control" placeholder="Password" name="password" type="password" value="">
                                </div>
                                <div class="checkbox">
                                    <label>
                                        <input name="remember" type="checkbox" value="Remember Me">Remember Me
                                    </label>
                                </div>
                                
                                 <input type="submit" class="btn btn-sm btn-success" style="margin-left: 25%;width: 50%" value="Login"/>
                                
                                 <div class="text-center" style="margin-bottom: -15px;margin-top: 10px">
                                 <a href="" tabindex="5" class="forgot-password" style="margin-bottom: -5px; color:azure">Forgot Password?</a>
                                </div>
                            </fieldset>
                      </form:form>
                    </div>
                </div>
                </li>
                <!---->
            </ul>

		
	</div><!-- /.navbar-collapse -->
</nav>

 <div class="container-fluid text-center backfoto">
       
        
 <div class="row firstRow ">
 
</div>
</div>

<footer class = "footer text-center">
	 <div>© ФК Вікторія. Всі права захищено. 2017 - 2018.

</div>
   <div>
Створення сайту і розробка сайтів - Веб-студія <a href="https://www.facebook.com/jevgen.volynets"> "PeppaLand"</a></div>
    </footer>


</body>
</html>

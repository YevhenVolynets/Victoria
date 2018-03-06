<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Home page</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js">


    </script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js">


    </script>

    <title>Starter Template for Bootstrap</title>

    <style>
        .text-light{
            color: white;
            font-size: 18px;
            border: 1px solid white;
            background-color: rgba(255, 0, 0, 0.5);
            text-align: center;
            border-radius: 20%;
            
        }
        
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
            display: flex;
            justify-content:  space-between;
            
            
        }
        .profile{
            height: 400px;
            width: 50%;
            background-color: dimgrey;
            opacity: 0.7;
            margin-top: 20px;
            border: 6px solid white;
            background-color: rgba(255, 0, 0, 0.5);
            
            
            
        }
        
        .backfoto{
            background-image: url(https://wallpaperscraft.ru/image/futbol_match_prikol_nlo_81271_2560x1600.jpg);
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
        .imgProfile{
            margin-top: 100px;
            margin-left: 100px;
            height: 200px;
            width: 300px;
            border: 6px solid white;
            background-color: aqua;
            
            border-radius: 15%;
              opacity: 0.5;
        }
         }
        .fotoProfile{
            height: 200px;
            width: 300px;
              opacity: 1;
        }
        .tableProfile{
            width: 100%;
            height: 80%;
            color: white;
            font-size: 20px;
             border: 1px solid white;
            
        }
        
        .myform{
            margin-top: 50px ;
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

        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse navbar-ex1-collapse">
            <ul class="nav navbar-nav">
                <a class="navbar-brand" href="#"><img  class="imgVictoria" src="http://preview.ibb.co/nh3aSn/imgonline_com_ua_Transparent_backgr_6_NWv_Tw_AL9j.png" alt="ico"></a>
                <li class="dropdown  headerText">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">ГОЛОВНА <b class="caret"></b></a>
                    <ul class="dropdown-menu  mydropdown-menu">
                        <li><a href="#" id="myMenu">Новини</a></li>
                        <li><a href="#">Фото</a></li>
                        <li><a href="#">Відео</a></li>
                        <li><a href="#">Соціальні мережі</a></li>
                    </ul>
                </li>
                <li class="dropdown headerText ">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">КОМАНДИ <b class="caret"></b></a>
                    <ul class="dropdown-menu mydropdown-menu ">
                        <li><a href="#">Вікторія - 2004</a></li>
                        <li><a href="#">Вікторія - 2009</a></li>

                    </ul>
                </li>
                <li class="dropdown headerText">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">МАТЧІ <b class="caret"></b></a>
                    <ul class="dropdown-menu mydropdown-menu">
                        <li><a href="#">Останній матч</a></li>
                        <li><a href="#">Турнірна таблиця</a></li>
                        <li><a href="#">Статистика гравців</a></li>
                    </ul>
                </li>

                <li class="dropdown headerText">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">КЛУБ <b class="caret"></b></a>
                    <ul class="dropdown-menu mydropdown-menu">
                        <li><a href="#">Керівництво</a></li>
                        <li><a href="#">Історія</a></li>
                        <li><a href="#">Символіка</a></li>
                        <li><a href="#">Контакти</a></li>
                    </ul>
                </li>
                <li class="headerText"><a href="#">МАГАЗИН</a></li>

            </ul>

            <ul class="nav navbar-nav navbar-right">
                <li><a href="#" role="button" class="dropdown-toggle" data-toggle="dropdown"><span class="glyphicon glyphicon-user"></span> Sign Up</a>
                <div class="login-panel panel panel-default dropdown-menu myRegisration" >
                    <div class="panel-heading">
                        <h3 class="panel-title">Sign Up</h3>
                    </div>
                    <div class="panel-body">
                        <form role="form">
                            <fieldset>
                               <div class="form-group">
                                    <input class="form-control" placeholder="Username" name="username" type="text" autofocus="">
                                </div>
                                <div class="form-group">
                                    <input class="form-control" placeholder="E-mail" name="email" type="email" autofocus="">
                                </div>
                                <div class="form-group">
                                    <input class="form-control" placeholder="Password" name="password" type="password" value="" >
                                </div>
                                <div class="form-group">
                                    <input class="form-control" placeholder=" Confirm Password" name="password2" type="password" value="">
                                </div>
                                
                                <a  type="submit" href="" class="btn btn-sm btn-success" style="margin-left: 25%;width: 50%">Register now</a>
                                
                                 
                            </fieldset>
                        </form>
                    </div>
                </div>
                
                </li>
                <!--<li><a data-toggle="pill" href="#menu1">Вхід</a></li>-->
                <li class="dropdown"><a href="#" role="button" class="dropdown-toggle" data-toggle="dropdown" ><span class="glyphicon glyphicon-log-in"></span> Login</a>
                <!--<li><a data-toggle="pill" href="#menu2">Реєстрація</a></li>-->
                <!---->
                
                <div class="login-panel panel panel-default dropdown-menu mylogin" >
                    <div class="panel-heading">
                        <h3 class="panel-title">Sign In</h3>
                    </div>
                    <div class="panel-body">
                        <form role="form">
                            <fieldset>
                                <div class="form-group">
                                    <input class="form-control" placeholder="E-mail" name="email" type="email" autofocus="">
                                </div>
                                <div class="form-group">
                                    <input class="form-control" placeholder="Password" name="password" type="password" value="">
                                </div>
                                <div class="checkbox">
                                    <label>
                                        <input name="remember" type="checkbox" value="Remember Me">Remember Me
                                    </label>
                                </div>
                                
                                <a href="" class="btn btn-sm btn-success" style="margin-left: 25%;width: 50%">Login</a>
                                
                                 <div class="text-center" style="margin-bottom: -15px;margin-top: 10px">
                                 <a href="http://phpoll.com/recover" tabindex="5" class="forgot-password" style="margin-bottom: -5px;">Forgot Password?</a>
                                </div>
                            </fieldset>
                        </form>
                    </div>
                </div>
                </li>
                <!---->
            </ul>

        </div>
        <!-- /.navbar-collapse -->
    </nav>

    <div class="container-fluid text-center backfoto">
        <!--<div class="row context">
            <h1>Hello world</h1>
        </div>-->
        
 <div class="row firstRow "> 
 
 
 <div class="container">
  <h2>Horizontal form</h2>
  <!--  -->
   <form:form
		action="${pageContext.request.contextPath}/user/${userEdit.id}/edit"
		method="POST"
		modelAttribute="userEdit">
    <div class="form-group myform">
    
        <label class="control-label col-sm-2" for="firstname"><p class="text-light">Ім`я:</p></label>
      <div class="col-sm-10">
        <input type="text" class="form-control" id="firstname" placeholder="Enter firstname" name="firstName">
      </div>
    </div>
    
    <div class="form-group myform">
      <label class="control-label col-sm-2" for="lastname"><p class="text-light">Прізвище:</p></label>
      <div class="col-sm-10">
        <input type="text" class="form-control" id="lastname" placeholder="Enter lastname" name="lastName">
      </div>
    </div>
   
   <div class="form-group myform">
      <label class="control-label col-sm-2" for="phone"><p class="text-light">Телефон:</p></label>
      <div class="col-sm-10">
        <input type="text" class="form-control" id="phone" placeholder="Enter phone" name="phone">
      </div>
    </div>
   
   
    <div class="form-group myform">        
      <div class="col-sm-offset-2 col-sm-10">
        <input type="submit" class="btn btn-default btn-lg" style="margin-left: 25%;width: 50%" value="Submit"/>
      </div>
    </div>
    </form:form>
 <!--  -->
</div>

 
</div>



        
    </div>

    <footer class="footer text-center">
       <div>© ФК Вікторія. Всі права захищено. 2017 - 2018.

</div>
   <div>
Створення сайту і розробка сайтів - Веб-студія <a href="https://www.facebook.com/jevgen.volynets"> "PeppaLand"</a></div>
    </footer>

</body>

                
              
</html>


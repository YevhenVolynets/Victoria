<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="..\taglib.jsp" %>
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
            display: flex;
            justify-content:  space-between;
            
            
        }
        .profile{
            height: 400px;
            width: 50%;
            background-color: dimgrey;
            opacity: 0.9;
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
              opacity: 0.9;
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
        
        .text-black{
            font-size: 20px;
           color:  darkred;
        }
                      input.hidden {
    position: absolute;
    left: -9999px;
}

#profile-image1 {
    cursor: pointer;
  
     width: 100px;
    height: 100px;
	border:2px solid #03b1ce ;}
	.tital{ font-size:16px; font-weight:500;}
	 .bot-border{ border-bottom:1px #f8f8f8 solid;  margin:5px 0  5px 0}

       

    </style>
	<div class="row" style="display:flex; justify-content: center;">
        
       <div class="col-md-10 " style="margin-top:50px; ">

<div class="panel panel-default">
  <div class="panel-heading">  <h4 >Профіль</h4></div>
   <div class="panel-body">
       
    <div class="box box-info">
        
            <div class="box-body">
                     <div class="col-sm-6">
                     <div  align="center"> <img alt="User Pic" src="https://x1.xingassets.com/assets/frontend_minified/img/users/nobody_m.original.jpg" id="profile-image1" class="img-circle img-responsive"> 
                
                <input id="profile-image-upload" class="hidden" type="file">
<div style="color:#999;" >click here to change profile image</div>
                <!--Upload Image Js And Css-->

                     </div>
              
              <br>
    
              <!-- /input-group -->
            </div>
            <div class="col-sm-6">
            <h4 style="color:#00b1b1;">${user.firstName } ${user.lastName }</h4></span>
            <c:choose>
              <c:when test="${user.activated}"><span class="glyphicon glyphicon-ok-sign" style="color:green"><p>Активний</p></span></c:when> 
             <c:otherwise> <span class="glyphicon glyphicon-exclamation-sign" style="color:red"><p>Не активний</p> </span>  </c:otherwise>          
           </c:choose>
            </div>
            <div class="clearfix"></div>
            <hr style="margin:5px 0 5px 0;">
    
              
<div class="col-sm-6 col-xs-6 tital " >Ім`я:</div><div class="col-sm-6 col-xs-6 ">${user.firstName}</div>
     <div class="clearfix"></div>
<div class="bot-border"></div>

<div class="col-sm-6 col-xs-6 tital " >Прізвище:</div><div class="col-sm-6"> ${user.lastName}</div>
  <div class="clearfix"></div>
<div class="bot-border"></div>

<div class="col-sm-6 col-xs-6 tital " >Поштова скринька:</div><div class="col-sm-6"> ${user.email}</div>
  <div class="clearfix"></div>
<div class="bot-border"></div>

<div class="col-sm-6 col-xs-6 tital " >Рік Народження:</div><div class="col-sm-6">${user.email}</div>

  <div class="clearfix"></div>
<div class="bot-border"></div>

<div class="col-sm-6 col-xs-6 tital " >Дата народження:</div><div class="col-sm-6">${user.email}</div>

  <div class="clearfix"></div>
<div class="bot-border"></div>

<div class="col-sm-6 col-xs-6 tital " >Місце проживання:</div><div class="col-sm-6">${user.email}</div>

 <div class="clearfix"></div>
<div class="bot-border"></div>

<div class="col-sm-6 col-xs-6 tital " >Веб-сайт:</div><div class="col-sm-6">${user.email}</div>

 <div class="clearfix"></div>
<div class="bot-border"></div>

<div class="col-sm-6 col-xs-6 tital " >Телефон:</div><div class="col-sm-6">${user.phone}</div>


            
          </div>
          

        </div>
       
            
    </div> 
    </div>
</div>  
    <script>
              $(function() {
    $('#profile-image1').on('click', function() {
        $('#profile-image-upload').click();
    });
});       
              </script> 
       
       
       
       
       
       
       
       
       
   </div>
 
 <%-- <div class="imgProfile">
    <img  class="fotoProfile" src="data:image/png;base64, ${imageFromDisk}" alt="profile" style="
      height: 200px;
            width: 300px">
            <form action="${pageContext.request.contextPath}/user/${userOne.id}/edit/img" method="POST" 
enctype="multipart/form-data">
<input type="file" name = "fileUpload">

<input type="submit" value = "Upload file" class = "btn btn-primary">
</form>
     </div>
 <div class="profile">
    <table class="tableProfile table ">
        <tr>
            <td>Логін:</td>
            <td>${userOne.login}</td>
        </tr>
        <tr>
            <td>Прізвище:</td>
            <td>${userOne.lastName}</td>
        </tr>
        <tr>
            <td>Ім`я:</td>
            <td>${userOne.firstName}</td>
        </tr>
        <tr>
            <td>Електронна пошта:</td>
            <td>${userOne.email}</td>
        </tr>
    </table>
     <a href="${pageContext.request.contextPath}/user/${userOne.id}/edit/" style="font-size: 20px; color: aqua; text-decoration: none ">Редагувати профіль</a>
    
     </div>
 --%>



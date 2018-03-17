<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ include file="..\taglib.jsp" %>

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

</div>


                
              


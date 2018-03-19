<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<style>
.panel-heading{
 padding: 10px 15px;
    border-bottom: 1px solid transparent;
    border-top-left-radius: 3px;
    border-top-right-radius: 3px;background-color: #363636;
    border: 2px solid black;
    border-radius: 4%;
    color: azure;
    opacity: 0.9;
}
</style>
<h1 class="text-white panel-heading" style="float: right;    
    text-align: center;">${lastModel.numberTour } Тур</h1>
<div style="display: flex; color:white;font-size: 20px;margin-top: 50px; justify-content: space-around; ">

<div class="panel-heading" style="display: flex;flex-direction: column;">
<img src="http://www.resetyourbody.com/wp-content/uploads/COMPANY_LOGO/logo-default.png"/>
<div style="width: 400px; height: 100px;margin-top: 50px; text-align: center;">${lastModel.teamHome.nameTeam }</div>
</div>


<div style="display: flex;flex-direction: column;">
 <div style="text-align: center;font-size: 40px" class="panel-heading">${lastModel.ligue.val } ліга</div>
 
 <div  class="text-white panel-heading" style="text-align: center;"> ${lastModel.dateGame } </div>
  
  <div  class="text-white panel-heading" style="width: 240px;height: 140px; font-size: 90px;font-family: cursive;
  margin-top: 60px; text-align: center; color:green;
  border: 4px solid black;border-radius: 10px;
  "> ${lastModel.scoreHome }  - ${lastModel.scoreGuest }</div> 
 
</div>



<div class="panel-heading" style="display: flex;flex-direction: column;">
<img src="http://www.resetyourbody.com/wp-content/uploads/COMPANY_LOGO/logo-default.png"/>
<div style="width: 400px; height: 100px;margin-top: 50px; text-align: center;">${lastModel.teamGuest.nameTeam }</div>
</div>

</div>
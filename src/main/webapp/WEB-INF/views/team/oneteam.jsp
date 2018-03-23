<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <br>
    <br>
   
    <br>
    <style>
 	th{
 	text-align: center;
 	}
    .teamImg{
    height:250px;
    background-image: url("http://www.resetyourbody.com/wp-content/uploads/COMPANY_LOGO/logo-default.png");
    background-repeat: no-repeat;
    background-size: contain;
    }
    .oneTeam{
    width:100%;
    display:flex;
    flex-direction: column;
    align-items: center;
    justify-content: space-between;
    }
    
    </style>
    <br>
    
<div class="oneTeam">
<div class="panel panel-default " style="width:300px;margin: 0 auto 20px auto;">
  <div class="panel-heading ">  <h4 >${oneTeam.nameTeam}</h4>  </div>
   <div class="panel-body ">
   <div class="teamImg"></div>
</div>
</div>
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
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>

</div>
</div>
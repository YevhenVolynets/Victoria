
    <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="..\..\taglib.jsp" %>
    <style>
    .text{
    color:red;
    }
    
    th{
    text-align: center;
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

.firstRow {
    margin-top: 0px;
    height: 1100px;

}

.mylogin {
    width: 300px;

}

.myRegisration {
    width: 300px;

}

.dropdown-menu {
    background-color: dimgrey;

}

.dropdown-menu > li > a {
    color: azure;
    font-size: 16px;
    margin: 10px 0 10px 0;
}

.panel-default > .panel-heading {
    background-color: #363636;
    border-color: black;
    text-align: center;
    color: azure;
}

.mytable {
    margin-top: 30px;
    
}
</style>



    


      <div class="text">
      
        <h2>Перша ліга</h2>
        <div class="mytable">
        <table class="table table-striped">
           <tr>
               <th>Позиція</th>
               <th>Команда</th>
               <th>І</th>
               <th>В</th>
               <th>Н</th>
               <th>П</th>
               <th>Заб</th>
               <th>Проп</th>
               <th>Очки</th>
               
           </tr>
            <c:forEach var="stat" items="${listStat1}">	
              <tr>
                <td>${stat.ratingPosition}</td>
                <td>${stat.team.nameTeam}</td>
                <td>${stat.countMatch}</td>
                <td>${stat.winMatch}</td>
                <td>${stat.drawMatch}</td>
                <td>${stat.loseMatch}</td>
                <td>${stat.scoredGoal}</td>
                <td>${stat.missedGoal}</td>
                <td>${stat.point}</td>
            </tr>
            </c:forEach>
        </table>
        </div>
         
         <h2>Друга ліга</h2>
         <div class="mytable">
         <table class="table table-striped">
           <tr>
               <th>Позиція</th>
               <th>Команда</th>
               <th>І</th>
               <th>В</th>
               <th>Н</th>
               <th>П</th>
               <th>Заб</th>
               <th>Проп</th>
               <th>Очки</th>
               
           </tr>
            <c:forEach var="stat" items="${listStat2}">	
              <tr>
                <td>${stat.ratingPosition}</td>
                <td>${stat.team.nameTeam}</td>
                <td>${stat.countMatch}</td>
                <td>${stat.winMatch}</td>
                <td>${stat.drawMatch}</td>
                <td>${stat.loseMatch}</td>
                <td>${stat.scoredGoal}</td>
                <td>${stat.missedGoal}</td>
                <td>${stat.point}</td>
            </tr>
            </c:forEach>
        </table>
    </div>
        </div>
 

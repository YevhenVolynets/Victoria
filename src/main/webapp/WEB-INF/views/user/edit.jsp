<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="/WEB-INF/views/taglib.jsp" %>
    <br><br>
    <br>
    <div class="panel panel-default">
  <div class="panel-heading" style="display:flex; align-content: space-between;justify-content: center;">  <h4>Редагування профілю</h4> </div>
   <div class="panel-body" style="display:flex; align-content: space-between;justify-content: center;">
    <form:form action="${pageContext.request.contextPath}/user/saveuser" modelAttribute="userEdit" method="POST">
   <div class="col-sm-5 col-xs-6 tital " align="right" >Ім`я:</div><div class="col-sm-6 col-xs-6 "> <form:input path="userDetail.firstName" placeholder="Ім`я"/></div>
   <div class="col-sm-5 col-xs-6 tital " align="right">Прізвище:</div> <div class="col-sm-6 col-xs-6 "><form:input path="userDetail.lastName"  placeholder="Прізвище"/></div>
  <div class="col-sm-5 col-xs-6 tital " align="right">Вік:</div> <div class="col-sm-6 col-xs-6 "> <form:input path="userDetail.age"  placeholder="Вік"/></div>
  <div class="col-sm-5 col-xs-6 tital " align="right">Місто</div> <div class="col-sm-6 col-xs-6 "> <form:input path="userDetail.city"  placeholder="Місто"/></div>
  <div class="col-sm-5 col-xs-6 tital " align="right">День народження:</div> <div class="col-sm-6 col-xs-6 "> <input type="date" name="birthday"/></div>
  <div class="col-sm-5 col-xs-6 tital " align="right">Сайт:</div> <div class="col-sm-6 col-xs-6 "> <form:input path="userDetail.webSite"  placeholder="Веб-сайт" /></div>
  <div class="col-sm-5 col-xs-6 tital " align="right">Телефон:</div> <div class="col-sm-6 col-xs-6 "> <form:input path="userDetail.phone"  placeholder="Телефон"/></div>
  <div class="col-sm-5 col-xs-6 tital " align="right">Хоббі:</div> <div class="col-sm-6 col-xs-6 "> <form:input path="userDetail.hobby" placeholder="Хоббі"/></div>
  <div class="col-sm-5 col-xs-6 tital " align="right">Стать:</div> <div class="col-sm-6 col-xs-6 "> <form:radiobuttons path="userDetail.gender" items="${sex}" itemLabel="val"/></div>
    <div class="col-sm-5 col-xs-6 "> </div> <div class="col-sm-2 col-xs-6   " > <input type="submit" value="send" class="btn btn-info"/></div>
    </form:form>
    </div>
    </div>
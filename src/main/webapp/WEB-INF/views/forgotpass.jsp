<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/taglib.jsp"%>
<br><br><br><br>
     <form:form action="${rootURL}/forgotpass" method="POST">
     <input  type ="email" name="email" placeholder="Введіть email"/><br><br> 
    <input type="submit" value="Наступний крок"/>
    </form:form> 
 
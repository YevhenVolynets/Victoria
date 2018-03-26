<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/taglib.jsp"%>
    <form:form action="${rootURL}/forgotpass" method="POST" modelAttribute="emailModel">
    <form:input  path ="email" />
    <input type="submit" value="Наступний крок"/>
    </form:form> 
    
    <a>123</a>
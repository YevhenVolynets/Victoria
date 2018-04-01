<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/taglib.jsp" %>
<div style="display: flex; justify-content: space-between;flex-wrap:wrap; margin: 20px 0 0 0;width: 100%">
<c:forEach items="${allphoto}" var="photo">



<div style="background-repeat: no-repeat;background-size: contain; height:600px;width: 45%;margin:10px;
background-image: url('/resources/img/${photo.namePhoto}'); ">
 <div style="background: rgba(117, 101, 101, 0.8);color:white;width: 100%">${photo.description}</div>
 </div>



</c:forEach>
</div>


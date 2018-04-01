<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="/WEB-INF/views/taglib.jsp" %>
  
  <div  style="display: flex;justify-content: center">
    <div class="panel panel-default" style="width: 80%;  ">
        <div class="panel-heading black" id="black">
            <h4>${post.title}</h4>
        </div>
        <div class="panel-body" style="">
            <div style="display: flex;justify-content:space-between;align-items: center">
                <div>${post.createDate.date}  <c:choose>
         <c:when test="${post.createDate.month == 1}">січня</c:when>
      	 <c:when test="${post.createDate.month == 2}">лютого</c:when>
       	 <c:when test="${post.createDate.month == 3}">березня</c:when>
         <c:when test="${post.createDate.month == 4}">квітня</c:when>
         <c:when test="${post.createDate.month == 5}">травня</c:when>
         <c:when test="${post.createDate.month == 6}">червня</c:when>
         <c:when test="${post.createDate.month == 7}">липня</c:when>
      	 <c:when test="${post.createDate.month == 8}">серпня</c:when>
       	 <c:when test="${post.createDate.month == 9}">вересня</c:when>
         <c:when test="${post.createDate.month == 10}">жовтня</c:when>
         <c:when test="${post.createDate.month == 11}">листопада</c:when>
         <c:when test="${post.createDate.month == 12}">грудня</c:when>
        <c:otherwise>undefined</c:otherwise>
    </c:choose><hr><br>${1900+post.createDate.year},
                 <c:choose>
        <c:when test="${post.createDate.day == 1}">Понеділок</c:when>
        <c:when test="${post.createDate.day == 2}">Вівторок</c:when>
        <c:when test="${post.createDate.day == 3}">Середа</c:when>
        <c:when test="${post.createDate.day == 4}">Четвер</c:when>
        <c:when test="${post.createDate.day == 5}">Пятниця</c:when>
        <c:when test="${post.createDate.day == 6}">Субота</c:when>
        <c:when test="${post.createDate.day == 7}">Неділя</c:when>
        <c:otherwise>undefined</c:otherwise>
    </c:choose>
    </div>
                <div style="width: 80%"><img src="data:img/png; base64, ${post.pathToFoto}" class="img-responsive" alt="" style="width: 100%"></div>
            </div>
            <div class="box box-info">
              
              <p>${post.contents}</p>
              
            </div>
            <div style="text-align: right"><i>${post.author.userDetail.firstName} ${post.author.userDetail.lastName}</i></div>
        </div>
    </div>
</div>
    
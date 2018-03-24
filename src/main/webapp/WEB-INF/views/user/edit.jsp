<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="/WEB-INF/views/taglib.jsp" %>
    <br><br>
    <br>
    <form:form action="${pageContext.request.contextPath}/user/saveuser" modelAttribute="userEdit" method="POST">
    <form:input path="userDetail.firstName" placeholder="Ім`я"/>
    <form:input path="userDetail.lastName"  placeholder="Прізвище"/>
    <form:input path="userDetail.age"  placeholder="Вік"/>
    <form:input path="userDetail.city"  placeholder="Місто"/>
    <input type="date" name="birthday"/>
    <form:input path="userDetail.webSite"  placeholder="Веб-сайт" />
    <form:input path="userDetail.phone"  placeholder="Телефон"/>
    <form:input path="userDetail.hobby" placeholder="Хоббі"/>
    <form:radiobuttons path="userDetail.gender" items="${sex}" itemLabel="val"/>
    <input type="submit" value="send"/>
    </form:form>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ include file="/WEB-INF/views/taglib.jsp" %>
 <br><br><br><hr>

 <form:form action="${pageContext.request.contextPath}/admin/addPhoto" method="POST" 
enctype="multipart/form-data" cssStyle="color:white" modelAttribute="photo">
				<form:textarea path="description" placeholder="Опис до фотографії" cssStyle="margin: 0px; width: 852px; height: 77px;color:black"/>
                <br>
                <form:input path="tags" placeholder="Введіть теги(через кому)" cssStyle="color:black"/>
                <br><br>
                <input id="profile-image-upload"  type="file" name="fileUpload">
                <br>
                <input type="submit" value = "Upload file" class = "btn btn-primary" id="fotosubmit">
                </form:form>
                
                <hr>
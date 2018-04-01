<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="/WEB-INF/views/taglib.jsp" %>


<form:form
		action="${pageContext.request.contextPath}/admin/addNews"
		method="POST"
		modelAttribute="news"
		enctype="multipart/form-data">
		
		<div class="panel panel-default">
  <div class="panel-heading">  <h4 >Додати новину</h4></div>
   <div class="panel-body" style="display: flex; flex-direction:  column;align-items:center;  justify-content:flex-end;">
		<form:label path="title">Опис новини</form:label>
		<form:input path="title"  cssStyle="margin: 0px; width: 342px;"/><br>
		<form:label path="contents">Стаття</form:label>
		<form:textarea path="contents" cssStyle="margin: 0px; width: 342px; height: 436px;"/><br>
		
		<input id="profile-image-upload"  type="file" name="fileUpload"><br>
              
		
		<input type="submit" value="Зберегти" class="btn-lg"/>
		</div>
		</div>
		</form:form>


</body>
</html>
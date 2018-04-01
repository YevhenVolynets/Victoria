<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/taglib.jsp"%>
    
    <form:form action="${pageContext.request.contextPath}/droppass"
								method="POST" modelAttribute="newPass">
								<fieldset>
									
									<div class="form-group">
										<form:input cssClass="form-control" placeholder=" Email"
											path="email"/>
									</div>
									<div class="form-group">
										<form:password cssClass="form-control" placeholder=" Password"
											path="password"/>
									</div>
									 <div class="form-group">
										<form:password cssClass="form-control" placeholder=" Confirm Password"
											path="passwordConfirmation"/>
									</div> 

									<input type="submit" class="btn btn-sm btn-success"
										style="margin-left: 25%; width: 50%" value="Register now" />


								</fieldset>
							</form:form>
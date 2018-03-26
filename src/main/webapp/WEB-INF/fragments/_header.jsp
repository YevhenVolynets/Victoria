
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/taglib.jsp"%>

<nav class="navbar navbar-inverse" role="navigation">
	<!-- Brand and toggle get grouped for better mobile display -->
	<div class="navbar-header">
		<button type="button" class="navbar-toggle" data-toggle="collapse"
			data-target=".navbar-ex1-collapse">
			<span class="sr-only">Toggle navigation</span> <span class="icon-bar"></span>
			<span class="icon-bar"></span> <span class="icon-bar"></span>
		</button>
		<a class="navbar-brand" href="/"><img class="imgVictoria"
			src="http://preview.ibb.co/nh3aSn/imgonline_com_ua_Transparent_backgr_6_NWv_Tw_AL9j.png"
			alt="ico"></a>
	</div>

	<!-- Collect the nav links, forms, and other content for toggling -->
	<div class="collapse navbar-collapse navbar-ex1-collapse">
		<ul class="nav navbar-nav">
			<li class="dropdown  headerText"><a href="#"
				class="dropdown-toggle" data-toggle="dropdown">ГОЛОВНА <b
					class="caret"></b></a>
				<ul class="dropdown-menu">
					<li><a href="${pageContext.request.contextPath}/news/">Новини</a></li>
					<li><a href="${pageContext.request.contextPath}/photos">Фото</a></li>
					<li><a href="${pageContext.request.contextPath}/video">Відео</a></li>
					<li><a href="${pageContext.request.contextPath}/social">Соціальні
							мережі</a></li>
				</ul></li>

			<li class="dropdown headerText"><a href="#"
				class="dropdown-toggle" data-toggle="dropdown">КОМАНДИ <b
					class="caret"></b></a>
				<ul class="dropdown-menu">
					<li><a href="${pageContext.request.contextPath}/victoria-2004">Вікторія
							- 2004</a></li>
					<li><a href="${pageContext.request.contextPath}/victoria-2009">Вікторія
							- 2009</a></li>

				</ul></li>
			<li class="dropdown headerText"><a href="#"
				class="dropdown-toggle" data-toggle="dropdown">МАТЧІ <b
					class="caret"></b></a>
				<ul class="dropdown-menu">
					<li><a href="${pageContext.request.contextPath}/statistics/lastMatch">Останній матч</a></li>
					<li><a
						href="${pageContext.request.contextPath}/statistics/tournament-table">Турнірна
							таблиця</a></li>
					<li><a href="#">Статистика гравців</a></li>
				</ul></li>

			<li class="dropdown headerText"><a href="#"
				class="dropdown-toggle" data-toggle="dropdown">КЛУБ <b
					class="caret"></b></a>
				<ul class="dropdown-menu">
					<li><a href="${pageContext.request.contextPath}/leadership">Керівництво</a></li>
					<li><a href="${pageContext.request.contextPath}/history">Історія</a></li>
					<li><a href="${pageContext.request.contextPath}/symbols">Символіка</a></li>
					<li><a href="${pageContext.request.contextPath}/contacts">Контакти</a></li>
				</ul></li>
			<li class="headerText"><a
				href="${pageContext.request.contextPath}/shop">МАГАЗИН</a></li>

		</ul>
		
			<ul class="nav navbar-nav navbar-right" style="display: flex; ">
			<sec:authorize access="!isAuthenticated()">
				<li><a href="#" role="button" class="dropdown-toggle"
					data-toggle="dropdown"><span class="glyphicon glyphicon-user"></span>
						Sign Up</a>
					<div
						class="login-panel panel panel-default dropdown-menu myRegisration">
						<div class="panel-heading">
							<h3 class="panel-title">Sign Up</h3>
						</div>
						<div class="panel-body">
							<form:form action="${pageContext.request.contextPath}/register"
								method="POST" modelAttribute="userModelka">
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
						</div>
					</div></li>

				<li class="dropdown"><a href="#" role="button"
					class="dropdown-toggle" data-toggle="dropdown"><span
						class="glyphicon glyphicon-log-in"></span> Login</a>


					<div class="login-panel panel panel-default dropdown-menu mylogin">
						<div class="panel-heading">
							<h3 class="panel-title">Sign In</h3>
						</div>
						<div class="panel-body">
							<form:form action="${pageContext.request.contextPath}/login"
								method="POST">
								
									<div class="form-group">
										<input class="form-control" placeholder="email" name="email"
											type="email" autofocus="">
									</div>
									<div class="form-group">
										<input class="form-control" placeholder="Password"
											name="password" type="password" value="">
									</div>
									<div class="checkbox">
										<label> <input name="rememberMe" type="checkbox">Remember
											Me
										</label>
									</div>

									<input type="submit" class="btn btn-sm btn-success"
										style="margin-left: 25%; width: 50%" value="Login" />

									
								
							</form:form>
							<div class="text-center"
										style="margin-bottom: -15px; margin-top: 10px">
										<a href="${rootURL}/forgotpass" >Forgot
											Password?</a>
									</div>
						</div>
					</div></li>
				
			</sec:authorize>
			<sec:authorize access="isAuthenticated()">
			<sec:authentication property="principal.username" var="user" />
		<li>
			<a href="/user/profile">${user}</a>
</li>
			<c:url var="logoutUrl" value="/logout" />
			<form:form action="${logoutUrl}" method="POST" >
				<li><input class="btn btn-danger" type="submit" value="logout" style="height: 50px; " /></li>
			</form:form>


		</sec:authorize>
			</ul>
		
		

	</div>
</nav>
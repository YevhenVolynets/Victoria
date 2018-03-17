<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="..\taglib.jsp" %>


<style>
.navbar {
	margin-bottom: 0;
	border-radius: 0;
}

.contact {
	height: 400px;
	width: 80%;
	
	background-color: dimgrey;
	opacity: 0.9;
	margin-top: 90px;
	border: 6px solid white;
	background-color: rgba(90, 240, 41, 0.5);
	display: flex;
	flex-direction: column;
	justify-content: space-around;
	
}

.footer {
	background-color: black;
	color: white;
	padding: 15px;
	display: flex;
	justify-content: space-between;
	font-family: cursive;
	font-size: 12px;
}

.context {
	background-color: azure;
	height: 600px;
}

.imgVictoria {
	height: 400%;
	margin-top: -10px;
	margin-right: 10px;
}

.headerText {
	width: 160px;
	text-align: center;
}

.firstRow {
width:100%;
	margin-top: 0px;
	height: 900px;
	display:flex;
	justify-content: center;
	

}

.backfoto {
	background-image:
		url(https://cdn1.img.rsport.ru/images/110049/35/1100493585.jpg);
	background-repeat: no-repeat;
	background-size: cover;
}

.mylogin {
	width: 300px;
}

.myRegisration {
	width: 300px;
}

.dropdown-menu {
	background-color: dimgrey;
}

.dropdown-menu>li>a {
	color: azure;
	font-size: 16px;
	margin: 10px 0 10px 0;
}

.panel-default>.panel-heading {
	background-color: #363636;
	border-color: black;
	text-align: center;
	color: azure;
}

.error {
	color: red;
	font-style: italic;
	font-size: 16px;
	font-weight: bold;
}
</style>





			<div class="contact">
				<h2 style="color: white">Контакти</h2>
				<div class="contacts">
					<div class="row " style="color: white">
						<div class="col-sm-6">
							<h3>Івашкевич Василь</h3>
							<p>Головний тренер</p>

						</div>
						<div class="col-sm-6">
							<h3>099-999-99-99</h3>

						</div>

					</div>
					
					<div class="row " style="color: white">
						<div class="col-sm-6">
							<h3>Волинець Євген</h3>
							<p>Тренер голкіперів</p>

						</div>
						<div class="col-sm-6">
							<h3>099-999-99-99</h3>

						</div>

					</div>
					
						<div class="row " style="color: white">
						<div class="col-sm-6">
							<h3>Lorem ipsum</h3>
							<p>Тренер  lorem</p>

						</div>
						<div class="col-sm-6">
							<h3>099-999-99-99</h3>

						</div>

					</div>

				</div>
			</div>



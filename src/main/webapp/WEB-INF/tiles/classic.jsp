<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="/WEB-INF/views/taglib.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<c:choose>
	<c:when test="${title == null}">
		<tiles:putAttribute name="title" value="App title" />
	</c:when>
	<c:otherwise>
		<tiles:putAttribute name="title" value="${title}" />
	</c:otherwise>
</c:choose>

<title><tiles:getAsString name="title"></tiles:getAsString></title>

 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"> </script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"> </script>
 <link rel="shortcut icon" href="/favicon.ico" type="image/x-icon">
<link rel="icon" href="/resources/favicon.ico" type="image/x-icon"> 
<style>
.navbar {
            margin-bottom: 0;
            border-radius: 0;
        }

		.text-white{
		color:white;
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
        
        .firstRow{
            margin-top: 0px;
          
        }
        
        /* .backfoto */body{
            background-image: url(https://cdn1.img.rsport.ru/images/110049/35/1100493585.jpg);
            background-repeat: no-repeat;
            background-size: cover;
            width: 100%;
            
           
        }
        
        .mylogin{
            width: 300px;
            
        }
        
        .myRegisration{
            width: 300px;
          
        }
        .dropdown-menu {
            background-color: dimgrey;
            
        }
        .dropdown-menu>li>a{
            color: azure;
            font-size: 16px;
            margin: 10px 0 10px 0;
        }
        
        .panel-default>.panel-heading{
           background-color:#363636; 
            border-color: black;
            text-align: center;
            color: azure;
        }
        header{
        position: fixed;
        }
        .error{
	color:red;
	font-style: italic;
	font-size: 16px;
	font-weight: bold;
}
.table>thead>tr>th{border-bottom: none;}
.exotic-table{
    color:#fff;
    background: #191919;
    text-align: center;
    border: none;
}
.exotic-table thead tr{
    border: 2px #333 outset;
    text-align: center;
}
.exotic-table thead>tr>th{
    text-align: center;
}
.exotic-table tbody{
    border:2px outset #333;
    border-top:none
}

.exotic-table tbody tr{
    background: #222;
}
.exotic-table tbody tr:hover{
    box-shadow:0 0 20px #000;
    background:#1a1a1a;
}
.exotic-table tbody tr td{
    border-bottom:2px outset #333;
}
</style>
</head>
<body>
<tiles:insertAttribute name = "header"/>

<div class="container-fluid backfoto">
<tiles:insertAttribute name = "body"/>
</div>

<tiles:insertAttribute name = "footer"/>



</body>
</html>
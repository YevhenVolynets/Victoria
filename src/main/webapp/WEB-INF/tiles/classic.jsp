<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"> </script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"> </script>
<style>
.navbar{
    margin-bottom: 0;
    border-radius: 0;
}

.row .context{
    height: 450px;
}

.sidenav{
    padding-top: 20px;
    background-color: royalblue;
    height: 100%;
}

.footer{
    background-color: black;
    color: white;
    padding: 15px;
}
</style>
</head>
<body>
<tiles:insertAttribute name = "header"/>

<div class="container">
<tiles:insertAttribute name = "body"/>
</div>

<tiles:insertAttribute name = "footer"/>



</body>
</html>
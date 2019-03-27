<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="metier.User" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Gestion des Caches</title>
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    
    <link rel="stylesheet" href="//cdn.datatables.net/1.10.19/css/jquery.dataTables.min.css">
    <!-- jQuery library -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

    <!-- Latest compiled JavaScript -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<header>
        <nav class="navbar navbar-default">
        <div class="container-fluid">
        	<% 
        	User user = (User) request.getSession(true).getAttribute("currentSessionUser");
        	%>
	            <ul class="nav navbar-nav">
	                <li class="active"><a href="/home"><span class="glyphicon glyphicon-home"></span> Home</a></li>
	            </ul>
	        <%if(user != null && user.isValid()){  %>
	            <ul class="nav navbar-nav">
	               <li class="active"><a href="/visite"><span class="glyphicon glyphicon-camera"></span> Visites</a></li>
	            </ul>
	        <%} %>
	        <%if(user != null && user.isValid()){  %>
	            <ul class="nav navbar-nav">
	                <li class="active"><a href="/cache"><span class="glyphicon glyphicon-road"></span> Caches</a></li>
	            </ul>
	        <%} %>
	        <%if(user != null && user.isValid()){  %>
	            <ul class="nav navbar-nav">
	                <li class="active"><a href="/gestionusers"><span class="glyphicon"></span> Users</a></li>
	            </ul>
	        <%} %>
	        <%if(user != null && user.isValid()){  %>
	            <ul class="nav navbar-nav navbar-right">
	                 <li><a href="/logout"><span class="glyphicon glyphicon-user"></span> Déconnexion</a></li> 
	            </ul>
	        <%} %>
	        <%if(user == null){ %>
	            <ul class="nav navbar-nav navbar-right">
	                 <li><a href="/register"> Register</a></li> 
	            </ul>
            <%} %>
	        <%if(user == null){ %>
	            <ul class="nav navbar-nav navbar-right">
	                 <li><a href="/login"><span class="glyphicon glyphicon-user"></span> Login</a></li> 
	            </ul>
            <%} %>
        </div>
    </nav>
</header>

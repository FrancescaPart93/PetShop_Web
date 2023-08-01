<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="it.betacom.dao.AnimaleDao,it.betacom.bean.*,java.util.*"%>
<%@page import="it.betacom.dao.UtenteDao,it.betacom.bean.*,java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
	<style>
        body {
            background-image: url("koala.jpeg");
            background-size: cover; 
            background-position: contain;
        }
    </style>
<title>Arrivo guest</title>
</head>
<body>
	
	<nav class="navbar navbar-expand-lg bg-light">
	  <div class="container-fluid">
	    <a class="navbar-brand" href="#">PetShop</a>
	    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
	      <span class="navbar-toggler-icon"></span>
	    </button>
	    <div class="collapse navbar-collapse" id="navbarNav">
	      <ul class="navbar-nav">
	        <li class="nav-item">
	          <a class="nav-link active" aria-current="page" href="showutenti.jsp">Utenti</a>
	        </li>
	        <li class="nav-item">
	          <a class="nav-link active" href="showclienti.jsp">Clienti</a>
	        </li>
	      </ul>
	    </div>
	    <h1>${sessionScope.nome} ${sessionScope.cognome} </h1>
		     <form action="Logout" method = "post">
				<input type="hidden" name="id" value="${u.getId()}">
				<button type="submit" class="btn btn-outline-danger btn-lg">Logout</button>	
			</form>
	  </div>
	</nav>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
</body>
</html>
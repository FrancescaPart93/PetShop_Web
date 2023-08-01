<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="it.betacom.dao.UtenteDao,it.betacom.bean.*,java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">

<title>Arrivo guest</title>
</head>
<body>
	<h1 class="text-center"> Lista utenti</h1>
	<%
	List<Utente> list = UtenteDao.getAllRecords();
	request.setAttribute("list", list);
	%>
	<table border="1" width="90%" class="mx-5 my-3 table-bordered border border-5 border-dark">
	<tr><th class = "p-2">Id</th><th>Nome</th><th>Cognome</th><th>Email</th><th>Telefono</th><th>Ruolo</th><th>Stato</th><th>Username</th></tr>
	
	<c:forEach items="${list}" var="u">
	
		<tr><td class = "p-2">${u.getId()}</td><td>${u.getNome()}</td><td>${u.getCognome()}</td><td>${u.getEmail()}</td><td>${u.getTelefono()}</td><td>${u.getRuolo()}</td><td>${u.getStato()}</td><td>${u.getUsername()}</td></tr>
	</c:forEach>
	</table>
	
	<a href="showclienti.jsp">Vai alla pagina Clienti</a>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
</body>
</html>
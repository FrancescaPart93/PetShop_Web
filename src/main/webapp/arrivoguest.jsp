<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="it.betacom.dao.UtenteDao,it.betacom.bean.*,java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Arrivo guest</title>
</head>
<body>
	<h1> Login effettuato con successo !</h1>
<%
List<Utente> list = UtenteDao.getAllRecords();
request.setAttribute("list", list);
%>
<table border="1" width="90%">
<tr><th>Id</th><th>Nome</th><th>Cognome</th><th>Email</th><th>Telefono</th><th>Ruolo</th><th>Stato</th><th>Username</th></tr>

<c:forEach items="${list}" var="u">

	<tr><td>${u.getId()}</td><td>${u.getNome()}</td><td>${u.getCognome()}</td><td>${u.getEmail()}</td><td>${u.getTelefono()}</td><td>${u.getRuolo()}</td><td>${u.getStato()}</td><td>${u.getUsername()}</td></tr>
</c:forEach>
</table>

<a href="showclienti.jsp">Vai alla pagina Clienti</a>

</body>
</html>
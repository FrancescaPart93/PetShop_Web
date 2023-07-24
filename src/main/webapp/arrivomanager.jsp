<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="it.betacom.dao.UtenteDao,it.betacom.bean.*,java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Buongiorno Manager!!</h1>
	<%
	List<Utente> list = UtenteDao.getAllRecords();
	request.setAttribute("list", list);
	%>
	<table border="1" width="90%">
		<tr>
			<th>Id</th>
			<th>Nome</th>
			<th>Cognome</th>
			<th>Email</th>
			<th>Telefono</th>
			<th>Username</th>
			<th>Ruolo</th>
			<th>Stato</th>
		</tr>

		<c:forEach items="${list}" var="u">

			<tr>
				<td>${u.getId()}</td>
				<td>${u.getNome()}</td>
				<td>${u.getCognome()}</td>
				<td>${u.getEmail()}</td>
				<td>${u.getTelefono()}</td>
				<td>${u.getUsername()}</td>
				<td>
					<button id = "ruolo" type="button" class="btn btn-warning">${u.getRuolo()}</button>	
				</td>
				<td>
					<button id = "stato" type="button" class="btn btn-warning">${u.getStato()}</button>
				</td>
				<td>Modifica</td>
			</tr>
			
		</c:forEach>
		
	</table>
	<script src= "arrivomanager.js"></script>
</body>
</html>
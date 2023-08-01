<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="it.betacom.dao.ClienteDao,it.betacom.bean.*,java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">

<title>Clienti</title>
</head>
<body>
	<h1 class="text-center">Tabella clienti</h1>
	<%
		List<Cliente> list = ClienteDao.getAllRecords();
		request.setAttribute("list", list);
	%>
	
	<table border="1" width="90%" class="mx-5 my-3 table-bordered border border-5 border-dark">
		<tr>
			<th class = "p-2">Id Cliente</th>
			<th>Nome</th>
			<th>Cognome</th>
			<th>Città</th>
			<th>Telefono</th>
			<th>Indirizzo</th>
		</tr>
		<c:forEach items="${list}" var="c">
			<tr>
				<td input type="number" id="idCliente" name="idCliente" class = "p-2">${c.getIdCliente()}</td>
				<td>${c.getNome()}</td>
				<td>${c.getCognome()}</td>
				<td>${c.getCitta()}</td>
				<td>${c.getTelefono()}</td>
				<td>${c.getIndirizzo()}</td>
				<td class = "p-2">
					<a href="acquisticliente.jsp?idCliente=${c.getIdCliente()}" class="btn btn-primary">Visualizza acquisti</a>
				</td>
			</tr>
		</c:forEach>
	</table>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
</body>
</html>
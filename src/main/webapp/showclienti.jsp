<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="it.betacom.dao.ClienteDao,it.betacom.bean.*,java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Clienti</title>
</head>
<body>
	<h1>Tabella clienti</h1>
	<%
		List<Cliente> list = ClienteDao.getAllRecords();
		request.setAttribute("list", list);
	%>
	
	<table border="1" width="90%">
		<tr>
			<th>Id Cliente</th>
			<th>Nome</th>
			<th>Cognome</th>
			<th>Città</th>
			<th>Telefono</th>
			<th>Indirizzo</th>
		</tr>
		<c:forEach items="${list}" var="c">
			<tr>
				<td>${c.getIdCliente()}</td>
				<td>${c.getNome()}</td>
				<td>${c.getCognome()}</td>
				<td>${c.getCitta()}</td>
				<td>${c.getTelefono()}</td>
				<td>${c.getIndirizzo()}</td>
				<td>
					<button  onclick="window.location.href = 'acquisticliente.jsp';" class= "btn btn-primary" type="submit">Visualizza acquisti</button>
				</td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>
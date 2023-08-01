<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="it.betacom.dao.AnimaleDao,it.betacom.bean.*,java.util.*"%>
<%@page import="it.betacom.dao.ClienteDao,it.betacom.bean.*,java.util.*"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">

<title>Acquisti cliente</title>
</head>
<body>

 <h1 class="text-center"> Acquisti del cliente</h1>
 <%
 	String id = request.getParameter("idCliente");
 	int idCliente = Integer.parseInt(id);
 	List <Animale> list = AnimaleDao.getRecordByIdCliente(idCliente);
 	request.setAttribute("list", list);
 %>
 	
 	<table border="1" width="90%" class="mx-5 my-3 table-bordered border border-5 border-dark">
		<tr>
			<th class = "p-2">Matricola</th>
			<th>Tipo animale</th>
			<th>Nome</th>
			<th>Data di acquisto</th>
			<th>Prezzo</th>
		</tr>
		
		<c:forEach items="${list}" var="a">
			<tr>
				<td>${a.getMatricola()}</td>
				<td>${a.getTipo()}</td>
				<td>${a.getNome()}</td>
				<td>${a.getDataAcquisto()}</td>
				<td>${a.getPrezzo()}</td>
			</tr>
		 </c:forEach>
	</table>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
</body>
</html>
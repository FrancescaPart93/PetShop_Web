<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="it.betacom.dao.UtenteDao,it.betacom.bean.*,java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
	<title>Arrivo manager</title>
</head>
<body>
	<h1>Benvenuto Manager!!</h1>
	<%
	List<Utente> list = UtenteDao.getAllRecords();
	request.setAttribute("list", list);
	%>
	<table border="1" width="90%" action="UpdateManager" method="post">
		<tr>
			<th>Id</th>
			<th>Nome</th>
			<th>Cognome</th>
			<th>Email</th>
			<th>Password</th>
			<th>Telefono</th>
			<th>Username</th>
			<th>Ruolo</th>
			<th>Stato</th>
		</tr>

		<c:forEach items="${list}" var="u">
		<form action="UpdateManager" method="post">
			<tr>
				<td input type="number" id="id" name="id">${u.getId()}</td>
				<td>${u.getNome()}</td>
				<td>${u.getCognome()}</td>
				<td>${u.getEmail()}</td>
				<td>${u.getPassword()}</td>
				<td>${u.getTelefono()}</td>
				<td>${u.getUsername()}</td>
				<td>
					<button type="button" class="btn btn-warning ruoloBtn">${u.getRuolo()}</button>	
					<button id="salvaButton" type="button" class="btn btn-warning">Salva</button>
				</td>
				<td>
					<button type="button" class="btn btn-warning statoBtn">${u.getStato()}</button>
					<button id="salvaButton" type="button" class="btn btn-warning">Salva</button>
				</td>
				<td>
					<div class="dropdown">
					  <button class="btn btn-secondary dropdown-toggle" type="button" data-bs-toggle="dropdown" aria-expanded="false" action="UpdateManager" method="post">
					    Modifica
					  </button>
					  <ul class="dropdown-menu">
					  
					  	  <!-- questo input nascosto mi permette di leggere automaticamente l'id dell'utente che si sta modificando -->
					  	  <input type="hidden" name="id" value="${u.getId()}"> 
					  	  
						  <div class="mb-3 row">
						    <label for="exampleFormControlInput1" class="form-label">Email</label>
						    <div class="col-auto">
								<input type="email" class="form-control" id="email" name = "email" placeholder="name@example">
						  </div>
						  <div class="mb-3 row">
						    <label for="exampleFormControlInput1" class="form-label">Password</label>
						    <div class="col-auto">
                        		<input type="password" class="form-control" id="password" name="password" >
						  </div>
						  <div class="mb-3 row">
						    <label for="exampleFormControlInput1" class="form-label">Telefono</label>
						    <div class="col-auto">
                        		<input type="text" class="form-control" id="telefono" name="telefono">
						  </div>
							<div class="col-auto">
						    	<button type="submit" class="btn btn-primary mb-3" action="UpdateManager" method="post">Salva</button>
						  	</div>
						  </div>
					
					  </ul>
					</div>
				</td>
			</tr>
			</form>
		</c:forEach>
		
	</table>
	<script src= "arrivomanager.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
</body>
</html>
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
	<%
	if (session.getAttribute("nome") == null) {
		response.sendRedirect("login.jsp");
		return;
	}else if(session.getAttribute("ruolo").equals("G")){
		response.sendRedirect("arrivoguest.jsp");
	}
	List<Utente> list = UtenteDao.getAllRecords();
	request.setAttribute("list", list);
	%>
	
	<nav class="navbar navbar-expand-lg bg-light">
	  <div class="container-fluid">
	    <a class="navbar-brand" href="index.jsp">PetShop</a>
	    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
	      <span class="navbar-toggler-icon"></span>
	    </button>
	    <div class="collapse navbar-collapse" id="navbarNav">
	      <ul class="navbar-nav">
	        <li class="nav-item">
	          <a class="nav-link active" aria-current="page" href="showutenti.jsp">Utenti</a>
	        </li>
	        <li class="nav-item">
	          <a class="nav-link active" aria-current="page" href="showclienti.jsp">Clienti</a>
	        </li>
	        <li class="nav-item">
	          <a class="nav-link active" aria-current="page" href="showanimali.jsp">Animali</a>
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
	
	<h1 class="text-center">Benvenuto Manager!!</h1>
	
	<div class= "container">
	<table border="1" width="90%" class="table table-success table-striped p-2 my-3 table-bordered border border-5 border-dark">
		<tr>
			<th class = "p-2">Id</th>
			<th>Nome</th>
			<th>Cognome</th>
			<th>Email</th>
			<th>Password</th>
			<th>Telefono</th>
			<th>Username</th>
			<th>Ruolo</th>
			<th>Stato</th>
			<th></th>
		</tr>

		<c:forEach items="${list}" var="u">
		
			<tr>
				<td input type="number" id="id" name="id" class = "p-2">${u.getId()}</td>
				<td>${u.getNome()}</td>
				<td>${u.getCognome()}</td>
				<td>${u.getEmail()}</td>
				<td>${u.getPassword()}</td>
				<td>${u.getTelefono()}</td>
				<td>${u.getUsername()}</td>
				<td class = "p-2">
					<form action="UpdateRuolo" method = "post">
						<input type="hidden" name="id" value="${u.getId()}">
						<input type="hidden" name="ruolo" value="${u.getRuolo()}">
						<button type="submit" class="btn btn-warning" onclick="confermaSalvataggio()">${u.getRuolo()}</button>	
					</form>
				</td>
				<td class = "p-2">
					<form action="UpdateStato" method = "post">
						<input type="hidden" name="id" value="${u.getId()}">
						<input type="hidden" name="stato" value="${u.getStato()}">
						<button type="submit" class="btn btn-warning" onclick="confermaSalvataggio()">${u.getStato()}</button>	
					</form>
				</td>
				<td>
					<div class="dropdown">
					
					  <button class="btn btn-secondary dropdown-toggle mx-2" type="button" data-bs-toggle="dropdown" aria-expanded="false" action="UpdateManager" method="post">
					    Modifica
					  </button>
					  <ul class="dropdown-menu">
					  	<form action="UpdateManager" method="post" class="bg-light border border-dark border-5">
					  	  <!-- questo input nascosto mi permette di leggere automaticamente l'id dell'utente che si sta modificando -->
					  	  <input type="hidden" name="id" value="${u.getId()}"> 
					  	  
						  <div class="row p-2">
						    <label for="exampleFormControlInput1" class="form-label">Email</label>
						    <div class="col-auto">
								<input type="email" class="form-control" id="email" name="email" placeholder="name@example.com">
						    </div>
						  </div>
						  <div class="row p-2">
						    <label for="exampleFormControlInput1" class="form-label">Password</label>
						    <div class="col-auto">
                        		<input type="password" class="form-control" id="password" name="password" >
						    </div>
						  </div>
						  
						  <div class="row p-2">
						    <label for="exampleFormControlInput1" class="form-label">Telefono</label>
						    <div class="col-auto">
                        		<input type="text" class="form-control" id="telefono" name="telefono">
						    </div>
						  </div>
							<div class="col-auto mt-2">
						    	<button type="submit" class="btn btn-primary m-2"  data-id="${u.getId()}" onclick="confermaSalvataggio()">Salva</button>
						  	</div>
						</form>
					  </ul>
					</div>
				</td>
			</tr>
			
		</c:forEach>
	</div>
	</table>
	<script>
        function confermaSalvataggio() {
            alert("Modifiche effettuate con successo!");
        }
    </script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="it.betacom.dao.AnimaleDao,it.betacom.bean.*,java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">

<title>Animali</title>
</head>
<body>

	<%
	if (session.getAttribute("nome") == null) {
		response.sendRedirect("login.jsp");
		return;
	}else if(session.getAttribute("ruolo").equals("G")){
		response.sendRedirect("arrivoguest.jsp");
	}
	List<Animale> list = AnimaleDao.getAllRecords();
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
	          <a class="nav-link disabled" aria-disabled="true">Utenti</a>
	        </li>
	        <li class="nav-item">
	          <a class="nav-link active" href="showclienti.jsp">Clienti</a>
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
	
	
	<div class="container mt-4">
    <div class="row">
        <div class="col-md-8">
        	<h1 class="text-center"> Lista animali</h1>
        
            <!-- Tabella -->
            <table class="table table-success table-striped p-2 my-3 table-bordered border border-5 border-dark col-5">
                <tr>
                    <th class="p-2">Matricola</th>
                    <th>Tipo</th>
                    <th>Nome</th>
                    <th>Data di acquisto</th>
                    <th>Prezzo</th>
                    <th>Id Cliente</th>
                </tr>
                <c:forEach items="${list}" var="a">
                    <tr>
                        <td class="p-2">${a.getMatricola()}</td>
                        <td>${a.getTipo()}</td>
                        <td>${a.getNome()}</td>
                        <td>${a.getDataAcquisto()}</td>
                        <td>${a.getPrezzo()}</td>
                        <td>${a.getIdCliente()}</td>
                        <td>
							<div class="dropdown">
							
							  <button class="btn btn-secondary dropdown-toggle mx-2" type="button" data-bs-toggle="dropdown" aria-expanded="false" action="UpdateManager" method="post">
							    Modifica
							  </button>
							  <ul class="dropdown-menu">
							  	<form action="UpdateAnimale" method="post" class="bg-light border border-dark border-5">
							  	  <!-- questo input nascosto mi permette di leggere automaticamente l'id dell'utente che si sta modificando -->
							  	  <input type="hidden" name="matricola" value="${u.getMatricola()}"> 
							  	  
								  <div class="row p-2">
								    <label for="exampleFormControlInput1" class="form-label">Tipo</label>
								    <div class="col-auto">
										<input type="text" class="form-control" id="tipo" name="tipo">
								    </div>
								  </div>
								  <div class="row p-2">
								    <label for="exampleFormControlInput1" class="form-label">Nome</label>
								    <div class="col-auto">
		                        		<input type="text" class="form-control" id="nome" name="nome" >
								    </div>
								  </div>
								  
								  <div class="row p-2">
								    <label for="exampleFormControlInput1" class="form-label">Prezzo</label>
								    <div class="col-auto">
		                        		<input type="number" class="form-control" id="prezzo" name="prezzo">
								    </div>
								  </div>
									<div class="col-auto mt-2">
								    	<button type="submit" class="btn btn-primary m-2"  data-id="${u.getMatricola()}" >Salva</button>
								  	</div>
								</form>
							  </ul>
							</div>
						</td>
						<td>Elimina</td>
                    </tr>
                </c:forEach>
            </table>
        </div>

        <div class="col-md-4">
		    <!-- Modulo -->
		    <h2 class="text-center mb-4">Nuovo animale</h2>
		    <div class="col-md-10 mx-auto p-3 border rounded shadow">
		        <form action="InserimentoAnimale" method="post">
		            <div class="form-group">
		                <label for="matricola">Matricola:</label>
		                <input type="text" class="form-control" id="matricola" name="matricola" />
		            </div>
		            <div class="form-group">
		                <label for="tipo">Tipo:</label>
		                <input type="text" class="form-control" id="tipo" name="tipo" />
		            </div>
		            <div class="form-group">
		                <label for="nome">Nome:</label>
		                <input type="text" class="form-control" id="nome" name="nome" />
		            </div>
		            <div class="form-group">
		                <label for="prezzo">Prezzo:</label>
		                <input type="text" class="form-control" id="prezzo" name="prezzo" />
		            </div>
		            <button type="submit" class="btn btn-primary btn-block mt-2">Inserisci</button>
		        </form>
		    </div>
		</div>

    </div>
</div>
	
	
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
</body>
</html>
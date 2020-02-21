<%@page import="java.util.List"%>
<%@page import="service.models.Carburant"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

<title>Crud Carburant</title>
</head>
<body>
	<div class="container">
		<h1>Carburant Crud</h1>
		<br>
		<h2>CREATE</h2>
		<form action="CreateCarburant" method="post">
			<div class="form-group">
				<label class="control-label col-sm-2" for="email">Nom:</label>
				<div class="col-sm-10">
					<input type="text" name="nom" class="form-control" id="name" placeholder="Enter Name">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="pwd">Description:</label>
				<div class="col-sm-10">

					<input type="text" class="form-control" id="desc" placeholder="Enter Description" name="desc">
				</div>
			</div>
			<br> <input type="submit" value="SAVE" class="btn btn-success">
		</form>
	</div>
	<br>
	<div class="container">
		<h2>UPDATE & DELETE</h2>
		<table class="table">
			<tr class="info">
				<th>Nom</th>
				<th>Description</th>
				<th style="text-align:center;">Action</th>
			</tr>

			<%
				List<Carburant> lst = (List<Carburant>) request.getAttribute("carburants");
				Carburant var = null;
				for (int i = 0; i < lst.size(); i++) {
					var = lst.get(i);
			%>
			<tr class="active">
				<td><%=var.getNom()%></td>
				<td><%=var.getDescription() %></td>
				<td style="text-align:center;" ><a href="UpdateCarburant.jsp?id=<%=var.getId_c()%>" class="btn btn-warning">Edit</a> <a href='RemoveCarburant?id=<%=var.getId_c()%>' class="btn btn-danger">Delete</a></td>
			</tr>
			<%
				}
			%>
			
		</table>
	</div>
</body>
</html>
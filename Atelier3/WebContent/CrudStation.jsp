<%@page import="java.util.List"%>
<%@page import="service.models.Station"%>
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

<title>Crud Station</title>
</head>
<body>
	<div class="container">
		<h1>Station Crud</h1>
		<br>
		<h2>CREATE</h2>
		<form action="CreateStation" method="post">
			<div class="form-group">
				<label class="control-label col-sm-2" for="email">Nom:</label>
				<div class="col-sm-10">
					<input type="text" name="nom" class="form-control" id="name" placeholder="Enter Name">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="pwd">Ville:</label>
				<div class="col-sm-10">

					<input type="text" class="form-control" id="cty" placeholder="Enter City" name="ville">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="pwd">Adresse:</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="addr" placeholder="Enter Address" name="adresse">
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
				<th>Ville</th>
				<th>Adresse</th>
				<th style="text-align:center;">Action</th>
			</tr>

			<%-- <% List<Station> lst = (List<Station>) request.getAttribute("stations"); %>
		Person is nom: <%=p.get(0).getNom()%>
		Person is ville: <%=p.get(0).getVille()%>
		Person is adresse:	<%=p.get(0).getAdresse()%>

		<c:forEach 	items="${lst}" var="st">
			<tr>
				<td>${st}.getNom()</td>
				<td><c:out value="${st.getNom()}" /></td>
				<td><c:out value="${st.getVille()}" /></td>
				<td><c:out value="${st.getAdresse()}" /></td>
			</tr>
		</c:forEach> --%>

			<%
				List<Station> lst = (List<Station>) request.getAttribute("stations");
				Station var = null;
				for (int i = 0; i < lst.size(); i++) {
					var = lst.get(i);
			%>
			<tr class="active">
				<td><%=var.getNom()%></td>
				<td><%=var.getVille()%></td>
				<td><%=var.getAdresse()%></td>
				<td style="text-align:center;" ><a href="UpdateStation.jsp?id=<%=var.getId_s()%>" class="btn btn-warning">Edit</a> <a href='RemoveStation?id=<%=var.getId_s()%>' class="btn btn-danger">Delete</a></td>
			</tr>
			<%
				}
			%>
			
		</table>
	</div>
</body>
</html>
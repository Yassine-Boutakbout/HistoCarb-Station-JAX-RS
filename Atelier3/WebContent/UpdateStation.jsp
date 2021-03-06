<%@page import="com.sun.jersey.api.client.*"%>
<%@page import="com.sun.jersey.api.client.config.*"%>
<%@page import="org.codehaus.jackson.map.ObjectMapper"%>
<%@page import="java.net.URI"%>
<%@page import="javax.ws.rs.core.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="service.models.Station"%>
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

<title>Crud Station | Update</title>
</head>
<body>
	<%String id=request.getParameter("id");
	
	//Station st = StationFinder.FindById(id);
	Client client = Client.create(new DefaultClientConfig());
	URI uri=UriBuilder.fromUri("http://localhost:8080/Ateliers3-RS/").build();
	ClientResponse resp = client.resource(uri).path("ServiceStation").path("FindbyID/"+id).get(ClientResponse.class);

	String corpsRepHttp= resp.getEntity(String.class);
	//System.out.println(corpsRepHttp);
	ObjectMapper mapper = new ObjectMapper();
	//System.out.println("helooo1"+corpsRepHttp);
	Station st = mapper.readValue(corpsRepHttp, Station.class);
	
	%>
	<div class="container">
		<h1>Station Crud Update</h1>
		<br>
		<h2>UPDATE</h2>
		<form action="UpdateStation" method="post">
		
					<input type="hidden" name="id" class="form-control" id="name" placeholder="Enter Name" value="<%=id%>">
					
			<div class="form-group">
				<label class="control-label col-sm-2" for="email">Nom:</label>
				<div class="col-sm-10">
					<input type="text" name="nom" class="form-control" id="name" placeholder="Enter Name" value="<%=st.getNom()%>">
				</div>
			</div>
			
			<div class="form-group">
				<label class="control-label col-sm-2" for="pwd">Ville:</label>
				<div class="col-sm-10">

					<input type="text" class="form-control" id="cty" placeholder="Enter City" name="ville" value="<%=st.getVille()%>">
				</div>
			</div>
			
			<div class="form-group">
				<label class="control-label col-sm-2" for="pwd">Adresse:</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="addr" placeholder="Enter Address" name="adresse" value="<%=st.getAdresse()%>">
				</div>
			</div>
			
			<br> <input type="submit" value="SAVE" class="btn btn-success">
		</form>
	</div>
	<br>
</body>
</html>
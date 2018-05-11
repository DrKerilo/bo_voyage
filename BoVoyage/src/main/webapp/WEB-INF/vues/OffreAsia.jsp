<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


	<h1 style="color: red; text-align: center">Liste des Offres d'Asia</h1>

	<br />
	<div align="center">

		<table class="table table-bordered" style="text-align: center">
			<tr style="text-align: center">
				<th>ID</th>
				<th>Prix public</th>
				<th>Continent</th>
				
			</tr>
			<c:forEach var="as" items="${listeAs}">
				<tr>
					<td>${as.id}</td>
					<td>${as.prixPublic}</td>
					<td>${as.destination.continent}</td>
				</tr>
			</c:forEach>
		</table>
	</div>

	<br />
</body>
</html>
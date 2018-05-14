<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Page accueil</title>

<!-- Spécifier le chemin du fichier bootstrap.css -->
<link rel="stylesheet"
	href="<c:url value='/resources/css/bootstrap.css' />" />
<script type="text/javascript"
	src="<c:url value='/resources/js/jquery-3.3.1.js'/>"></script>
<script type="text/javascript"
	src="<c:url value='/resources/js/bootstrap.js'/>"></script>


</head>

<body>

	<%@include file="/resources/template/header.html"%>

	<h1 style="color: pink; text-align: center">Liste des hotels</h1>
	<div align="center">
		<table class="table table-bordered">
			<tr>
				<th>ID</th>
				<th>Nom</th>
				<th>Nombre d'étoiles</th>
				<th>Date d'arrivée</th>
				<th>Heure d'arrivée</th>
				<th>Date de départ</th>
				<th>Heure de départ</th>
				<th>Numero</th>
				<th>Rue</th>
				<th>Code Postal</th>
				<th>Ville</th>
			</tr>

			<c:forEach var="h" items="${listeHotelsOff}">
				<tr>
					<td>${h.id}</td>
					<td>${h.nom}</td>
					<td>${h.etoile}</td>
					<td>${h.horaire.dateDep}</td>
					<td>${h.horaire.heureDep}</td>
					<td>${h.horaire.dateRet}</td>
					<td>${h.horaire.heureRet}</td>
					<td>${h.adresse.numero}</td>
					<td>${h.adresse.rue}</td>
					<td>${h.adresse.codePostal}</td>
					<td>${h.adresse.ville}</td>
			</tr>



			</c:forEach>

		</table>



	</div>
</body>
</html>
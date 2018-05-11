<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>

<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Client connecté</title>

<!-- Spécifier le chemin du fichier bootstrap.css -->
<link rel="stylesheet"
	href="<c:url value='/resources/css/bootstrap.css' />" />
<script type="text/javascript"
	src="<c:url value='/resources/js/jquery-3.3.1.js'/>"></script>
<script type="text/javascript"
	src="<c:url value='/resources/js/bootstrap.js'/>"></script>
<script type="text/javascript"
	src="<c:url value='/resources/js/monJs.js'/>"></script>


</head>

<body>

	<nav class="navbar navbar-inverse">
		<ul class="nav nav-tabs">
		<li><a href="<c:url value='/clientCTRL/afficheModifClient'/>">Modifier ses coordonnées</a></li>
		<li><a href="<c:url value='/resaCTRL/supLink/{cl.id}'/>" data-confirm="Etes-vous certain de vouloir supprimer?">Supprimer son comptes</a></li>
		</ul>
	</nav>
	
	<br/>
	
	<h1 style="color: greenyellow; text-align: center">Liste des
		réservations</h1>

	<br />

	<div align="center" class="table-responsive">

		<table class="table table-hover" style="text-align: center;">

			<tr>
				<th style="text-align: center;">#</th>
				<th style="text-align: center;">N°dossier</th>
				<th style="text-align: center;">Etat</th>
				<th style="text-align: center;">Assurance</th>
				<th style="text-align: center;">Nb places</th>
				<th style="text-align: center;">Prix total</th>
				<th style="text-align: center;">#Client</th>
				<th style="text-align: center;">#Offre</th>
				<th style="text-align: center;">#Compte</th>
				<th style="text-align: center;">Opérations</th>
			</tr>

			<c:forEach var="res" items="${listeResasByCl}">

				<tr>
					<td>${res.id}</td>
					<td>${res.numDossier}</td>
					<td>${res.etat}</td>
					<td>${res.assurance}</td>
					<td>${res.nbPlaces}</td>
					<td>${res.prixRes}</td>
					<td>${res.client.id}</td>
					<td>${res.offre.id}</td>
					<td>${res.compte.id}</td>
					<td><a href="<c:url value='/resaCTRL/supLink/${res.id}'/>" data-confirm="Etes-vous certain de vouloir supprimer?">Supprimer</a>
						| <a href="<c:url value='/resaCTRL/modifLink?pId=${res.id}'/>">Modifier</a></td>
				</tr>

			</c:forEach>

		</table>

	</div>


</body>
</html>
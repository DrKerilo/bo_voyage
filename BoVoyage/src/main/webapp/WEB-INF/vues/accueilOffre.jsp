<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Liste Offres</title>

<!-- pour utiliser bootstrapjs-->
<script type="text/javascript"
	src="<c:url value='/resources/js/jquery-3.3.1.js'/>"></script>

<!-- pour utiliser bootstrapjs-->
<script type="text/javascript"
	src="<c:url value='/resources/js/bootstrap.js'/>"></script>

<!-- pour utiliser bootstrap -->
<link rel="stylesheet"
	href="<c:url value='/resources/css/bootstrap.css'/>" />


</head>
<body>

<nav class="navbar navbar-inverse">
		<ul class="nav nav-pills">
			<li role="presentation"><a
				href="${pageContext.request.contextPath}/agCTRL/listeO">Liste Offre</a></li>
			<li role="presentation"><a
				href="${pageContext.request.contextPath}/agCTRL/afficheAjoutO">Ajouter</a></li>
			<li role="presentation"><a
				href="${pageContext.request.contextPath}/agCTRL/affichModifO">Modifier</a></li>
			<li role="presentation"><a
				href="${pageContext.request.contextPath}/agCTRL/afficheSupprO">Supprimer</a></li>
			<li role="presentation"><a
				href="${pageContext.request.contextPath}/agCTRL/affichRecO">Rechercher
					par id</a></li>
	</nav>

<br />
	<h1 style="color: red; text-align: center">Liste des Offres</h1>

	<br />
	<div align="center">

		<table class="table table-bordered" style="text-align: center">
			<tr style="text-align: center">
				<th>ID</th>
				<th>formule</th>
				<th>Destination Continent</th>
				<th>Destination Pays</th>
				<th>Destination Ville</th>
				<th>hébergement</th>
				<th>référence</th>
				<th>date départ</th>
				<th>date retour</th>
				<th>nombre de places disponibles</th>
				<th>statut</th>
				<th>prix publix</th>
				<
				<th>Operations</th>
			</tr>
			<c:forEach var="v" items="${listeVols}">
				<tr>
					<td>${v.id}</td>
					<td>${v.modele}</td>
					<td>${v.aeroportDep}</td>
					<td>${v.aeroportArr}</td>
					<td>le ${v.horaire.dateDep} à ${v.horaire.heureDep}</td>
					<td>le ${v.horaire.dateRet} à ${v.horaire.heureRet}</td>
					<td><a
						href="${pageContext.request.contextPath}/mCTRL/supprLink/${m.id}">Supprimer</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>

	<br />




</body>
</html>
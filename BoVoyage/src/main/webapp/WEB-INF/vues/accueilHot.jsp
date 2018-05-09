<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Page accueil</title>
<!-- Spécifier le chemin du fichier Bootstrap.css href : pageContext.request.contextPath pour récupérer la première partie du chemin http:// jusqu'au nom du projet-->
<link rel="stylesheet"
	href="<c:url value='/resources/css/bootstrap.css'/>" />
</head>
<body>

	<!--  -->
	<nav class="navbar navbar-inverse">
		<ul class="nav nav-pills">
			<li role="presentation"><a
				href="${pageContext.request.contextPath}/hCTRL/listeHotels">Accueil</a></li>
			<li role="presentation"><a
				href="<c:url value='/eCTRL/affFormAjout'/>">Ajouter</a></li>
			<li role="presentation"><a
				href="${pageContext.request.contextPath}/eCTRL/modifForm">Modifier</a></li>
			<li role="presentation"><a
				href="${pageContext.request.contextPath}/eCTRL/suppForm">Supprimer</a></li>
			<li role="presentation"><a
				href="<c:url value='/eCTRL/searchForm'/>">Rechercher</a></li>
			<li role="presentation"><a
				href="<c:url value='/j_spring_security_logout'/>">Se déconnecter</a></li>
		</ul>
	</nav>







	<hr />
	<h1 style="color: pink; text-align: center">Liste des hotels</h1>
	<div align="center">
		<table class="table table-bordered">
			<tr>
				<th>ID</th>
				<th>Nom</th>
				<th>Nombre d'étoiles</th>
				<th>Photo</th>
				<th>Date d'arrivée</th>
				<th>Heure d'arrivée</th>
				<th>Date de départ</th>
				<th>Heure de départ</th>
				<th>Numero</th>
				<th>Rue</th>
				<th>Code Postal</th>
				<th>Ville</th>
			</tr>

			<c:forEach var="h" items="${listeH}">
				<tr>
					<td>${h.id}</td>
					<td>${h.nom}</td>
					<td>${h.etoile}</td>
					<td>${h.image}</td>
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
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Afficher la liste des réservations pour un client</title>

<link rel="stylesheet"
	href="<c:url value='/resources/css/bootstrap.css' />" />
</head>

<body>

	<nav class="navbar navbar-inverse">
		<ul class="nav nav-tabs">
			<li><a
				href="${pageContext.request.contextPath}/clientCTRL/listeClient">Liste</a></li>
			<li><a href="<c:url value='/clientCTRL/afficheAjoutClient'/>">Ajouter</a></li>
			<li><a href="<c:url value='/clientCTRL/afficheModifClient'/>">Modifier</a></li>
			<li><a href="<c:url value='/clientCTRL/afficheRechClient'/>">Rechercher</a></li>
			<li><a href="<c:url value='/resaCTRL/rechResaByClient'/>">Réservation</a></li>
		</ul>
	</nav>

	<form:form cssClass="form-horizontal" action="soumettreRechResaByCl"
		method="post" modelAttribute="resaRechCl">

		<div class="form-group">
			<form:label cssClass="col-sm-2 control-label" path="id">#</form:label>
			<div class="col-sm-2">
				<form:input cssClass="form-control" path="id" />
			</div>
		</div>

		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<form:button cssClass="btn btn-default" type="submit">Rechercher</form:button>
			</div>
		</div>

	</form:form>

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
				<th style="text-align: center;">Annuler la réservation</th>
			</tr>

			<c:forEach var="res" items="${listeRechResa}">

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
					<td><a href="<c:url value='/resaCTRL/supLink/${res.id}'/>">annuler</a></td>
				</tr>

			</c:forEach>

		</table>

	</div>

</body>
</html>
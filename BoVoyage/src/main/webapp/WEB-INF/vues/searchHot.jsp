<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Page recherche hotel</title>

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

	<h1 style="color: red; text-align: center">Formulaire de recherche
		d'un hôtel</h1>

	<form:form cssClass="form-horizontal" method="POST"
		action="soumSearchHot" modelAttribute="hSearch">
		<div class="form-group">
			<form:label cssClass="col-sm-2 control-label" path="id">Id de l'hôtel recherché</form:label>
			<div class="col-sm-8">
				<form:input cssClass="form-control" placeholder="Id" path="id" />
			</div>
		</div>

		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-8">
				<button type="submit" class="btn btn-default">Rechercher</button>
			</div>
		</div>
	</form:form>

	<hr />
	<h1 style="color: red; text-align: center">Liste des hotels</h1>


	<br />
	<div align="center">

		<table class="table table-bordered" style="text-align: center">
			<tr style="text-align: center">
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

				<tr>
					<td>${hTrouve.id}</td>
					<td>${hTrouve.nom}</td>
					<td>${hTrouve.etoile}</td>
					<td>${hTrouve.image}</td>
					<td>${hTrouve.horaire.dateDep}</td>
					<td>${hTrouve.horaire.heureDep}</td>
					<td>${hTrouve.horaire.dateRet}</td>
					<td>${hTrouve.horaire.heureRet}</td>
					<td>${hTrouve.adresse.numero}</td>
					<td>${hTrouve.adresse.rue}</td>
					<td>${hTrouve.adresse.codePostal}</td>
					<td>${hTrouve.adresse.ville}</td>
				</tr>

		</table>
	</div>

	<br />






</body>
</html>
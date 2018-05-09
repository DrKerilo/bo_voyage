<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>

<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Rechercher une réservation</title>

<!-- Spécifier le chemin du fichier bootstrap.css -->
<link rel="stylesheet"
	href="<c:url value='/resources/css/bootstrap.css' />" />

</head>


<body>

	<nav class="navbar navbar-inverse">
		<ul class="nav nav-tabs">
			<li><a
				href="${pageContext.request.contextPath}/resaCTRL/listeResa">Liste</a></li>
			<li><a href="<c:url value='/resaCTRL/afficheAjoutResa'/>">Ajouter</a></li>
			<li><a href="<c:url value='/resaCTRL/afficheModifResa'/>">Modifier</a></li>
			<li><a href="<c:url value='/resaCTRL/afficheRechResa'/>">Rechercher</a></li>
		</ul>
	</nav>

	<form:form cssClass="form-horizontal" action="soumettreRechResa"
		method="post" modelAttribute="resaRech">

		<div class="form-group">
			<form:label cssClass="col-sm-2 control-label" path="id"># :</form:label>
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
				<th style="text-align: center;">Opérations</th>
			</tr>


			<tr>
				<td>${resaFind.id}</td>
				<td>${resaFind.numDossier}</td>
				<td>${resaFind.etat}</td>
				<td>${resaFind.assurance}</td>
				<td>${resaFind.nbPlaces}</td>
				<td>${resaFind.prixRes}</td>
				<td>${resaFind.client.id}</td>
				<td>${resaFind.offre.id}</td>
				<td>${resaFind.compte.id}</td>
				<td><a href="<c:url value='/resaCTRL/supLink/${resaFind.id}'/>">Supprimer</a>
					| <a href="<c:url value='/resaCTRL/modifLink?pId=${resaFind.id}'/>">Modifier</a></td>
			</tr>

		</table>

	</div>

	<h1 style="color: red; text-align: center;">${msg}</h1>

</body>
</html>
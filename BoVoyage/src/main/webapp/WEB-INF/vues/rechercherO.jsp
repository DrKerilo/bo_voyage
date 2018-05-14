<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Page recherche vol</title>
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

<%@include file="/resources/template/header.html"%>
<h1 style="color: red; text-align: center">Formulaire de recherche
		des Offres</h1>

	<form:form cssClass="form-horizontal" method="POST"
		action="soumettreRecO" modelAttribute="oRec">
		<div class="form-group">
			<form:label cssClass="col-sm-2 control-label"
				path="id">Id de l'offre recherchée</form:label>
			<div class="col-sm-8">
				<form:input cssClass="form-control"
					placeholder="Id" path="id" />
			</div>
		</div>

			<div class="form-group">
			<div class="col-sm-offset-2 col-sm-8">
				<button type="submit" class="btn btn-default">Rechercher</button>
			</div>
		</div>
	</form:form>

	<hr />
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
				<th>vol</th>
				<th>nombre de places disponibles</th>
				<th>statut</th>
				<th>prix publix</th>
				<th>prix BoVoyage</th>
				<th>hotel</th>
				<th>photo<th>
			
			</tr>
			
				<tr>
					<td>${oFind.id}</td>
					<td>${oFind.formule}</td>
					<td>${oFind.destination.continent}</td>
					<td>${oFind.destination.pays}</td>
					<td>${oFind.destination.ville}</td>
					<td>${oFind.hebergement}</td>
					<td>${oFind.reference}</td>
					<td>${oFind.dateDep}</td>
					<td>${oFind.dateRet}</td>
					<td><a href="${pageContext.request.contextPath}/agCTRL/listeVOffre/${oFind.id}">Liste des vols</a></td>
					<td>${oFind.nbPlacesDispo}</td>
					<td>${oFind.statut}</td>
					<td>${oFind.prixPublic}</td>
					<td>${oFind.prixBoV}</td>
					<td><a href="${pageContext.request.contextPath}/agCTRL/listeHOffre/${oFind.id}">Liste des hotels</a></td>
					<td><c:forEach var="im" items="${oFind.images}">
						<img src="${im}" width="30" height="30">
					</c:forEach></td>
					
				</tr>
		
		</table>
	</div>

	<br />






</body>
</html>
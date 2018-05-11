<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<!DOCTYPE html>
<html>

<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Modifier une réservation</title>

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

	<form:form cssClass="form-horizontal" action="soumettreModifResa"
		method="post" modelAttribute="resaModif">

		<div class="form-group">
			<form:label cssClass="col-sm-2 control-label" path="id"># :</form:label>
			<div class="col-sm-2">
				<form:input cssClass="form-control" path="id" />
			</div>
		</div>

		<div class="form-group">
			<form:label cssClass="col-sm-2 control-label" path="numDossier">N°dossier</form:label>
			<div class="col-sm-2">
				<form:input type="text" cssClass="form-control" path="numDossier" />
			</div>
		</div>

		<div class="form-group">
			<form:label cssClass="col-sm-2 control-label" path="etat">Etat</form:label>
			<div class="col-sm-2">
				<form:input type="text" cssClass="form-control" path="etat" />
			</div>
		</div>

		<div class="form-group">
			<form:label cssClass="col-sm-2 control-label" path="assurance">Assurance</form:label>
			<div class="col-sm-2">
				<form:input type="text" cssClass="form-control" path="assurance" />
			</div>
		</div>
		
		<div class="form-group">
			<form:label cssClass="col-sm-2 control-label" path="nbPlaces">Nb places</form:label>
			<div class="col-sm-2">
				<form:input type="number" cssClass="form-control" path="nbPlaces" />
			</div>
		</div>
		
		<div class="form-group">
			<form:label cssClass="col-sm-2 control-label" path="prixRes">Prix total</form:label>
			<div class="col-sm-2">
				<form:input type="number" cssClass="form-control" path="prixRes" />
			</div>
		</div>
		
		<div class="form-group">
			<form:label cssClass="col-sm-2 control-label" path="client.id">#Client</form:label>
			<div class="col-sm-2">
				<form:input type="number" cssClass="form-control" path="client.id" />
			</div>
		</div>
		
		<div class="form-group">
			<form:label cssClass="col-sm-2 control-label" path="offre.id">#Offre</form:label>
			<div class="col-sm-2">
				<form:input type="number" cssClass="form-control" path="offre.id" />
			</div>
		</div>
		
		<div class="form-group">
			<form:label cssClass="col-sm-2 control-label" path="compte.id">#Compte</form:label>
			<div class="col-sm-2">
				<form:input type="number" cssClass="form-control" path="compte.id" />
			</div>
		</div>

		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<form:button type="submit" cssClass="btn btn-default">Modifier</form:button>
			</div>
		</div>

	</form:form>
</body>
</html>
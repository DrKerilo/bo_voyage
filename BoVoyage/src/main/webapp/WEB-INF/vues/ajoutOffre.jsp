<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ajout Offre</title>
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

	<hr />
	<h1 style="color: red; text-align: center">Ajouter une Offre</h1>

	<form:form cssClass="form-horizontal" method="POST"
		action="soumettreAjoutO" modelAttribute="oAjout"
		enctype="multipart/form-data">

		<div class="form-group">
			<form:label cssClass="col-sm-offset-2 col-sm-2 control-label" path="formule">Formule</form:label>
			<div class="col-sm-4">
				<form:select cssClass="form-control" placeholder="formule"
					path="formule">
					<OPTION cssClass="form-control" placeholder="formule"
						path="formule">Avion</option>
					<OPTION cssClass="form-control" placeholder="formule"
						path="formule">Hotel</option>
					<OPTION cssClass="form-control" placeholder="formule"
						path="formule">Avion + Hotel</option>
					<OPTION cssClass="form-control" placeholder="formule"
						path="formule">Avion + Voiture</option>
					<OPTION cssClass="form-control" placeholder="formule"
						path="formule">Avion + Hotel + Voiture</option>
				</form:select>
			</div>
		</div>

		<div class="form-group">
			<form:label cssClass="col-sm-offset-2 col-sm-2 control-label"
				path="destination.continent">destination continent</form:label>
			<div class="col-sm-4">
				<form:select cssClass="form-control" placeholder="Continent"
					path="destination.continent">
					<OPTION cssClass="form-control" path="formule">Afrique</option>
					<OPTION cssClass="form-control" path="formule">Afrique du Nord</option>
					<OPTION cssClass="form-control" path="formule">Amerique du Nord</option>
					<OPTION cssClass="form-control" path="formule">Amerique du Sud</option>
					<OPTION cssClass="form-control" path="formule">Asie</option>
					<OPTION cssClass="form-control" path="formule">Europe</option>
				</form:select>
			</div>
		</div>

		<div class="form-group">
			<form:label cssClass="col-sm-offset-2 col-sm-2 control-label" path="destination.pays">destination pays</form:label>
			<div class="col-sm-4">
				<form:input cssClass="form-control" placeholder="destination.pays"
					path="destination.pays" />
			</div>
		</div>
		<div class="form-group">
			<form:label cssClass="col-sm-offset-2 col-sm-2 control-label"
				path="destination.ville">Destination ville</form:label>
			<div class="col-sm-4">
				<form:input cssClass="form-control" placeholder="destination.ville"
					path="destination.ville" />
			</div>
		</div>


		<div class="form-group">
			<form:label cssClass="col-sm-offset-2 col-sm-2 control-label" path="hebergement">Hebergement</form:label>
			<div class="col-sm-4">
				<form:select cssClass="form-control" placeholder="hebergement"
					path="hebergement">
					<option cssClass="form-control" placeholder="hebergement"
						path="hebergement">Hébergement seul</option>
					<option cssClass="form-control" placeholder="hebergement"
						path="hebergement">Petit-déjeuner</option>
					<option cssClass="form-control" placeholder="hebergement"
						path="hebergement">Demi-pension</option>
					<option cssClass="form-control" placeholder="hebergement"
						path="hebergement">Pension complete</option>
				</form:select>
			</div>
		</div>


		<div class="form-group">
			<form:label cssClass="col-sm-offset-2 col-sm-2 control-label" path="reference">reference</form:label>
			<div class="col-sm-4">
				<form:input cssClass="form-control" placeholder="reference"
					path="reference" />
			</div>
		</div>

		<div class="form-group">
			<form:label cssClass="col-sm-offset-2 col-sm-2 control-label" path="dateDep">Date départ</form:label>
			<div class="col-sm-4">
				<form:input type="date" cssClass="form-control"
					placeholder="dateDep" path="dateDep" />
			</div>
		</div>

		<div class="form-group">
			<form:label cssClass="col-sm-offset-2 col-sm-2 control-label" path="dateRet">Date retour</form:label>
			<div class="col-sm-4">
				<form:input type="date" cssClass="form-control"
					placeholder="dateRet" path="dateRet" />
			</div>
		</div>

		<div class="form-group">
			<form:label cssClass="col-sm-offset-2 col-sm-2 control-label" path="nbPlacesDispo">nbPlacesDispo</form:label>
			<div class="col-sm-4">
				<form:input cssClass="form-control" placeholder="nbPlacesDispo"
					path="nbPlacesDispo" />
			</div>
		</div>

		<div class="form-group">
			<form:label cssClass="col-sm-offset-2 col-sm-2 control-label" path="statut">Statut</form:label>
			<div class="col-sm-4">
				<form:select cssClass="form-control" placeholder="statut"
					path="statut">
					<OPTION cssClass="form-control" placeholder="statut" path="statut">Ouvert
					<OPTION cssClass="form-control" placeholder="statut" path="statut">Clos
				</form:select>
			</div>
		</div>

		<div class="form-group">
			<form:label cssClass="col-sm-offset-2 col-sm-2 control-label" path="prixPublic">Prix public</form:label>
			<div class="col-sm-4">
				<form:input cssClass="form-control" placeholder="prixPublic"
					path="prixPublic" />
			</div>
		</div>

		<div class="form-group">
			<form:label cssClass="col-sm-offset-2 col-sm-2 control-label" path="prixBoV">Prix BoVoyage</form:label>
			<div class="col-sm-4">
				<form:input cssClass="form-control" placeholder="prixBoV"
					path="prixBoV" />
			</div>
		</div>

		<div class="form-group">
			<label class="col-sm-offset-2 col-sm-2 control-label">Images</label>
			<div class="col-sm-4">
				<input name="upFiles" id="fileToUpload" type="file" multiple />
			</div>
		</div>

		<div class="form-group">
			<div class="col-sm-offset-4 col-sm-4">
				<button type="submit" class="btn btn-default">Ajouter</button>
			</div>
		</div>
	</form:form>



</body>
</html>
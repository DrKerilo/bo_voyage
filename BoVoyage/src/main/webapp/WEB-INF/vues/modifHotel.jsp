<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Page de modification</title>
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
	<hr />
	<h1 style="color: red; text-align: center">MODIFIER LES INFOS D'UN
		HOTEL</h1>
	<!-- Dans action on doit mettre l'URI de la méthode (model Attribute peut être remplacé par command Name-->
	<form:form class="form-horizontal" method="POST" action="soumModifHot"
		modelAttribute="hModif">



		<div class="form-group">
			<form:label cssClass="col-sm-2 control-label" path="id">Id de l'hôtel à modifier</form:label>
			<div class="col-sm-8">
				<form:input cssClass="form-control" placeholder="id" path="id" />
			</div>
		</div>



		<div class="form-group">
			<form:label cssClass="col-sm-2 control-label" path="nom">Nom de l'hotel</form:label>
			<div class="col-sm-8">
				<form:input type="text" cssClass="form-control" placeholder="Nom"
					path="nom" />
			</div>
		</div>

		<div class="form-group">
			<form:label cssClass="col-sm-2 control-label" path="etoile">Nombre d'étoiles</form:label>
			<div class="col-sm-8">
				<form:input type="text" cssClass="form-control"
					placeholder="Nombre d'étoiles" path="etoile" />
			</div>
		</div>


		<div class="form-group">
			<form:label cssClass="col-sm-2 control-label" path="adresse.numero">Numéro de rue</form:label>
			<div class="col-sm-8">
				<form:input type="text" cssClass="form-control" placeholder="numéro"
					path="adresse.numero" />
			</div>
		</div>

		<div class="form-group">
			<form:label cssClass="col-sm-2 control-label" path="adresse.rue">Nom de la rue</form:label>
			<div class="col-sm-8">
				<form:input type="text" cssClass="form-control" placeholder="rue"
					path="adresse.rue" />
			</div>
		</div>

		<div class="form-group">
			<form:label cssClass="col-sm-2 control-label"
				path="adresse.codePostal">Code Postal</form:label>
			<div class="col-sm-8">
				<form:input type="text" cssClass="form-control"
					placeholder="code postal" path="adresse.codePostal" />
			</div>
		</div>

		<div class="form-group">
			<form:label cssClass="col-sm-2 control-label" path="adresse.ville">Ville</form:label>
			<div class="col-sm-8">
				<form:input type="text" cssClass="form-control" placeholder="ville"
					path="adresse.ville" />
			</div>
		</div>

		<div class="form-group">
			<form:label cssClass="col-sm-2 control-label" path="horaire.dateDep">Date arrivée</form:label>
			<div class="col-sm-8">
				<form:input type="date" cssClass="form-control"
					placeholder="date d'arrivée à l'hôtel" path="horaire.dateDep" />
			</div>
		</div>



		<div class="form-group">
			<form:label cssClass="col-sm-2 control-label" path="horaire.dateRet">Date départ</form:label>
			<div class="col-sm-8">
				<form:input type="date" cssClass="form-control"
					placeholder="date de départ de l'hôtel" path="horaire.dateRet" />
			</div>
		</div>


		<div class="form-group">
			<form:label cssClass="col-sm-2 control-label" path="horaire.heureDep">Heure d'arrivée</form:label>
			<div class="col-sm-8">
				<input type="time" class="form-control" name="heure" />
			</div>
		</div>

		<div class="form-group">
			<form:label cssClass="col-sm-2 control-label" path="horaire.heureRet">Heure de départ</form:label>
			<div class="col-sm-8">
				<input type="time" class="form-control" name="heure2" />
			</div>
		</div>





		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-8">
				<button type="submit" class="btn btn-default">MODIFIER</button>
			</div>
		</div>
	</form:form>



</body>
</html>
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
	<!-- Dans action on doit mettre l'URI de la m�thode (model Attribute peut �tre remplac� par command Name-->
	<form:form class="form-horizontal" method="POST" action="soumModifHot"
		modelAttribute="hModif">



		<div class="form-group">
			<form:label cssClass="col-sm-2 control-label" path="id">Id de l'h�tel � modifier</form:label>
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
			<form:label cssClass="col-sm-2 control-label" path="etoile">Nombre d'�toiles</form:label>
			<div class="col-sm-8">
				<form:input type="text" cssClass="form-control"
					placeholder="Nombre d'�toiles" path="etoile" />
			</div>
		</div>


		<div class="form-group">
			<form:label cssClass="col-sm-2 control-label" path="adresse.numero">Num�ro de rue</form:label>
			<div class="col-sm-8">
				<form:input type="text" cssClass="form-control" placeholder="num�ro"
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
			<form:label cssClass="col-sm-2 control-label" path="horaire.dateDep">Date arriv�e</form:label>
			<div class="col-sm-8">
				<form:input type="date" cssClass="form-control"
					placeholder="date d'arriv�e � l'h�tel" path="horaire.dateDep" />
			</div>
		</div>



		<div class="form-group">
			<form:label cssClass="col-sm-2 control-label" path="horaire.dateRet">Date d�part</form:label>
			<div class="col-sm-8">
				<form:input type="date" cssClass="form-control"
					placeholder="date de d�part de l'h�tel" path="horaire.dateRet" />
			</div>
		</div>


		<div class="form-group">
			<form:label cssClass="col-sm-2 control-label" path="horaire.heureDep">Heure d'arriv�e</form:label>
			<div class="col-sm-8">
				<input type="time" class="form-control" name="heure" />
			</div>
		</div>

		<div class="form-group">
			<form:label cssClass="col-sm-2 control-label" path="horaire.heureRet">Heure de d�part</form:label>
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
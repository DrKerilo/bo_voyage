<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<!DOCTYPE html>
<html>

<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Modifier un client</title>

<link rel="stylesheet" href="<c:url value='/resources/css/bootstrap.css' />" />
	
</head>


<body>

	<nav class="navbar navbar-inverse">
		<ul class="nav nav-tabs">
			<li><a
				href="${pageContext.request.contextPath}/clientCTRL/listeClient">Liste</a></li>
			<li><a href="<c:url value='/clientCTRL/afficheAjoutClient'/>">Ajouter</a></li>
			<li><a href="<c:url value='/clientCTRL/afficheModifClient'/>">Modifier</a></li>
			<li><a href="<c:url value='/clientCTRL/afficheRechClient'/>">Rechercher</a></li>
		</ul>
	</nav>

	<form:form cssClass="form-horizontal" action="soumettreModifClient"
		method="post" modelAttribute="clModif">
		
		<div class="form-group">
			<form:label cssClass="col-sm-2 control-label" path="id">#</form:label>
			<div class="col-sm-2">
				<form:input type="number" cssClass="form-control" path="id" />
			</div>
		</div>

		<div class="form-group">
			<form:label cssClass="col-sm-2 control-label" path="civilite">Civilité</form:label>
			<div class="col-sm-2">
				<form:input type="text" cssClass="form-control" path="civilite" />
			</div>
		</div>

		<div class="form-group">
			<form:label cssClass="col-sm-2 control-label" path="nom">Nom</form:label>
			<div class="col-sm-2">
				<form:input type="text" cssClass="form-control" path="nom" />
			</div>
		</div>

		<div class="form-group">
			<form:label cssClass="col-sm-2 control-label" path="prenom">Prénom</form:label>
			<div class="col-sm-2">
				<form:input type="text" cssClass="form-control" path="prenom" />
			</div>
		</div>
		
		<div class="form-group">
			<form:label cssClass="col-sm-2 control-label" path="dn">Date de naissance</form:label>
			<div class="col-sm-2">
				<form:input type="date" cssClass="form-control" path="dn" />
			</div>
		</div>
		
		<div class="form-group">
			<form:label cssClass="col-sm-2 control-label" path="adresse.numero">Numéro</form:label>
			<div class="col-sm-2">
				<form:input type="number" cssClass="form-control" path="adresse.numero" />
			</div>
		</div>
		
		<div class="form-group">
			<form:label cssClass="col-sm-2 control-label" path="adresse.rue">Rue</form:label>
			<div class="col-sm-2">
				<form:input type="text" cssClass="form-control" path="adresse.rue" />
			</div>
		</div>
		
		<div class="form-group">
			<form:label cssClass="col-sm-2 control-label" path="adresse.codePostal">Code postal</form:label>
			<div class="col-sm-2">
				<form:input type="text" cssClass="form-control" path="adresse.codePostal" />
			</div>
		</div>
		
		<div class="form-group">
			<form:label cssClass="col-sm-2 control-label" path="adresse.ville">Ville</form:label>
			<div class="col-sm-2">
				<form:input type="text" cssClass="form-control" path="adresse.ville" />
			</div>
		</div>
		
		<div class="form-group">
			<form:label cssClass="col-sm-2 control-label" path="mail">Mail</form:label>
			<div class="col-sm-2">
				<form:input type="email" cssClass="form-control" path="mail" />
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
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

	<%@include file="/resources/template/header.html"%>	

<hr />
	<h1 style="color: red; text-align: center">Modifier un vol</h1>

	<form:form cssClass="form-horizontal" method="POST" action="soumettreModifV"
		modelAttribute="hModif">
		
		<div class="form-group">
			<form:label cssClass="col-sm-2 control-label" path="id">id</form:label>
			<div class="col-sm-8">
				<form:input cssClass="form-control" placeholder="id" path="id" />
			</div>
		</div>
		
		<div class="form-group">
			<form:label cssClass="col-sm-2 control-label" path="modele">Modele d'avion</form:label>
			<div class="col-sm-8">
				<form:input cssClass="form-control" placeholder="Modele" path="modele" />
			</div>
		</div>

		<div class="form-group">
			<form:label cssClass="col-sm-2 control-label" path="aeroportDep">Aeroport de départ</form:label>
			<div class="col-sm-8">
				<form:input cssClass="form-control" placeholder="aeroportDep"
					path="aeroportDep" />
			</div>
		</div>
		
		
		<div class="form-group">
			<form:label cssClass="col-sm-2 control-label" path="aeroportArr">Aeroport d'arrivée</form:label>
			<div class="col-sm-8">
				<form:input cssClass="form-control" placeholder="aeroportArr"
					path="aeroportArr" />
			</div>
		</div>
		
		<div class="form-group">
			<form:label cssClass="col-sm-2 control-label" path="horaire.dateDep">Date départ</form:label>
			<div class="col-sm-8">
				<form:input type="date" cssClass="form-control"
					placeholder="horaire.dateDep" path="horaire.dateDep" />
			</div>
		</div>

		<div class="form-group">
			<form:label cssClass="col-sm-2 control-label" path="horaire.dateRet">Date retour</form:label>
			<div class="col-sm-8">
				<form:input type="date" cssClass="form-control"
					placeholder="horaire.dateRet" path="horaire.dateRet" />
			</div>
		</div>
		
		<div class="form-group">
			<form:label cssClass="col-sm-2 control-label" path="horaire.heureDep">Heure départ</form:label>
			<div class="col-sm-8">
				<input type="time" class="form-control"
					name="heure"/>
			</div>
		</div>


		<div class="form-group">
			<form:label cssClass="col-sm-2 control-label" path="horaire.heureRet">Heure retour</form:label>
			<div class="col-sm-8">
				<input type="time" class="form-control"
					name="heure2"/>
			</div>
		</div>
		

		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-8">
				<button type="submit" class="btn btn-default">Modifier</button>
			</div>
		</div>
	</form:form>



</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Modification Offre</title>
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
	<h1 style="color: red; text-align: center">Modifier une Offre</h1>

	<form:form cssClass="form-horizontal" method="POST"
		action="soumettreModifO" modelAttribute="oModif">
		<div class="form-group">
			<form:label cssClass="col-sm-2 control-label" path="id">id</form:label>
			<div class="col-sm-8">
				<form:input cssClass="form-control" placeholder="id"
					path="id" />
			</div>
		</div>
		

		<div class="form-group">
			<form:label cssClass="col-sm-2 control-label" path="formule">Formule</form:label>
			<div class="col-sm-8">
				<SELECT cssClass="form-control" placeholder="formule" path="formule">
					<OPTION>Avion
					<OPTION>Hotel
					<OPTION>Avion + Hotel
					<OPTION>Avion + Voiture
					<OPTION>Avion + Hotel + Voiture
				</SELECT>
			</div>
		</div>

		<div class="form-group">
			<form:label cssClass="col-sm-2 control-label"
				path="destination.continent">destination continent</form:label>
			<div class="col-sm-8">
				<form:input cssClass="form-control"
					placeholder="destination.continent" path="destination.continent" />
			</div>
		</div>

		<div class="form-group">
			<form:label cssClass="col-sm-2 control-label" path="destination.pays">destination pays</form:label>
			<div class="col-sm-8">
				<form:input cssClass="form-control" placeholder="destination.pays"
					path="destination.pays" />
			</div>
		</div>
		<div class="form-group">
			<form:label cssClass="col-sm-2 control-label"
				path="destination.ville">destination ville</form:label>
			<div class="col-sm-8">
				<form:input cssClass="form-control" placeholder="destination.ville"
					path="destination.ville" />
			</div>
		</div>


		<div class="form-group">
			<form:label cssClass="col-sm-2 control-label" path="hebergement">Hebergement</form:label>
			<div class="col-sm-8">
				<SELECT cssClass="form-control" placeholder="hebergement"
					path="hebergement">
					<OPTION>hébergement seul
					<OPTION>petit déjeuner
					<OPTION>demi pension
					<OPTION>pension complete
				</SELECT>
			</div>
		</div>


		<div class="form-group">
			<form:label cssClass="col-sm-2 control-label" path="reference">reference</form:label>
			<div class="col-sm-8">
				<form:input cssClass="form-control" placeholder="reference"
					path="reference" />
			</div>
		</div>

		<div class="form-group">
			<form:label cssClass="col-sm-2 control-label" path="dateDep">Date départ</form:label>
			<div class="col-sm-8">
				<form:input type="date" cssClass="form-control"
					placeholder="dateDep" path="dateDep" />
			</div>
		</div>

		<div class="form-group">
			<form:label cssClass="col-sm-2 control-label" path="dateRet">Date retour</form:label>
			<div class="col-sm-8">
				<form:input type="date" cssClass="form-control"
					placeholder="dateRet" path="dateRet" />
			</div>
		</div>

		<div class="form-group">
			<form:label cssClass="col-sm-2 control-label" path="nbPlacesDispo">nbPlacesDispo</form:label>
			<div class="col-sm-8">
				<form:input cssClass="form-control" placeholder="nbPlacesDispo"
					path="nbPlacesDispo" />
			</div>
		</div>

		<div class="form-group">
			<form:label cssClass="col-sm-2 control-label" path="statut">Statut</form:label>
			<div class="col-sm-8">
				<SELECT cssClass="form-control" placeholder="statut" path="statut">
					<OPTION>Ouvert
					<OPTION>Clot
				</SELECT>
			</div>
		</div>
		
		<div class="form-group">
			<form:label cssClass="col-sm-2 control-label" path="prixPublic">prixPublic</form:label>
			<div class="col-sm-8">
				<form:input cssClass="form-control" placeholder="prixPublic"
					path="prixPublic" />
			</div>
		</div>
		
		<div class="form-group">
			<form:label cssClass="col-sm-2 control-label" path="prixBoV">prixBoV</form:label>
			<div class="col-sm-8">
				<form:input cssClass="form-control" placeholder="prixBoV"
					path="prixBoV" />
			</div>
		</div>

<div class="form-group">
			<form:label cssClass="col-sm-2 control-label" path="photoOff">Image</form:label>
			<div class="col-sm-8">
				<form:input cssClass="form-control" placeholder="photo"
					path="prixBoV" />
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
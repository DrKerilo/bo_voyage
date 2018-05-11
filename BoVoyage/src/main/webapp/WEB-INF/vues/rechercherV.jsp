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
		des Vols</h1>

	<form:form cssClass="form-horizontal" method="POST"
		action="soumettreRecV" modelAttribute="vRec">
		<div class="form-group">
			<form:label cssClass="col-sm-2 control-label"
				path="id">Id du vol recherch�</form:label>
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
	<h1 style="color: red; text-align: center">Liste des vols</h1>


	<br />
	<div align="center">

		<table class="table table-bordered" style="text-align: center">
			<tr style="text-align: center">
				<th>ID</th>
				<th>modele de l'avion</th>
				<th>aeroport de d�part</th>
				<th>aeroport d'arriv�e</th>
				<th>d�part</th>
				<th>arriv�e</th>
				<th>Operations</th>
			</tr>
			
				<tr>
					<td>${vFind.id}</td>
					<td>${vFind.modele}</td>
					<td>${vFind.aeroportDep}</td>
					<td>${vFind.aeroportArr}</td>
					<td>le ${vFind.horaire.dateDep} � ${vFind.horaire.heureDep}</td>
					<td>le ${vFind.horaire.dateRet} � ${vFind.horaire.heureRet}</td>
					<td><a
						href="${pageContext.request.contextPath}/mCTRL/supprLink/${m.id}">Supprimer</a></td>
				</tr>
		</table>
	</div>

	<br />






</body>
</html>
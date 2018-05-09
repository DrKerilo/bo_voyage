<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>

<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Rechercher un client</title>

<!-- Spécifier le chemin du fichier bootstrap.css -->
<link rel="stylesheet"
	href="<c:url value='/resources/css/bootstrap.css' />" />

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

	<form:form cssClass="form-horizontal" action="soumettreRechClient"
		method="post" modelAttribute="clRech">

		<div class="form-group">
			<form:label cssClass="col-sm-2 control-label" path="id">#</form:label>
			<div class="col-sm-2">
				<form:input type="number" cssClass="form-control" path="id" />
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
				<th style="text-align: center;">Client</th>
				<th style="text-align: center;">Date de naissance</th>
				<th style="text-align: center;">Adresse</th>
				<th style="text-align: center;">Mail</th>
				<th style="text-align: center;">Opérations</th>
			</tr>


			<tr>
				<td>${clFind.id}</td>
				<td>${clFind.civilite} ${clFind.nom} ${clFind.prenom}</td>
				<td><fmt:formatDate pattern="dd/MM/yyyy" value="${clFind.dn}" /></td>
				<td>${clFind.adresse.numero} ${clFind.adresse.rue},
					${clFind.adresse.codePostal} ${clFind.adresse.ville}</td>
				<td>${clFind.mail}</td>
				<td><a href="<c:url value='/clientCTRL/supLink/${clFind.id}'/>">Supprimer</a>
					| <a href="<c:url value='/clientCTRL/modifLink?pId=${clFind.id}'/>">Modifier</a></td>
			</tr>

		</table>

	</div>

	<h1 style="color: red; text-align: center;">${msg}</h1>

</body>
</html>
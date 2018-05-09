<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html ">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Page supprimer vol</title>
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

	<nav class="navbar navbar-inverse">
		<ul class="nav nav-pills">
			<li role="presentation"><a
				href="${pageContext.request.contextPath}/agCTRL/listeV">AccueilVol</a></li>
			<li role="presentation"><a
				href="${pageContext.request.contextPath}/agCTRL/afficheAjoutV">Ajouter</a></li>
			<li role="presentation"><a
				href="${pageContext.request.contextPath}/agCTRL/affichModifV">Modifier</a></li>
			<li role="presentation"><a
				href="${pageContext.request.contextPath}/agCTRL/afficheSupprV">Supprimer</a></li>
			<li role="presentation"><a
				href="${pageContext.request.contextPath}/agCTRL/affichRecV">Rechercher
					par id</a></li>
	</nav>

	<h1 style="color: red; text-align: center">Ajouter un vol</h1>

	<form:form cssClass="form-horizontal" method="POST"
		action="soumettreSupprV" modelAttribute="vSuppr">

		<div class="form-group">
			<form:label cssClass="col-sm-2 control-label" path="id">id</form:label>
			<div class="col-sm-8">
				<form:input cssClass="form-control" placeholder="id" path="id" />
			</div>
		</div>



		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-8">
				<button type="submit" class="btn btn-default">Supprimer</button>
			</div>
		</div>


	</form:form>
</body>
</html>
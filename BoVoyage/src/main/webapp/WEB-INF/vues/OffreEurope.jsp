<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Europe</title>

<!-- Bootstrap core CSS -->
<link rel="stylesheet"
	href="<c:url value='/resources/css/bootstrap.css' />" />
<link rel="stylesheet"
	href="<c:url value='/resources/css/carousel.css' />" />
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<!-- Scripts -->
<script type="text/javascript"
	src="<c:url value='/resources/js/jquery-3.3.1.js'/>"></script>
<script type="text/javascript"
	src="<c:url value='/resources/js/bootstrap.js'/>"></script>

<!-- Activation du PopOver -->
<script>
	$(function() {
		$('[data-toggle="popover"]').popover()
	})
</script>
<!-- Custom styles for this template -->
<link href="<c:url value='/resources/js/carousel.css'/>"
	rel="stylesheet">
</head>
<style>
.borderexample {
	margin: 20px;
	padding: 10px;
	border-style: solid;
	border-color: #287EC7;
	padding: 10px;
}
</style>
</head>



<body>

	<!-- NAVBAR -->
	<div class="navbar-wrapper">
		<div class="container">
			<div class="row">
				<div class="col-sm-2">
				<a href="<c:url value='/home'/>">
					<img src="<c:url value='resources/images/logoBV.png'/>"
						style="height: 100px; width =auto; border: 1px solid; border-color: black"></a>
				</div>
				<nav class="navbar navbar-static-top col-sm-10"
					style="background-color: rgba(245, 222, 179, 0.9); border: 2px solid; border-color: #337ab7; margin-top: 22px">
				<div class="container">
					<div class="navbar-header">
						<button type="button" class="navbar-toggle collapsed"
							data-toggle="collapse" data-target="#navbar"
							aria-expanded="false" aria-controls="navbar">
							<span class="sr-only">Afficher navigation</span> <span
								class="icon-bar"></span> <span class="icon-bar"></span> <span
								class="icon-bar"></span>
						</button>
						<a class="navbar-brand" href="<c:url value='/home'/>"><span
							class="glyphicon glyphicon-home"></span></a>
					</div>
					<div id="navbar" class="navbar-collapse collapse">
						<ul class="nav navbar-nav">
							<li class="dropdown"><a href="#" class="dropdown-toggle"
								data-toggle="dropdown" role="button" aria-haspopup="true"
								aria-expanded="false">Découvrir <span class="caret"></span></a>
								<ul class="dropdown-menu">
									<li class="dropdown-header">Par continent</li>
									<li><a href="<c:url value='/carteCTRL/listeAfrica'/>">Afrique</a></li>
									<li><a href="<c:url value='/carteCTRL/listeNorthAfrica'/>">Afrique
											du Nord</a></li>
									<li><a
										href="<c:url value='/carteCTRL/listeNorthAmerica'/>">Amérique
											du Nord</a></li>
									<li><a
										href="<c:url value='/carteCTRL/listeSouthAmerica'/>">Amérique
											du Sud</a></li>
									<li><a href="<c:url value='/carteCTRL/listeAsia'/>">Asie</a></li>
									<li><a href="<c:url value='/carteCTRL/listeEurope'/>">Europe</a></li>
									<li role="separator" class="divider"></li>
									<li class="dropdown-header">Mappemonde</li>
									<li><a href="<c:url value='/carteCTRL/carteMonde'/>">Visionner
											la carte du monde</a></li>
								</ul></li>
							<li><a href="#contact">Contact</a></li>
						</ul>
						<ul class="nav navbar-nav navbar-right">
							<li><a href="<c:url value='/clientCTRL/listeResaClient'/>"><span
									class="glyphicon glyphicon-user"></span> Espace client</a></li>
						</ul>
					</div>
				</div>
				</nav>
			</div>
		</div>
	</div>

<br>
<br>
<br>
<br>
<br>
<br>
<br>

	<div class="container">
		<div class="container">
			<h1 style="color: red; text-align: center">Liste des Offres
				d'Europe</h1>

			<h3 style="color: green; text-align: center">Cliquez pour les
				details</h3>
			<br />
		</div>

		<div class="container">
			<div class="row justify-content-md-center">
				<div class="col-md-4">
					<c:forEach begin="0" end="${fn:length(listeEur)/3}" var="ctr"
						items="${listeEur}" varStatus="loop">
						<div class=" borderexample">
							<a href="${pageContext.request.contextPath}/OffreCTRL/${ctr.id}"
								target="_blank" style="text-decoration: none"> ID :
								${ctr.id} Ref : ${ctr.reference}<br /> Où :
								${ctr.destination.ville}, ${ctr.destination.pays} <br /> Quand:
								partir le : <fmt:formatDate value="${ctr.dateDep}"
									pattern="dd-MM-yy" /> revenir le : <fmt:formatDate
									value="${ctr.dateRet}" pattern="dd-MM-yy" /> <br /> Prix :
								autres : ${ctr.prixPublic}, nous: ${ctr.prixBoV} <br /> Inclus
								: ${ctr.formule} <br /> <br />
							</a>
						</div>
					</c:forEach>
				</div>
				<div class="col-md-4">
					<c:forEach begin="${(fn:length(listeEur)/3) + 1}"
						end="${(fn:length(listeEur)/3)*2}" var="ctr" items="${listeEur}"
						varStatus="loop">
						<div class=" borderexample">
							<a href="${pageContext.request.contextPath}/OffreCTRL/${ctr.id}"
								target="_blank" style="text-decoration: none"> ID :
								${ctr.id} Ref : ${ctr.reference}<br /> Où :
								${ctr.destination.ville}, ${ctr.destination.pays} <br /> Quand:
								partir le : <fmt:formatDate value="${ctr.dateDep}"
									pattern="dd-MM-yy" /> revenir le : <fmt:formatDate
									value="${ctr.dateRet}" pattern="dd-MM-yy" /> <br /> Prix :
								autres : ${ctr.prixPublic}, nous: ${ctr.prixBoV} <br /> Inclus
								: ${ctr.formule} <br /> <br />
							</a>
						</div>
					</c:forEach>
				</div>
				<div class="col-md-4">
					<c:forEach begin="${((fn:length(listeEur)/3)*2)+1}" var="ctr"
						items="${listeEur}" varStatus="loop">
						<div class=" borderexample">
							<a href="${pageContext.request.contextPath}/OffreCTRL/${ctr.id}"
								target="_blank" style="text-decoration: none"> ID :
								${ctr.id} Ref : ${ctr.reference}<br /> Où :
								${ctr.destination.ville}, ${ctr.destination.pays} <br /> Quand:
								partir le : <fmt:formatDate value="${ctr.dateDep}"
									pattern="dd-MM-yy" /> revenir le : <fmt:formatDate
									value="${ctr.dateRet}" pattern="dd-MM-yy" /> <br /> Prix :
								autres : ${ctr.prixPublic}, nous: ${ctr.prixBoV} <br /> Inclus
								: ${ctr.formule} <br /> <br />
							</a>
						</div>
					</c:forEach>
				</div>
			</div>
		</div>
		<br />
	</div>
</body>
</html>
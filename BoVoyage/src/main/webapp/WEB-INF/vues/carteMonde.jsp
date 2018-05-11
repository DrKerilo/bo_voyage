<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Continent / Pays</title>

<!-- ajouter la lib du bootstrap -->

<!-- pour utiliser jquery js-->
<script type="text/javascript"
	src="<c:url value='/resources/js/jquery-3.3.1.js'/>"></script>

<!-- pour utiliser bootstrap js-->
<script type="text/javascript"
	src="<c:url value='/resources/js/bootstrap.js'/>"></script>

<!-- pour utiliser bootstrap -->
<link rel="stylesheet"
	href="<c:url value='/resources/css/bootstrap.css'/>" />
<!-- pour utiliser world -->
<link rel="stylesheet" href="<c:url value='/resources/css/world.css'/>" />


</head>
<body>

<div>
	<h3>Quelle partie du monde voulez-vous visiter aujhourd'hui? - Toutes nos offres, 
			<a href="${pageContext.request.contextPath}/carteCTRL/listeOffres" target="_blank"> ICI</a> </h3>

</div>

	<div class="field-tip">
		<div>
			<img
			src="<c:url value='/resources/images/Continents_of_the_World.jpg'/>"
			alt="" />
		</div>
		
		<a href="${pageContext.request.contextPath}/carteCTRL/listeNorthAmerica" target="_blank">
		<img id="North_America" class="marker" src="<c:url value='/resources/images/marker.png'/>" alt=""
				style="height: 30px; width: 30px;" title="North America" />
		</a>	
		
		<a href="${pageContext.request.contextPath}/carteCTRL/listeSouthAmerica" target="_blank">
		<img id="South_America" src="<c:url value='/resources/images/marker.png'/>" alt=""
				style="height: 30px; width: 30px;"  title="South America"/>
		</a>
		
		<a href="${pageContext.request.contextPath}/carteCTRL/listeEurope" target="_blank">
		<img id="Europe" src="<c:url value='/resources/images/marker.png'/>" alt=""
				style="height: 30px; width: 30px;" title="Europe" />
		</a>	
		
		<a href="${pageContext.request.contextPath}/carteCTRL/listeAfrica" target="_blank">
		<img id="Africa" src="<c:url value='/resources/images/marker.png'/>" alt=""
				style="height: 30px; width: 30px;"  title="Africa"/>
		</a>	
			
		<a href="${pageContext.request.contextPath}/carteCTRL/listeNorthAfrica" target="_blank">
		<img id="AfricaN" src="<c:url value='/resources/images/marker.png'/>" alt=""
				style="height: 30px; width: 30px;" title="North Africa"/>
		</a>
		
		<a href="${pageContext.request.contextPath}/carteCTRL/listeAsia" target="_blank">
		<img id="Asia" src="<c:url value='/resources/images/marker.png'/>" alt=""
				style="height: 30px; width: 30px;" title="Asia"/>
		</a>
		
	</div>


	<script>
		// on click go to page liste offre par pays 
		// comment on peut passer le continent comme argument 
	</script>

</body>
</html>
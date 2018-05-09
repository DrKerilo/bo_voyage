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
<!-- pour utiliser bootstrap -->
<link rel="stylesheet" href="<c:url value='/resources/css/world.css'/>" />


</head>
<body>

	<h3>Quelle partie du monde voulez-vous visiter aujhourd'hui?</h3>

	<div class="field-tip">
		<div>
			<img
			src="<c:url value='/resources/images/Continents_of_the_World.jpg'/>"
			alt="" />
		</div>
				<img id="North_America"src="<c:url value='/resources/images/marker.png'/>" alt=""
				style="height: 30px; width: 30px;" title="North America" />
				
		<img id="South_America"src="<c:url value='/resources/images/marker.png'/>" alt=""
				style="height: 30px; width: 30px;"  title="South America"/>
				
		<img id="Europe"src="<c:url value='/resources/images/marker.png'/>" alt=""
				style="height: 30px; width: 30px;" title="Europe" />
				
		<img id="Africa" src="<c:url value='/resources/images/marker.png'/>" alt=""
				style="height: 30px; width: 30px;"  title="Africa"/>
		<img id="AfricaN" src="<c:url value='/resources/images/marker.png'/>" alt=""
				style="height: 30px; width: 30px;" title="North Africa"/>
				
		<img id="Asia" src="<c:url value='/resources/images/marker.png'/>" alt=""
				style="height: 30px; width: 30px;" title="Asia"/>
		
	</div>



	<script>
		// on click go to page liste offre
		
	</script>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="fr">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>BoVoyage: voyages pas chers</title>

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

<%-- <%response.sendRedirect("resaCTRL/listeResa"); %> --%>

<!-- NAVBAR
================================================== -->
<body>
	<div class="navbar-wrapper">
		<div class="container">
			<div class="row">
				<div class="col-sm-2">
					<img src="<c:url value='resources/images/logoBV.png'/>"
						style="height: 100px; width =auto; border: 1px solid; border-color: black">
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
							<a class="navbar-brand" href="#"><span
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
										<li><a
											href="<c:url value='/carteCTRL/listeNorthAfrica'/>">Afrique
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


	<!-- Carousel
    ================================================== -->
	<div id="myCarousel" class="carousel slide" data-ride="carousel">
		<!-- Indicators -->
		<ol class="carousel-indicators">
			<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
			<li data-target="#myCarousel" data-slide-to="1"></li>
			<li data-target="#myCarousel" data-slide-to="2"></li>
		</ol>
		<div class="carousel-inner" role="listbox">
			<div class="item active">
				<img class="first-slide"
					src="<c:url value='resources/images/carr1.jpg'/>" alt="First slide"
					style="min-height: 500px; object-fit: cover;">
				<div class="container">
					<div class="carousel-caption">
						<h1>Envie de nouvel air ?</h1>
						<p>Avec BoVoyage, profitez de prix réduits sur des offres de
							voyage exceptionnelles dans le monde entier !</p>
						<p>
							<a class="btn btn-lg btn-primary"
								href="<c:url value='/carteCTRL/listeOffres'/>" role="button">Découvrir
								nos offres</a>
						</p>
					</div>
				</div>
			</div>
			<div class="item">
				<img class="second-slide"
					src="<c:url value='resources/images/carr2.jpg'/>"
					alt="Second slide" style="min-height: 500px; object-fit: cover;">
				<div class="container">
					<div class="carousel-caption">
						<h1>Différentes formules pour vous évader</h1>
						<p>Avec nos différentes formules, comprenant avion, hôtel
							et/ou voiture, partez en toute sérénité et dites au revoir au
							stress !</p>
						<p>
							<a class="btn btn-lg btn-primary" href="#" role="button">En
								savoir plus</a>
						</p>
					</div>
				</div>
			</div>
			<div class="item">
				<img class="third-slide"
					src="<c:url value='resources/images/carr3.jpg'/>" alt="Third slide"
					style="min-height: 500px; object-fit: cover;">
				<div class="container">
					<div class="carousel-caption">
						<h1>Besoin d'aide ? Notre service clientèle est disponible
							24h/24, 7j/7 !</h1>
						<p>
							Afin de répondre au mieux à vos besoins, ou si vous rencontrez
							des difficultés lors de votre voyage, n'hésitez pas à nous
							appeler au
							<code>
								<span class="glyphicon glyphicon-earphone"></span> 0.800.600.500
							</code>
							(appel non surtaxé). Le standard est à votre écoute tous les
							jours de la semaine, à toute heure.
						</p>
						<p>
							<a class="btn btn-lg btn-primary" href="#" role="button">Voir
								plus de contacts</a>
						</p>
					</div>
				</div>
			</div>
		</div>
		<a class="left carousel-control" href="#myCarousel" role="button"
			data-slide="prev"> <span class="glyphicon glyphicon-chevron-left"
			aria-hidden="true"></span> <span class="sr-only">Previous</span>
		</a> <a class="right carousel-control" href="#myCarousel" role="button"
			data-slide="next"> <span
			class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
			<span class="sr-only">Next</span>
		</a>
	</div>
	<!-- /.carousel -->


	<!-- Marketing messaging and featurettes
    ================================================== -->
	<!-- Wrap the rest of the page in another container to center all the content. -->

	<div class="container marketing">

		<!-- Three columns of text below the carousel -->
		<div class="row">
			<div class="col-lg-4">
				<img class="img-circle"
					src="<c:url value='resources/images/continentNA.jpg'/>"
					alt="Amérique du Nord" width="140" height="140">
				<h2>Amérique du Nord</h2>
				<p>Balade au pied des gratte-ciels de New York ou bien randonnée
					dans les monts enneigés du Canada, laissez-vous séduire par les
					charmes du Nouveau Monde !</p>
				<p>
					<a class="btn btn-default"
						href="<c:url value='/carteCTRL/listeNorthAmerica'/>" role="button">Découvrir
						les offres &raquo;</a>
				</p>
			</div>
			<!-- /.col-lg-4 -->
			<div class="col-lg-4">
				<img class="img-circle"
					src="<c:url value='resources/images/continentSA.jpg'/>"
					alt="Amérique du Sud" width="140" height="140">
				<h2>Amérique du Sud</h2>
				<p>Partez à la découverte de la forêt amazionenne ou des grands
					plateaux boliviens, ou bien venez danser au rythme endiablé de la
					Samba pendant le carnaval de Rio !</p>
				<p>
					<a class="btn btn-default"
						href="<c:url value='/carteCTRL/listeSouthAmerica'/>" role="button">Découvrir
						les offres &raquo;</a>
				</p>
			</div>
			<!-- /.col-lg-4 -->
			<div class="col-lg-4">
				<img class="img-circle"
					src="<c:url value='resources/images/continentNAf.jpg'/>"
					alt="Afrique du Nord" width="140" height="140">
				<h2>Afrique du Nord</h2>
				<p>Envie de chaleur ? Venez profiter de l'accueil chaleureux qui vous attend au sud de la Méditerranée et découvrez-en les douceurs !</p>
				<p>
					<a class="btn btn-default"
						href="<c:url value='/carteCTRL/listeNorthAfrica'/>" role="button">Découvrir
						les offres &raquo;</a>
				</p>
			</div>
			<!-- /.col-lg-4 -->
		</div>
		<!-- /.row -->

		<div class="row" style="margin-top: 30px">
			<div class="col-lg-4">
				<img class="img-circle"
					src="<c:url value='resources/images/continentAfrique.jpg'/>"
					alt="Afrique" width="140" height="140">
				<h2>Afrique</h2>
				<p>Laissez-vous guider dans la savane pour côtoyer les animaux
					sauvages, ou venez découvrir les paysages magnifiques et méconnus
					des grands espaces africains !</p>
				<p>
					<a class="btn btn-default"
						href="<c:url value='/carteCTRL/listeAfrica'/>" role="button">Découvrir
						les offres &raquo;</a>
				</p>
			</div>
			<!-- /.col-lg-4 -->
			<div class="col-lg-4">
				<img class="img-circle"
					src="<c:url value='resources/images/continentEU.jpg'/>"
					alt="Europe" width="140" height="140">
				<h2>Europe</h2>
				<p>Évadez-vous à Venise pour un week-end romantique, à Paris
					pour faire du shopping, ou partez en direction du nord pour prendre
					un grand bol d'air frais dans les fjords scandinaves !</p>
				<p>
					<a class="btn btn-default"
						href="<c:url value='/carteCTRL/listeEurope'/>" role="button">Découvrir
						les offres &raquo;</a>
				</p>
			</div>
			<!-- /.col-lg-4 -->
			<div class="col-lg-4">
				<img class="img-circle"
					src="<c:url value='resources/images/continentAsie.jpg'/>"
					alt="Asie" width="140" height="140">
				<h2>Asie</h2>
				<p>Laissez-vous charmer par le plus grand continent, des déserts
					d'Arabie aux steppes de la Sibérie, du Proche-Orient aux cerisiers
					du Japon !</p>
				<p>
					<a class="btn btn-default"
						href="<c:url value='/carteCTRL/listeAsia'/>" role="button">Découvrir
						les offres &raquo;</a>
				</p>
			</div>
			<!-- /.col-lg-4 -->
		</div>
		<!-- /.row -->

		<!-- FOOTER -->

		<footer style="margin-top: 30px">
			<a role="button" class="btn btn-default"
				href="<c:url value='/clientCTRL/listeResa'/>"> <span
				class="glyphicon glyphicon-briefcase"></span> Espace Conseiller
			</a>
			<p class="pull-right">
				<a href="#">Haut de page <span
					class="glyphicon glyphicon-arrow-up"></span></a>
			</p>
			<p style="margin-top: 20px">
				&copy; 2018 Groupe ADAMING &middot; <a tabindex="0"
					data-toggle="popover" data-container="body" data-trigger="focus"
					data-placement="top" title="Attention !"
					data-content="Promis on ne vendra pas vos données ! #Zuckerberg">Politique
					de confidentialité</a> &middot; <a tabindex="0" data-container="body"
					data-toggle="popover" data-trigger="focus" data-placement="top"
					title="C'est du fake !"
					data-content="Ne nous donnez pas votre argent !">Conditions
					générales de vente</a>
			</p>
		</footer>


	</div>
	<!-- /.container -->
</body>
</html>

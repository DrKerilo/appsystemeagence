// Configuration de la table de routage
app.config(function($routeProvider) {
	
	// Variables globales
	urlClasseStandard = "/gestion/classeStandard";
	urlBienImmobilier = "/gestion/bienImmobilier";
	urlClient = "/gestion/client";
	urlVisite = "/gestion/visite";
	
	// ----- ClasseStandard
	$routeProvider
		.when(urlClasseStandard+"/list",{
			controller:"listeCSCtrl",
			templateUrl:"vues/classeStandard/listeCS.html"
		})
		.when(urlClasseStandard+"/add", {
			controller:"ajoutCSCtrl",
			templateUrl:"vues/classeStandard/ajoutCS.html"
		})
		.when(urlClasseStandard+"/update", {
			controller:"modifCSCtrl",
			templateUrl:"vues/classeStandard/modifCS.html"
		})
		.when(urlClasseStandard+"/delete", {
			controller:"supprCSCtrl",
			templateUrl:"vues/classeStandard/supprCS.html"
		})
		.when(urlClasseStandard+"/search", {
			controller:"rechCSCtrl",
			templateUrl:"vues/classeStandard/rechCS.html"
		});
	
	// ----- BienImmobilier
	
	// ----- Client
	
	// ----- Visite
})
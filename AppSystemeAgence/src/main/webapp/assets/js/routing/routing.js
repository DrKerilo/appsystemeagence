// Configuration de la table de routage
app.config(function($routeProvider) {
	
	// ----- ClasseStandard
	$routeProvider
		.when("/listCS",{
			controller:"listeCSCtrl",
			templateUrl:"vues/classeStandard/listeCS.html"
		})
		.when("/addCS", {
			controller:"ajoutCSCtrl",
			templateUrl:"vues/classeStandard/ajoutCS.html"
		})
		.when("/updateCS", {
			controller:"modifCSCtrl",
			templateUrl:"vues/classeStandard/modifCS.html"
		})
		.when("/deleteCS", {
			controller:"supprCSCtrl",
			templateUrl:"vues/classeStandard/supprCS.html"
		})
		.when("/searchCS", {
			controller:"rechCSCtrl",
			templateUrl:"vues/classeStandard/rechCS.html"
		});
	
	// ----- BienImmobilier
	
	// ----- Client
	
	// ----- Visite
})
// Controllers de Visite
app

.controller("listeVICtrl", function($rootScope,$scope,$location,visiteService) {
	
	// Fonction appelée par le bouton dans la vue
	visiteService.getVisitesByAgent(function(callback) {
		$scope.listeVisites=callback;
	})
})

.controller("ajoutVICtrl", function($scope, $location, visiteService) {

	// Variables
	$scope.vi = { // Déclaration d'une visite
		date : "",
		id : "",
		agent : "",
		client : ""
	};

	// Fonction appelée via le bouton Ajouter
	$scope.ajouterVI = function() {
		visiteService.addVisite($scope.vi, function(callback) {
			if (callback == "OK") {
				$location.path("listVI");
			} else {
				$scope.message = "Erreur: la visite n'a pas pu tere ajoutee."
			}
		})
	};
})
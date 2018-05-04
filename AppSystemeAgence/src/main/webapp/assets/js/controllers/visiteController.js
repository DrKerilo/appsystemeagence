// Controllers de Visite
app

.controller("listeVICtrl", function($rootScope, $scope, $location, visiteService) {
	
		visiteService.getAll(function(callback) {
			$scope.listeVisites=callback;
		})
		
		// Fonction appelée via le lien Supprimer
		$scope.supprimerLien = function(idVisite) {
			visiteService.deleteOne(idVisite, function(callback) {
				if (callback == "OK") {
					visiteService.getAll(function(callback) {
					$scope.listeVisites = callback;
					});
				} else {
					$scope.message="Erreur: la visite n'a pas pu être supprimée."
				}
			});
		};
		
		// Déclaration de visiteModif avec un id undefined
		$rootScope.viModif = {
			id : undefined
		};

		// Fonction appelée via le lien Modifier
		$scope.modifierLien = function(vi) {
			$rootScope.viModif = vi;
			$location.path("updateVI");
		};
})

.controller("ajoutVICtrl", function($scope, $location, visiteService, biService, clService, agentService) {

		// Variables
		$scope.vi = { // Déclaration d'une visite
			date : "",
			heure : "",
			agent : undefined,
			client :  undefined,
			bienImmo :  undefined
		};
		
		biService.getAllBi(function(dataServer){
			$scope.listeBI=dataServer;	
			});
		
		clService.getAll(function(dataServer){
			$scope.listeClients=dataServer;	
			});
		
		agentService.getAll(function(dataServer){
			$scope.listeAgents=dataServer;	
			});
	
		// Fonction appelée via le bouton Ajouter
		$scope.ajouterVI = function() {
			
			console.log($scope.vi)
			visiteService.addVisite($scope.vi, function(callback) {
				if (callback == "OK") {
					$location.path("listVI");
				} else {
					$scope.message = "Erreur: la visite n'a pas pu etre ajoutee."
				}
			})
		};
})

.controller("modifVICtrl", function($rootScope, $scope, $location, visiteService, biService, clService, agentService) {

	// Variables
	biService.getAllBi(function(dataServer){
		$scope.listeBI=dataServer;	
		});
	
	clService.getAll(function(dataServer){
		$scope.listeClients=dataServer;	
		});
	
	agentService.getAll(function(dataServer){
		$scope.listeAgents=dataServer;	
		});
	
	$scope.indice = false;

	if ($rootScope.viModif.id == undefined) {
		$scope.vi = { // Déclaration d'une visite
				id : "",
				date : "",
				heure : "",
				agent : undefined,
				client :  undefined,
				bienImmo :  undefined
			};
	} else {
		$scope.vi = $rootScope.viModif;
	}
	

	// Fonction appelée via le bouton Modifier
	$scope.modifierVI = function() {
		visiteService.updateOne($scope.vi, function(callback) {
			$location.path("listVI");
			if (callback == "OK") {
				$location.path("listVI");
				$scope.indice = false;
			} else {
				$scope.indice = true;
				$scope.message = "Erreur: cette visite n'existe pas.";
			}
		});
	}
})

.controller("rechVICtrl", function($scope, $rootScope, $location, visiteService) {
	
	visiteService.getAll(function(callback) {
		$scope.listeVisites=callback;
	})
	
	// Fonction appelée via le lien Supprimer
	$scope.supprimerLien = function(idVisite) {
		visiteService.deleteOne(idVisite, function(callback) {
			if (callback == "OK") {
				visiteService.getAll(function(callback) {
				$scope.listeVisites = callback;
				});
			} else {
				$scope.message="Erreur: la visite n'a pas pu être supprimée."
			}
		});
	};
	
	// Déclaration de visiteModif avec un id undefined
	$rootScope.viModif = {
		id : undefined
	};

	// Fonction appelée via le lien Modifier
	$scope.modifierLien = function(vi) {
		$rootScope.viModif = vi;
		$location.path("updateVI");
	};

});
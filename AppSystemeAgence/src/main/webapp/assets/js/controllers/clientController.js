// Controllers pour Client
app.controller("listeCLCtrl",
		function($rootScope, $scope, $location, clService) {

			// Fonction appelée dès l'affichage de la vue
			clService.getAll(function(callback) {
				$scope.listeClients = callback;
			});

			// Déclaration de pModif avec un id undefined
			$rootScope.clModif = {
				id : undefined
			};

			// Fonction appelée via le lien Modifier
			$scope.modifierLien = function(cl) {
				$rootScope.clModif = cl;
				$location.path("updateCL");
			};

			// Fonction appelée via le lien Supprimer
			$scope.supprimerLien = function(idCl) {
				clService.deleteOne(idCl, function(callback) {
					if (callback == "OK") {
						clService.getAll(function(callback) {
							$scope.listeClients = callback;
						});
					} else {
						$scope.message="Erreur: le client n'a pas pu être supprimé."
					}
				});
			};

		})

.controller("ajoutCLCtrl", function($scope, $location, clService) {

	// Variables
	$scope.cl = { // Déclaration d'un client vide
		nom: "",
		prenom: "",
		telPerso: "",
		adresse:    {
			rue: "",
			numero: "",
			codePostal: "",
			localite: ""
		}
	};

	// Fonction appelée via le bouton Ajouter
	$scope.ajouterCL = function() {
		clService.addOne($scope.cl, function(callback) {
			if (callback == "OK") {
				$location.path("listCL");
			} else {
				$scope.message = "Erreur: l'ajout du client n'a pas abouti."
			}
		})
	};
})

.controller("modifCLCtrl", function($rootScope, $scope, $location, clService) {

	// Variables
	$scope.indice = false;

	if ($rootScope.clModif.id == undefined) {
		$scope.cl = { // Déclaration d'un client vide avec id
			id: "",
			nom: "",
			prenom: "",
			telPerso: "",
			adresse:    {
				rue: "",
				numero: "",
				codePostal: "",
				localite: ""
			}
		};
	} else {
		$scope.cl = $rootScope.clModif;
	}

	// Fonction appelée via le bouton Modifier
	$scope.modifierCL = function() {
		clService.updateOne($scope.cl, function(callback) {
			if (callback == "OK") {
				$location.path("listCL");
				$scope.indice = false;
			} else {
				$scope.indice = true;
				$scope.message = "Erreur: ce client n'existe pas.";
			}
		});
	}
})

.controller("supprCLCtrl", function($scope,$location,clService) {
	
	// Variables
	$scope.id;
	$scope.indice=false;
	
	// Fonction appelée via le bouton Supprimer
	$scope.supprimerCL=function(){
		clService.deleteOne($scope.id,function(callback){
			if (callback == "OK") {
				$location.path("listCL");
				$scope.indice = false;
			} else {
				$scope.indice = true;
				$scope.message = "Erreur: ce client n'existe pas.";
			}
		});
	}
})

.controller("rechCLCtrl", function($scope,clService) {
	
	// Variables
	$scope.id;
	$scope.indiceOK=false;
	$scope.indiceNOT=false;
	
	// Fonction appelée via le bouton Chercher
	$scope.rechercherCL=function(){
		clService.getOne($scope.id,function(callback){
			if(typeof callback == "object"){
				$scope.clOut=callback;
				$scope.indiceOK=true;
				$scope.indiceNOT=false;
			} else {
				$scope.indiceOK=false;
				$scope.indiceNOT=true;
				$scope.message="Erreur: ce client n'existe pas.";
			}
		})
	}

});
// Controllers pour Proprietaire
app.controller("listePRCtrl",
		function($rootScope, $scope, $location, propService) {

			// Fonction appelée dès l'affichage de la vue
			propService.getAll(function(callback) {
				$scope.listeProprietaires = callback;
			});

			// Déclaration de pModif avec un id undefined
			$rootScope.pModif = {
				id : undefined
			};

			// Fonction appelée via le lien Modifier
			$scope.modifierLien = function(proprio) {
				$rootScope.pModif = proprio;
				$location.path("updatePR");
			};

			// Fonction appelée via le lien Supprimer
			$scope.supprimerLien = function(idProp) {
				propService.deleteOne(idProp, function(callback) {
					if (callback == "OK") {
						propService.getAll(function(callback) {
							$scope.listeProprietaires = callback;
						});
					} else {
						$scope.message="Erreur: le propriétaire n'a pas pu être supprimé."
					}
				});
			};
			
			// Fonction appelée via le lien afficher
			$scope.getListeByProprio = function(idProp){
				$rootScope.codeProp = idProp;
				$location.path("listBIProp");
			};

		})

.controller("ajoutPRCtrl", function($scope, $location, propService, biService) {

	// Variables
	$scope.p = { // Déclaration d'un propriétaire vide
		nom: "",
		prenom: "",
		telPerso: "",
		adresse:    {
			rue: "",
			numero: "",
			codePostal: "",
			localite: ""
		},
		telPro: ""
	};
	
	// Récupération de la liste des biens immobiliers
	biService.getAllBi(function(callback) {
		$scope.listeBI=callback;
	})

	// Fonction appelée via le bouton Ajouter
	$scope.ajouterPR = function() {
		propService.addOne($scope.p, function(callback) {
			if (callback == "OK") {
				$location.path("listPR");
			} else {
				$scope.message = "Erreur: l'ajout du propriétaire n'a pas abouti."
			}
		})
	};
})

.controller("modifPRCtrl", function($rootScope, $scope, $location, propService) {

	// Variables
	$scope.indice = false;

	if ($rootScope.pModif.id == undefined) {
		$scope.p = { // Déclaration d'un proprietaire vide avec id
			id: "",
			nom: "",
			prenom: "",
			telPerso: "",
			adresse:    {
				rue: "",
				numero: "",
				codePostal: "",
				localite: ""
			},
			telPro: ""
		};
	} else {
		$scope.p = $rootScope.pModif;
	}

	// Fonction appelée via le bouton Modifier
	$scope.modifierPR = function() {
		propService.updateOne($scope.p, function(callback) {
			if (typeof callback == "object") {
				$location.path("listPR");
				$scope.indice = false;
			} else {
				$scope.indice = true;
				$scope.message = "Erreur: ce propriétaire n'existe pas.";
			}
		});
	}
})

.controller("supprPRCtrl", function($scope,$location,propService) {
	
	// Variables
	$scope.id;
	$scope.indice=false;
	
	// Fonction appelée via le bouton Supprimer
	$scope.supprimerPR=function(){
		propService.deleteOne($scope.id,function(callback){
			if (callback == "OK") {
				$location.path("listPR");
				$scope.indice = false;
			} else {
				$scope.indice = true;
				$scope.message = "Erreur: ce propriétaire n'existe pas.";
			}
		});
	}
})

.controller("rechPRCtrl", function($scope,propService) {
	
	// Variables
	$scope.id;
	$scope.indiceOK=false;
	$scope.indiceNOT=false;
	
	// Fonction appelée via le bouton Chercher
	$scope.rechercherPR=function(){
		propService.getOne($scope.id,function(callback){
			if(typeof callback == "object"){
				$scope.pOut=callback;
				$scope.indiceOK=true;
				$scope.indiceNOT=false;
			} else {
				$scope.indiceOK=false;
				$scope.indiceNOT=true;
				$scope.message="Erreur: ce propriétaire n'existe pas.";
			}
		})
	}

});
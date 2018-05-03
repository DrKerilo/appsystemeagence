// Controllers pour ClasseStandard
app.controller("listeCSCtrl",
		function($rootScope, $scope, $location, csService) {

			// Fonction appelée dès l'affichage de la vue
			csService.getAll(function(callback) {
				$scope.listeClassesStandards = callback;
			});

			// Déclaration de csModif avec un id undefined
			$rootScope.csModif = {
				code : undefined
			};

			// Fonction appelée via le lien Modifier
			$scope.modifierLien = function(classeStand) {
				$rootScope.csModif = classeStand;
				$location.path("updateCS");
			};

			// Fonction appelée via le lien Supprimer
			$scope.supprimerLien = function(idClasse) {
				csService.deleteOne(idClasse, function(callback) {
					if (callback == "OK") {
						csService.getAll(function(callback) {
							$scope.listeClassesStandards = callback;
						});
					} else {
						$scope.message="Erreur: la classe n'a pas pu être supprimée."
					}
				});
			};
			
			// Fonction appelée via le lien afficher
			$scope.getListeByClasse = function(code){
				$rootScope.code = code;
				$location.path("listBICat");
			};

		})

.controller("ajoutCSCtrl", function($scope, $location, csService) {

	// Variables
	$scope.cs = { // Déclaration d'une classe standard
		modeOffre : "",
		prixMax : "",
		superficieMin : "",
		type : ""
	};

	// Fonction appelée via le bouton Ajouter
	$scope.ajouterCS = function() {
		csService.addOne($scope.cs, function(callback) {
			if (callback == "OK") {
				$location.path("listCS");
			} else {
				$scope.message = "Erreur: l'ajout de la classe n'a pas abouti."
			}
		})
	};
})

.controller("modifCSCtrl", function($rootScope, $scope, $location, csService) {

	// Variables
	$scope.indice = false;

	if ($rootScope.csModif.code == undefined) {
		$scope.cs = { // Déclaration d'une classe standard
			code : "",
			modeOffre : "",
			prixMax : "",
			superficieMin : "",
			type : ""
		};
	} else {
		$scope.cs = $rootScope.csModif;
	}

	// Fonction appelée via le bouton Modifier
	$scope.modifierCS = function() {
		csService.updateOne($scope.cs, function(callback) {
			if (callback == "OK") {
				$location.path("listCS");
				$scope.indice = false;
			} else {
				$scope.indice = true;
				$scope.message = "Erreur: cette classe standard n'existe pas.";
			}
		});
	}
})

.controller("supprCSCtrl", function($scope,$location,csService) {
	
	// Variables
	$scope.id;
	$scope.indice=false;
	
	// Fonction appelée via le bouton Supprimer
	$scope.supprimerCS=function(){
		csService.deleteOne($scope.id,function(callback){
			if (callback == "OK") {
				$location.path("listCS");
				$scope.indice = false;
			} else {
				$scope.indice = true;
				$scope.message = "Erreur: cette classe standard n'existe pas.";
			}
		});
	}
})

.controller("rechCSCtrl", function($scope,csService) {
	
	// Variables
	$scope.id;
	$scope.indiceOK=false;
	$scope.indiceNOT=false;
	
	// Fonction appelée via le bouton Chercher
	$scope.rechercherCS=function(){
		csService.getOne($scope.id,function(callback){
			if(typeof callback == "object"){
				$scope.csOut=callback;
				$scope.indiceOK=true;
				$scope.indiceNOT=false;
			} else {
				$scope.indiceOK=false;
				$scope.indiceNOT=true;
				$scope.message="Erreur: cette classe standard n'existe pas.";
			}
		})
	}

});
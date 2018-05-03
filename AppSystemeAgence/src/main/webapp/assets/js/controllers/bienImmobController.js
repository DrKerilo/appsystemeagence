// Controllers pour ClasseStandard
app

.controller("listeBICtrl", function($rootScope, $scope, $location, biService) {

	// Fonction appelée dès l'affichage de la vue
	biService.getAllBi(function(callback) {
		$scope.listeBiensImmobilier = callback;
	})

	$scope.deleteLinkBi = function(id) {
		console.log(id);
		biService.supprimBi(id, function(callBack) {
			if (callBack == 'OK') {
				biService.getAll(function(callBack) {
					$scope.listeBiensImmobilier = callBack;
				});
			}
		});
	}

	$rootScope.biModif = {
		id : undefined
	};

	$scope.modifLinkBi = function(bien) {
		console.log(bien);
		$rootScope.biModif = bien;
		$location.path('updateBI');

	}

})

.controller("listeBICatCtrl",
		function($rootScope, $scope, $location, biService) {
			if ($rootScope.code == undefined) {
				$scope.code = "";
			} else {
				$scope.code = $rootScope.code

				// Fonction appelée dès l'affichage de la vue
				biService.getBiByCat($scope.code, function(callback) {
					$scope.listeBiensParCat = callback;
				})

			}

			// Fonction appelée via le bouton Rechercher
			$scope.getByCat = function() {
				biService.getBiByCat($scope.code, function(callback) {
					$scope.listeBiensParCat = callback;
				})
			};

			$scope.deleteLinkBi = function(id) {
				console.log(id);
				biService.supprimBi(id, function(callBack) {
					if (callBack == 'OK') {
						biService.getBiByCat($scope.code, function(callBack) {
							$scope.listeBiensParCat = callBack;
						});
					}
				});
			}

			$rootScope.biModif = {
				id : undefined
			};

			$scope.modifLinkBi = function(bien) {
				console.log(bien);
				$rootScope.biModif = bien;
				$location.path('updateBI');

			}

		})
		
.controller("listeBIPropCtrl",
		function($rootScope, $scope, $location, biService) {
	
			// Vérification si arrivé à partir de la liste des proprios
			if ($rootScope.codeProp == undefined) {
				$scope.code = "";
			} else {
				$scope.code = $rootScope.codeProp
				
				// Fonction appelée dès l'affichage de la vue
				biService.getBiByProp($scope.code, function(callback) {
					$scope.listeBiensParProp = callback;
				})
				
			}
			
			// Fonction appelée via le bouton Rechercher
			$scope.getByProp = function() {
				biService.getBiByProp($scope.code, function(callback) {
					$scope.listeBiensParProp = callback;
				})
			};
			
			$scope.deleteLinkBi = function(id) {
				console.log(id);
				biService.supprimBi(id, function(callBack) {
					if (callBack == 'OK') {
						biService.getBiByProp($scope.code, function(callBack) {
							$scope.listeBiensParProp = callBack;
						});
					}
				});
			}
			
			$rootScope.biModif = {
					id : undefined
			};
			
			$scope.modifLinkBi = function(bien) {
				console.log(bien);
				$rootScope.biModif = bien;
				$location.path('updateBI');
				
			}
			
		})

.controller("rechBICtrl", function($scope, biService) {
	$scope.id = undefined;
	$scope.indice = false;
	$scope.indice2 = false;

	$scope.rechercherBiParId = function() {
		biService.getBi($scope.id, function(callBack) {
			if (typeof callBack == "object") {
				$scope.biOut = callBack;
				$scope.indice = true;
				$scope.indice2 = false;
			} else {
				$scope.indice = false;
				$scope.indice2 = true;
				$scope.msg = "Le bien n'existe pas"
			}
		});
	}
})

.controller("supprBICtrl", function($scope, $location, biService) {
	$scope.msg = "";
	$scope.idDel = undefined;
	$scope.indice = true;

	$scope.supprimerBi = function() {
		biService.supprimBi($scope.idDel, function(callBack) {
			if (callBack == "OK") {
				$location.path('listBI');
			} else {
				$scope.indice = true;
				$scope.msg = "Impossible de supprimer le bien " + idDel;
			}
		});
	}
})

.controller("ajoutBICtrl", function($scope, $location, biService) {
	$scope.statutBI = [ {
		valeur : "DISPONIBLE",
		nom : "Disponible"
	}, {
		valeur : "LOUE",
		nom : "Loué"
	}, {
		valeur : "ACHETE",
		nom : "Acheté"
	} ];

	$scope.garnitureBI = [ {
		valeur : "MEUBLE",
		nom : "Meublé"
	}, {
		valeur : "NON_MEUBLE",
		nom : "Non meublé"
	} ];
	
	$scope.bailBI = ["Habitation", "Mixte", "Commercial", "Professionnel"];

	$scope.etat = [{
		valeur : "A_restaurer",
		nom : "A restaurer"
	}, {
		valeur : "Correct",
		nom : "Correct"
	}, {
		valeur : "Impeccable",
		nom : "Impeccable"
	}];
//	
//	$scope.classe = csService.getAll(function(callback) {
//		$scope.listeClassesStandards = callback;
//	});

	$scope.bien = {
		statut : "",
		dateSoumission : "",
		adresse : {
			rue : "",
			numero : "",
			codePostal : "",
			localite : ""
		},
		dateDisposition : "",
		revenuCadastral : "",
		photo : "",
		cautionLocative : "",
		loyerMensuel : "",
		montantMensuelCharges : "",
		typeBail : "",
		garniture : "",
		prixAchat : "",
		etat : "",
		classeStandard : {
			code : "",
			type : "",
			modeOffre : "",
			prixMax : "",
			superficieMin : ""
		}
	}

	$scope.indice = false;

	$scope.ajouterBi = function() {
		console.log($scope.bien.statut);
		biService.ajoutBi($scope.bien, function(callBack) {
			if (callBack == "OK") {
				$location.path('listBI');

			} else {
				$scope.indice = true;
				$scope.msg = "Impossible d'ajouter";
			}
		})
	}
})

.controller("modifBICtrl", function($scope, $location, biService, $rootScope) {
	if ($rootScope.biModif.id == undefined) {
		$scope.bien = {
			id : "",
			statut : "",
			dateSoumission : "",
			adresse : {
				rue : "",
				numero : "",
				codePostal : "",
				localite : ""
			},
			dateDisposition : "",
			revenuCadastral : "",
			photo : "",
			cautionLocative : "",
			loyerMensuel : "",
			montantMensuelCharges : "",
			typeBail : "",
			garniture : "",
			prixAchat : "",
			etat : "",
			classeStandard : {
				code : "",
				type : "",
				modeOffre : "",
				prixMax : "",
				superficieMin : ""
			}
		};
	} else {
		$scope.bien = $rootScope.biModif;
	}
	$scope.indice = false;

	$scope.modifierBi = function() {
		biService.modifBi($scope.bien, function(callBack) {
			if (callBack == "OK") {
				$location.path('listBI');

			} else {
				$scope.indice = true;
				$scope.msg = "Impossible de modifier";
			}
		});
	}
})

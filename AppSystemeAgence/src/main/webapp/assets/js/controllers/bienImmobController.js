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

	$scope.rechLinkBi = function(id) {
		console.log(id);
		biService.getBi(id, function(callBack) {
			$rootScope.bi = callBack;
			$location.path('searchBI');

		});
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

.controller("rechBICtrl", function($rootScope, $scope, biService) {
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

.controller(
		"ajoutBICtrl",
		function($scope, $location, biService, csService, propService) {
			// Valeur/Clé affichée pour liste déroulante des statuts
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

			// Pour liste déroulante Type de Bail
			$scope.bailBI = [ "Habitation", "Mixte", "Commercial",
					"Professionnel" ];

			// Liste déroulante état du terrain à vendre
			$scope.etatBI = [ {
				valeur : "A_restaurer",
				nom : "A restaurer"
			}, {
				valeur : "Correct",
				nom : "Correct"
			}, {
				valeur : "Impeccable",
				nom : "Impeccable"
			} ];

			// Liste déroulante classes standard des biens
			csService.getAll(function(callback) {
				$scope.classe = callback;
			});

			// Liste déroulante propriétaires des biens
			propService.getAll(function(callback) {
				$scope.props = callback;
			});

			// Objet utilisé pour l'évenement
			$scope.CsOut = {
				code : "",
				type : "",
				modeOffre : "",
				prixMax : "",
				superficieMin : ""
			}

			// Prendre en compte l'état actuel de la liste déroulante classe
			// standard
			$scope.change = function() {
				$scope.bien.classeStandard.code = $scope.CsOut.code;
				console.log($scope.bien.classeStandard);
			}

			// Bien vide
			$scope.bien = {
				statut : "",
				dateSoumission : null,
				adresse : {
					rue : "",
					numero : 0,
					codePostal : "",
					localite : ""
				},
				dateDisposition : null,
				revenuCadastral : "",
				photo : "",
				cautionLocative : 0,
				loyerMensuel : 0,
				montantMensuelCharges : 0,
				typeBail : "",
				garniture : "",
				prixAchat : 0,
				etat : "",
				classeStandard : {
					code : "",
					type : "",
					modeOffre : "",
					prixMax : "",
					superficieMin : ""
				},
				proprietaire : {
					id : ""//,
//					nom : "",
//					prenom : "",
//					telPerso : "",
//					adresse : {
//						rue : "",
//						numero : 0,
//						codePostal : 0,
//						localite : ""
//					},
//					telPro : ""
				}
			}

			$scope.indice = false;

			$scope.ajouterBi = function() {
				console.log($scope.bien);
				// $scope.bien.classeStandard=null;
				// $scope.bien.proprietaire=null;

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

		
.controller(
		"modifBICtrl",
		function($scope, $location, biService, $rootScope, csService,
				propService) {
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
					photo : null,
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
					},
					proprietaire : {
						id : ""
					}
				};
			} else {
				$scope.bien = $rootScope.biModif;
			}

			// Valeur/Clé affichée pour liste déroulante des statuts
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

			// Pour liste déroulante Type de Bail
			$scope.bailBI = [ "Habitation", "Mixte", "Commercial",
					"Professionnel" ];

			// Liste déroulante état du terrain à vendre
			$scope.etatBI = [ {
				valeur : "A_restaurer",
				nom : "A restaurer"
			}, {
				valeur : "Correct",
				nom : "Correct"
			}, {
				valeur : "Impeccable",
				nom : "Impeccable"
			} ];

			// Liste déroulante classes standard des biens
			csService.getAll(function(callback) {
				$scope.classe = callback;
			});

			// Liste déroulante propriétaires des biens
			propService.getAll(function(callback) {
				$scope.props = callback;
			});

			// Objet utilisé pour l'évenement
			$scope.CsOut = {
				code : "",
				type : "",
				modeOffre : "",
				prixMax : "",
				superficieMin : ""
			}

			// Prendre en compte l'état actuel de la liste déroulante classe
			// standard
			$scope.change = function() {
				$scope.bien.classeStandard.code = $scope.CsOut.code;
				console.log($scope.bien.classeStandard);
			}

			$scope.indice = false;

			$scope.modifierBi = function() {
				biService.modifBi($scope.bien, function(callBack) {
					if (callBack == "OK") {
						$location.path('listBI');
						$scope.indice = false;

					} else {
						$scope.indice = true;
						$scope.msg = "Impossible de modifier";
					}
				});
			}
		})

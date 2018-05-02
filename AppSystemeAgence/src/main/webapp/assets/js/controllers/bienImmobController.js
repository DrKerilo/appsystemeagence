// Controllers pour ClasseStandard
app.controller("listeBICtrl", function($rootScope,$scope,$location,biService) {
	
	// Fonction appelée dès l'affichage de la vue
	biService.getAllBi(function(callback) {
		$scope.listeBiensImmobilier=callback;
	})
})
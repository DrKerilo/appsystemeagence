// Controllers pour ClasseStandard
app.controller("listeCSCtrl", function($rootScope,$scope,$location,csService) {
	
	// Fonction appelée dès l'affichage de la vue
	csService.getAll(function(callback) {
		$scope.listeClassesStandards=callback;
	})
})
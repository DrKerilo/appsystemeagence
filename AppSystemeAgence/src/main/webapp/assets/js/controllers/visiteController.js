// Controllers de Visite
app.controller("listeVICtrl", function($rootScope,$scope,$location,visiteService) {
	
	// Fonction appelée par le bouton dans la vue
	visiteService.getVisitesByAgent(function(callback) {
		$scope.listeVisites=callback;
	})
})
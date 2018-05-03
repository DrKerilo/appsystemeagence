// Controllers de Agent
app.controller("listeAGCtrl",
		function($rootScope, $scope, $location, agentService) {

			// Fonction appelée dès l'affichage de la vue
			agentService.getAll(function(callback) {
				$scope.listeAgents = callback;
			});
			
})

			
// Création du controller de Client

app

.controller("listeCtrl", function($scope,eService,$rootScope,$location) {
	eService.getAll(function(callBack) {
	$scope.listeClients=callBack;
		
	});
	
})
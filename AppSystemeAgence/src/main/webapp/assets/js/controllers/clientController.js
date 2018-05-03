// Création du controller de Client

app

.controller("listeCLCtrl", function($scope,clService,$rootScope,$location) {
	clService.getAll(function(callBack) {
	$scope.listeClients=callBack;
		
	})
	
	.controller("ajoutCLCtrl", function($scope,clService,$location) {
		
		//Variables
		$scope.client = {
			nom :"",
			prenom : "",
			tel : "",
			Adresse : ""
		};
		
		// fonction appelée par le bouton ajouter
		$scope.ajoutClient = function(){
			clService.addOne($scope.client,function(callBack){
				if (callBack =='OK'){
					$location.path('listCL')// url du lien menant à la vue affichant la liste (cf : vue index)
				}else{
					$scope.message="fail";
				}
			})
		}
		
	})	
	
});
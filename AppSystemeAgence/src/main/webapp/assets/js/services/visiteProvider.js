// ===== Visite =====
// Services pour gérer les données de Visite
app.factory("visiteService", function($http,$window) {
	
	// Variable globale du service
	var restUrl="http://localhost:8080/AppSystemeAgence/";
	
	// Déclaration externe des fonctions
	// ----- Afficher liste visites d'un agent
	function findAllByAgent(busSC){
		$http({
			method:"GET",
			url:restUrl+"/listeVisites"
		}).then(function successCallback(response) {
			busSC(response.data);
		}, function errorCallback(reason) {
			console.log("Erreur "+reason.status+": "+reason.statusText);
		})
	};
	
	return {
		getVisitesByAgent:findAllByAgent
	}
	
})
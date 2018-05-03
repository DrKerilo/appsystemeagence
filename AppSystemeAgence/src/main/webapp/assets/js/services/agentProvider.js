// ===== Agent =====
// Services pour gérer les donnees d'Agent

app.factory("agentService", function($http,$window) {
	
	// Variable globale du service
	var restUrl = "http://localhost:8080/AppSystemeAgence/";
	
	// Déclaration externe des fonctions
	// ----- Afficher liste
	function findAll(busSC) {
		$http({
			method : "GET",
			url : restUrl + "/listeAgents"
		}).then(function successCallback(response) {
			busSC(response.data);
		}, function errorCallback(reason) {
			console.log("Erreur " + reason.status + ": " + reason.statusText);
		})
	}
	;
	

	return {
		getAll : findAll
	}
})
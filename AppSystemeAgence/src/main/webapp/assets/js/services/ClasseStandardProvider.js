// ===== ClasseStandard =====
// Services pour gérer les données de ClasseStandard
app.factory("csService", function($http,$window) {
	
	// Variable globale du service
	var restUrl="http://localhost:8080/AppSystemeAgence/";
	
	// Déclaration externe des fonctions
	// ----- Afficher liste
	function findAll(busSC){
		$http({
			method:"GET",
			url:restUrl+"/listeCS"
		}).then(function successCallback(response) {
			busSC(response.data);
		}, function errorCallback(reason) {
			console.log("Erreur "+reason.status+": "+reason.statusText);
		})
	};
	
	return {
		getAll:findAll
	}
	
})
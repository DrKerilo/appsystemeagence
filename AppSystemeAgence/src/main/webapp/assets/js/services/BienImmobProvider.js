// ===== ClasseStandard =====
// Services pour gérer les données de BienImmobilier
app.factory("biService", function($http,$window) {
	
	// Variable globale du service
	var restUrl="http://localhost:8080/AppSystemeAgence";
	
	// Déclaration externe des fonctions
	// ----- Afficher liste
	function findAllBi(busSC){
		$http({
			method:"GET",
			url:restUrl+"/listBI"
		}).then(function successCallback(response) {
			console.log(response.data);
			busSC(response.data);
		}, function errorCallback(reason) {
			console.log("Erreur "+reason.status+": "+reason.statusText);
		})
	};
	
	return {
		getAllBi:findAllBi
	}
	
})
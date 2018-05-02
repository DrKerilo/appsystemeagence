// ===== ClasseStandard =====
// Services pour gérer les données de ClasseStandard
app.factory("csService", function($http, $window) {

	// Variable globale du service
	var restUrl = "http://localhost:8080/AppSystemeAgence/";

	// Déclaration externe des fonctions
	// ----- Afficher liste
	function findAll(busSC) {
		$http({
			method : "GET",
			url : restUrl + "/listeCS"
		}).then(function successCallback(response) {
			busSC(response.data);
		}, function errorCallback(reason) {
			console.log("Erreur " + reason.status + ": " + reason.statusText);
		})
	}
	;

	// ----- Ajouter
	function addClasse(cs, busSC) {
		$http({
			method : "POST",
			url : restUrl + "/classeStandard",
			data : JSON.stringify(cs),
			headers : {
				"Content-Type" : "application/json"
			}
		}).then(function successCallback(response) {
			busSC(response.statusText);
		}, function errorCallback(reason) {
			console.log("Erreur " + reason.status + ": " + reason.statusText);
		})
	}
	;

	// ----- Modifier
	function updateClasse(cs, busSC) {
		$http({
			method : "PUT",
			url : restUrl + "/classeStandard",
			data : JSON.stringify(cs),
			headers : {
				"Content-Type" : "application/json"
			}
		}).then(function successCallback(response) {
			busSC(response.status)
		}, function errorCallback(reason) {
			busSC(reason.status);
			console.log("Erreur " + reason.status + ": " + reason.statusText);
		})
	}
	
	// ----- Supprimer
	function deleteClasse(id,busSC){
		if($window.confirm("Êtes-vous sûr de vouloir supprimer cette classe ?")){
			$http.delete(restUrl+"/classeStandard/"+id)
			.then(function successCallback(response) {
				busSC(response.statusText);
			}, function errorCallback(reason) {
				console.log("Erreur "+reason.status+": "+reason.statusText);
			});
		}
	};
	
	// ----- Chercher par id
	function findClasse(id,busSC){
		$http.get(restUrl+"/classeStandard?pId="+id)
				.then(function successCallback(response) {
					busSC(response.data);
				}, function errorCallback(reason) {
					console.log("Erreur "+reason.status+": "+reason.statusText);
				})
	};

	return {
		getAll : findAll,
		addOne : addClasse,
		updateOne : updateClasse,
		deleteOne : deleteClasse,
		getOne : findClasse
	}

})
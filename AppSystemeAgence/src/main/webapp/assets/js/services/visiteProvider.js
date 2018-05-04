// ===== Visite =====
// Services pour gérer les données de Visite
app.factory("visiteService", function($http,$window) {
	
	// Variable globale du service
	var restUrl="http://localhost:8080/AppSystemeAgence";
	
	// Déclaration externe des fonctions
	// ----- Afficher liste visites d'un agent
	function findAll(busSC){
		$http({
			method:"GET",
			url:restUrl+"/listeVisites"
		}).then(function successCallback(response) {
			busSC(response.data);
		}, function errorCallback(reason) {
			console.log("Erreur "+reason.status+": "+reason.statusText);
		})
	};
	
	// ----- Ajouter une visite à la liste
	function newVisite(vi, busSC) {
		$http({
			method : "POST",
			url : restUrl + "/visite",
			data : angular.toJson(vi),
			headers : {
				"Content-Type" : "application/json"
			}
		}).then(function successCallback(response) {
			busSC(response.statusText);
		}, function errorCallback(reason) {
			console.log("Erreur " + reason.status + ": " + reason.statusText);
		})
	};
	
	// ----- Supprimer une visite de la liste
	function deleteVisite(id,busSC){
		if($window.confirm("Êtes-vous sûr de vouloir annuler cette visite ?")){
			$http.delete(restUrl+"/visite?pId="+id)
			.then(function successCallback(response) {
				busSC(response.statusText);
			}, function errorCallback(reason) {
				console.log("Erreur "+reason.status+": "+reason.statusText);
			});
		}
	};
	
	// ----- Modifier
	function updateVisite(vi, busSC) {
		$http({
			method : "PUT",
			url : restUrl + "/visite",
			data : angular.toJson(vi),
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
	
	return {
		getAll : findAll,
		addVisite : newVisite,
		deleteOne : deleteVisite,
		updateOne : updateVisite
	}
	
})
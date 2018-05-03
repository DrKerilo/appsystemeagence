// ===== Proprietaire =====
// Services pour gérer les données de Proprietaire
app.factory("propService", function($http,$window) {
	
	// Variable globale du service
	var restUrl = "http://localhost:8080/AppSystemeAgence";
	
	// Déclaration externe des fonctions
	// ----- Afficher liste
	function findAll(busSC) {
		$http({
			method : "GET",
			url : restUrl + "/listeProprietaire"
		}).then(function successCallback(response) {
			busSC(response.data);
		}, function errorCallback(reason) {
			console.log("Erreur " + reason.status + ": " + reason.statusText);
		})
	}
	;
	
	// ----- Ajouter
	function addProprio(p, busSC) {
		$http({
			method : "POST",
			url : restUrl + "/proprietaire",
			data : JSON.stringify(p),
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
	function updateProprio(p, busSC) {
		$http({
			method : "PUT",
			url : restUrl + "/proprietaire",
			data : JSON.stringify(p),
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
	function deleteProprio(id,busSC){
		if($window.confirm("Êtes-vous sûr de vouloir supprimer ce propriétaire ?")){
			$http.delete(restUrl+"/proprietaire/"+id)
			.then(function successCallback(response) {
				busSC(response.statusText);
			}, function errorCallback(reason) {
				console.log("Erreur "+reason.status+": "+reason.statusText);
			});
		}
	};
	
	// ----- Chercher par id
	function findProprio(id,busSC){
		$http.get(restUrl+"/proprietaire?pID="+id)
				.then(function successCallback(response) {
					busSC(response.data);
				}, function errorCallback(reason) {
					console.log("Erreur "+reason.status+": "+reason.statusText);
				})
	};

	return {
		getAll : findAll,
		addOne : addProprio,
		updateOne : updateProprio,
		deleteOne : deleteProprio,
		getOne : findProprio
	}
})
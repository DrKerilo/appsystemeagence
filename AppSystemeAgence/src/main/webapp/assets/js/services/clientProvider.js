// ===== Client ======
// Services pour gérer les données de Client
app.factory("clService", function($http,$window) {
	
	// Variable globale du service
	var restUrl="http://localhost:8080//AppSystemeAgence";
	
	// Déclaration externe des fonctions
	// ----- Afficher liste
	function findAll(busSC){
		
		$http({
			method: "GET",
			url: restUrl+"/listeClient"
		}).then (function successCallback(reponse) {
			busSC(reponse.data); // transporte la liste au controller
		}, function erreurCallback(reason) {
			console.log("Erreur " + reason.status + ": " + reason.statusText);
		});
	};
	
	// ----- Ajouter
	function addClient(cl,busSC){
		$http({
			method: "POST",
			url: restUrl+"/clientAdd",
			data:JSON.stringify(cl), // pareil que : angular.toJson(cl);
			headers:{ContentType: "application/JSON"} //spécifie le type du contenu de la requête
		}).then (function successCallback(reponse) {
			busSC(reponse.data); // transporte la liste au controller
		}, function erreurCallback(reason) {
			console.log("Erreur " + reason.status + ": " + reason.statusText);
		});
		
	}
	
	// ----- Modifier
	function updateClient(cl, busSC) {
		$http({
			method : "PUT",
			url : restUrl + "/clientUpdate",
			data : JSON.stringify(cl),
			headers : {"Content-Type" : "application/json"}
		}).then(function successCallback(response) {
			busSC(response.data)
		}, function errorCallback(reason) {
			busSC(reason.status);
			console.log("Erreur " + reason.status + ": " + reason.statusText);
		})
	}
	
	// ----- Supprimer
	function deleteClient(id,busSC){
		if($window.confirm("Êtes-vous sûr de vouloir supprimer ce client ?")){
			$http.delete(restUrl+"/deleteClient/"+id)
			.then(function successCallback(response) {
				busSC(response.statusText);
			}, function errorCallback(reason) {
				console.log("Erreur "+reason.status+": "+reason.statusText);
			});
		}
	};
	
	// ----- Chercher par id
	function findClient(id,busSC){
		$http.get(restUrl+"/client/"+id)
				.then(function successCallback(response) {
					busSC(response.data);
				}, function errorCallback(reason) {
					console.log("Erreur "+reason.status+": "+reason.statusText);
				})
	};

	return {
		getAll : findAll,
		addOne : addClient,
		updateOne : updateClient,
		deleteOne : deleteClient,
		getOne : findClient
	}
});
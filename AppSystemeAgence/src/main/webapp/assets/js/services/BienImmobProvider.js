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
			url:restUrl+"/listeBI"
		}).then(function successCallback(response) {
			console.log(response.data);
			busSC(response.data);
		}, function errorCallback(reason) {
			console.log("Erreur "+reason.status+": "+reason.statusText);
		});
	}
	
	// ----- Afficher liste selon classe standard
	function findByCat(cat, busSC){
		$http({
			method:"GET",
			url:restUrl+"/listeBIByClasse/" + cat 
		}).then(function successCallback(response) {
			console.log(response.data);
			busSC(response.data);
		}, function errorCallback(reason) {
			console.log("Erreur "+reason.status+": "+reason.statusText);
		});
	}
	
	// ----- Afficher liste selon propriétaire
	function findByProp(id, busSC){
		$http({
			method:"GET",
			url:restUrl+"/listeBIByProprietaire/" + id 
		}).then(function successCallback(response) {
			console.log(response.data);
			busSC(response.data);
		}, function errorCallback(reason) {
			console.log("Erreur "+reason.status+": "+reason.statusText);
		});
	}

	// Rechercher par ID
	function searchBi(id, busSC) {
		$http.get(restUrl + "/bienImmo?pId=" + id)
		
		.then(function succesCallback(response) { // promise
// console.log(response.data);
			busSC(response.data);
		}, function erreurCallback(response) {
			console.log("Erreur : ----" + response.statusText)
		});
	}
	
	function delBi(id, busSC) {
		$http.delete(restUrl + "/bienImmo/" + id)
		
		.then(function succesCallback(response) { // promise
			busSC(response.data);
			}, function erreurCallback(response) {
			console.log("Erreur : ----" + response.statusText)
		});
	}
	
	// Ajouter
	function addBi(bi, busSC) {
		
		// transformer l'image récupérée en base 64
		bi.photo = bi.photo.base64;
		
		$http({
			method : "POST",
			url : restUrl + "/bienImmo",
			data : JSON.stringify(bi),
			headers: {
				"Content-Type" : "application/JSON"
			}
		})
		
		.then(function succesCallback(response) { // promise
			busSC(response.statusText);
		}, function erreurCallback(reason) {
			console.log("Erreur : ----" + reason.statusText);
		});
	}
	
	// Modifier un bien immobilier
	function editBi(bi, busSC) {
		// transformer l'image récupérée en base 64
		bi.photo = bi.photo.base64;
		
		$http({
			method : "PUT",
			url : restUrl + "/bienImmo",
			data : JSON.stringify(bi),
			headers: {
				"Content-Type" : "application/JSON"
			}
		})
		
		.then(function succesCallback(response) { // promise
			busSC(response.statusText);
		}, function erreurCallback(reason) {
			console.log("Erreur : ----" + reason.statusText);
		});
	}
	
	// FONCTION GEOLOCALISATION
	function geoAdresse(rue, codePostal, ville, bus) {
		$http(
				{
					method : "GET",
					url : "https://maps.googleapis.com/maps/api/geocode/json?address="
							+ rue
							+ ","
							+ codePostal
							+ ""
							+ ville
							+ "&key=AIzaSyDy1ZKI7FhtHYJx8VEB0GQyjcUoxc2nwy4"
				}).then(
				function successCallBack(response) {
					bus(response.data)
				},
				function errorCallBack(response) {
					console.log("Erreur : ------"
							+ response.statusText);
				})

}

	
	return {
		getAllBi:findAllBi,
		ajoutBi:addBi, 
		modifBi:editBi,
		supprimBi:delBi,
		getBi:searchBi,
		getBiByCat:findByCat,
		getBiByProp:findByProp,
		localisationBi : geoAdresse
		
	}
	
	
})
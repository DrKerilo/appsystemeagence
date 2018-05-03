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
	
	// ----- Afficher liste
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

	
	function searchBi(id, busSC) {
		$http.get(restUrl + "/bienImmo?pId=" + id)
		
		.then(function succesCallback(response) { //promise
//			console.log(response.data);
			busSC(response.data);
		}, function erreurCallback(response) {
			console.log("Erreur : ----" + response.statusText)
		});
	}
	
	function delBi(id, busSC) {
		$http.delete(restUrl + "/bienImmo/" + id)
		
		.then(function succesCallback(response) { //promise
			busSC(response.data);
			}, function erreurCallback(response) {
			console.log("Erreur : ----" + response.statusText)
		});
	}
	
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
		
		.then(function succesCallback(response) { //promise
			busSC(response.statusText);
		}, function erreurCallback(reason) {
			console.log("Erreur : ----" + reason.statusText);
		});
	}
	
	function editBi(bi, busSC) {
		$http({
			method : "PUT",
			url : restUrl + "/bienImmo",
			data : JSON.stringify(bi),
			headers: {
				"Content-Type" : "application/JSON"
			}
		})
		
		.then(function succesCallback(response) { //promise
			busSC(response.statusText);
		}, function erreurCallback(reason) {
			console.log("Erreur : ----" + reason.statusText);
		});
	}
	
	return {
		getAllBi:findAllBi,
		ajoutBi:addBi, 
		modifBi:editBi,
		supprimBi:delBi,
		getBi:searchBi,
		getBiByCat:findByCat
		
	}
	
	
})
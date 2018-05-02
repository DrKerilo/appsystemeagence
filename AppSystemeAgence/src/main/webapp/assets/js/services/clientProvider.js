app.factory("eService", function($http) {
	
	var restUrl="http://localhost:8080//AppSystemeAgence";
	
	function listeAll(busSC){
		
		$http({
			method: "GET",
			url: restUrl+"/listeClient"
		}).then (function successCallback(reponse) {
			
			busSC(reponse.data); // transporte la liste au controller
			
		}, function erreurCallback(reponse) {
			
			console.log("Erreur:---"+reponse.statusText)
			
		});
	}
	
	function addStudent(client,busSC){
		
		$http({
			method: "POST",
			url: restUrl+"/clientAdd",
			data:JSON.stringify(etudiant), // pareil que : angular.toJson(etudiant);
			headers:{ContentType: "application/JSON"} //spécifie le type du contenu de la requête
		}).then (function successCallback(reponse) {
			
			busSC(reponse.data); // transporte la liste au controller
			
		}, function erreurCallback(reponse) {
			
			console.log("Erreur:---"+reponse.statusText)
			
		});
		
	}
	
	function findOne(id,busSC) {
		
		$http({
			method: "GET",
			url: restUrl+"/client/"+id
		}).then (function successCallback(rerponse) {
			
			busSC(reponse.data); // transporte la liste au controller
			
		}, function erreurCallback(reponse) {
			
			console.log("Erreur:---"+reponse.statusText)
			
		});
		
	}
	
	function delOne(idDel,busSC) {
		$http.delete(restUrl+"/deleteClient/"+idDel)
		.then(
				function successCallback(reponse){
					busSC(reponse.statusText);
				},function erroCallback(reponse){
					console.log("Erreur:---"+reponse.statusText)
		});
		
	}
	
	function updateStudent(etudiant,busSC){
		$http({
			method:"PUT",
			url: restUrl+"/eModif",
			data:JSON.stringify(etudiant), // pareil que : angular.toJson(etudiant);
			headers:{ContentType: "application/JSON"} //spécifie le type du contenu de la requête
		})
		.then(
				function successCallback(reponse){
					busSC(reponse.statusText);
				},function erroCallback(reponse){
					console.log("Erreur:---"+reponse.statusText)
		});
		
	}
	
	return {
		getAll:listeAll, // appel de la fonction
		getOne:findOne,
		supOne:delOne,
		addOne:addStudent,
		upOne:updateStudent
	}
	
});
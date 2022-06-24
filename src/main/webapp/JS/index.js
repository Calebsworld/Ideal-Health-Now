(function() {
	
	var applic = angular.module('app', ['ngRoute']);
	applic.config(function($routeProvider){
		$routeProvider
		.when("/main", {
			templateUrl : "main.html" })
		.when("/about", {
			templateUrl : "about.html"})
		.when("/ourteam", {
			templateUrl : "ourteam.html"})
		.when("/products", {
			templateUrl : "products.html",
			controller : "productsController" })
		.when("/update/:productId", {
			templateUrl : "update.html",
			controller : "updateController" })
		.when("/location", {
			templateUrl : "location.html"})
		.otherwise({
			templateUrl : "main.html"
		});
		
	})
	
})();

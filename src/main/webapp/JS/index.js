(function() {
	
	var app = angular.module('app', ['ngRoute']);
	app.config(function($routeProvider){
		$routeProvider
		.when("/main", {
			templateUrl : "main.html" })
		.when("/about", {
			templateUrl : "about.html"})
		.when("/ourteam", {
			templateUrl : "ourteam.html"})
		.when("/products", {
			templateUrl : "products.html"})
		.when("/admin", {
			templateUrl : "admin.html",
			controller : "adminController" })
		.when("/update/:productId", {
			templateUrl : "update.html",
			controller : "updateController" })
		.when("/create", {
			templateUrl : "create.html",
			controller : "createController" })
		.when("/location", {
			templateUrl : "location.html" })
		.otherwise({
			templateUrl : "main.html"
		});
		
	})
	
})();

(function() {
	
	var app = angular.module('app', ['ngRoute', 'ngAnimate']);
	app.config(function($routeProvider){
		$routeProvider
		.when("/main", {
			templateUrl : "main.html" })
		.when("/about", {
			templateUrl : "about.html" })
		.when("/ourteam", {
			templateUrl : "ourteam.html" })
		.when("/products", {
			templateUrl : "products.html",
			controller : "productsController" })
		.when("/admin", {
			templateUrl : "admin.html",
			controller : "adminController" })
		.when("/cart", {
			templateUrl : "cart.html",
			controller : "cartController" })
		.when("/update/:productId", {
			templateUrl : "update.html",
			controller : "updateController" })
		.when("/create", {
			templateUrl : "create.html",
			controller : "createController" })
		.otherwise({
			templateUrl : "main.html" });
		
	});
	
})();

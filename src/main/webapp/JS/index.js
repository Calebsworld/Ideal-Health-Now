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
			templateUrl : "products.html",
			controller : "productsController"})
		.when("/admin", {
			templateUrl : "admin.html",
			controller : "adminController" })
		.when("/user", {
			templateUrl : "user.html",
			controller : "userController" })
		.when("/cart", {
			templateUrl : "cart.html",
			controller : "cartController" })
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

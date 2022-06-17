/**
* Create a module 
 */

let app = angular.module('app', ['ngRoute']);
app.config(function ($routeProvider) {
	$routeProvider
	.when("/about", {
    templateUrl : "about.html"
  })
  .when("/ourteam", {
    templateUrl : "ourteam.html"
  })
  .when("/location", {
	templateUrl : "location.html"
	})
  .when("/products", {
	templateUrl : "products.html"
	})
  .otherwise({
	templateUrl : "index.html"
	})
});

	





let app = angular.module('app', ['ngRoute']);
app.configure(function($routeProvider) {
  $routeProvider
  .when("/about", {
    templateUrl : "about.html"
  })
  .when("/ourteam", {
    templateUrl : "ourteam.html"
  })
  .when("/products", {
	templateUrl : "products.html",
	})
  .when("/location", {
	templateUrl : "create.html"
	})
  .otherwise({
	templateUrl : "index.html"
	})
});
/**
* Access the previously created module 'app'
* and create a controller associated with our module. 
*/

let myApp = angular.module('app');
myApp.controller('adminController', function($scope, $http, $location) {
	$scope.getAllProducts = function() {
		$http.get('/idealhealthnow/webapi/home/products')
		.then(function(response) {
			$scope.products = response.data;
		}, function(response) {
			console.log('error http GET products: ' + response.status);	
		});
	} 
	$scope.getAllProducts();
	
	
	$scope.goToUpdateView = function(productId) {
		alert(productId);
		$location.path('/update/' + productId);
	}

	$scope.goToCreateView = function() {
		$location.path('/create');
	}
	
	
});
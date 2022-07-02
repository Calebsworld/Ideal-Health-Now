(function(){
	
	var myApp = angular.module('app');
	myApp.controller('productsController', function($scope, $http, $location, $routeParams){
	
	$scope.getAllProducts = function() {
		$http.get('/idealhealthnow/webapi/home/products')
		.then(function(response) {
			$scope.products = response.data;
		}, function(response) {
			console.log('error http GET products: ' + response.status);	
		});
	} 
	$scope.getAllProducts();	
		
		
		
		
	})
	
})();
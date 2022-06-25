(function(){
	
	var myApp = angular.module('app');
	myApp.controller('updateController', function($scope, $http, $location, $routeParams){
		
		$scope.productTypes = ['Food', 'Supplement'];
		
		$scope.getProductsById = function() {
			$http.get('/idealhealthnow/webapi/home/products/id/' + $routeParams.productId)			
			.then(function(response) {
				var products = response.data;
				if (products.length == 1) {
					$scope.product = products[0];	
				} else {
					console.log('Logic error');
				}
				
			}, function(response) {
				console.log('error http GET products by id: ' + response.status);
			});
		}
		
		$scope.getProductsById();
		
		$scope.updateProduct = function() {
			$http.put('/idealhealthnow/webapi/home/products', $scope.product)
			.then(function(response) {
				$scope.updateStatus = 'update successful';	
			}, function(response) {
				$scope.updateStatus = 'error trying to update product';	
				console.log('error http PUT products: ' + response.status);
			});
		}
		
		$scope.deleteProduct = function() {
			$http.delete('/idealhealthnow/webapi/home/products/id/' + $scope.product.id)
			.then(function(response) {
				$scope.updateStatus = 'delete successful';	
				$scope.disableUpdate = true;
			}, function(response) {
				$scope.updateStatus = 'error trying to delete product';	
				console.log('error http DELETE products: ' + response.status);
			});
		}
		
		$scope.goToProductsView = function() {
			$location.path('/admin');
		} 
		
		
		
	})
	
})();
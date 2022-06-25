(function(){
	
	var myApp = angular.module('app');
	myApp.controller('createController', function($scope, $http, $location){
		
		$scope.productTypes = ['Food', 'Supplement'];
		
		$scope.createProduct = function() {
			$http.post('/idealhealthnow/webapi/home/products', $scope.product)
			.then(function(response) {
				$scope.createStatus = 'create successful';
				$scope.disableCreate = true;
			}, function(response) {
				$scope.createStatus = 'error trying to create product';	
				console.log('error http POST products: ' + response.status);
			}) 
		}
		
		$scope.clear = function() {
			$scope.product.productName = "";
			$scope.product.productType = "";
			$scope.product.category = "";
			$scope.product.description = "";
			$scope.disableCreate = false;
			$scope.createForm.$setUntouched();
			$scope.createForm.$setPristine();
		}
		
		$scope.goToProductsView = function() {
			$location.path("/admin");
		}
		
	})
	
})();
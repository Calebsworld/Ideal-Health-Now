(function(){
	
	var myApp = angular.module('app');
	myApp.controller('productsController', function($scope, $http, $timeout){

	$scope.productTypes = ['Food', 'Supplement'];

	$scope.filterProducts = false;
	
	$scope.filter = function() {
		$scope.filterProducts = true;
		$scope.showProducts();
	};
	
	$scope.getAllProducts = function() {
		$http.get('/idealhealthnow/webapi/home/products')
		.then(function(response) {
			$scope.products = response.data;
		}, function(response) {
			console.log('error http GET products: ' + response.status);	
		});
	} 

	$scope.getProductsByType = function() {
		$http.get(`/idealhealthnow/webapi/home/products/productType/${$scope.productType}`)
			.then(function(response) {
					$scope.products = response.data;
				}, function error(response) {
					console.log("Error http GET products by type");
				});
	};
	
	$scope.showProducts = function() {
		if ($scope.filterProducts === true) {
			$scope.getProductsByType();
		} else {
			$scope.getAllProducts();
		}	
	};
	
	$scope.showProducts();
	
	$scope.clearFilter = function() {
		$scope.productType = "";
		$scope.filterProducts = false;
		$scope.showProducts();
	};
	
	$scope.success = false;
	
	$scope.addToCart = function(item) {
			if (localStorage.getItem('cart') != null) {
				$scope.cart = JSON.parse(localStorage.getItem('cart'));
				$scope.cart.push(item);	
				localStorage.setItem('cart', JSON.stringify($scope.cart));
			} else {
				// new cart
				$scope.cart = [item];
				localStorage.setItem('cart', JSON.stringify($scope.cart));
			}
				$scope.success = true;	
				$scope.successMessage = "Item successfully added to cart";	
	
			$timeout(function () {
				$scope.closeAlert();
			}, 4000);		
			
		}
		
		$scope.closeAlert = function () {
			$scope.success = false;
		}
	
	
	})
	
})();
(function(){
	
	var myApp = angular.module('app');
	myApp.controller('cartController', function($scope, $http, $location){
		
		$scope.getCart = function() {
			if (localStorage.getItem('cart') != null) {
				$scope.cart = JSON.parse(localStorage.getItem('cart'));				
			} else {				
				$scope.cart = [];				
			}			
		}
		
		$scope.getCart();
		
		$scope.removeItemFromCart = function (item) {
			if (localStorage.getItem('cart') != null && localStorage.getItem('cart').length != 0) {
				$scope.cart = JSON.parse(localStorage.getItem('cart'));
				$scope.cart.pop(item);
				localStorage.setItem('cart', JSON.stringify($scope.cart));
			} else {
				console.log('Either cart is null, or empty');
			}
		}
		
		
		$scope.emptyMyCart = function() {
			if (localStorage.getItem('cart') != null) {
				$scope.cart = [];
				localStorage.setItem('cart', JSON.stringify($scope.cart));			
			}			
		}
		
		
			

		
	})
	
})();
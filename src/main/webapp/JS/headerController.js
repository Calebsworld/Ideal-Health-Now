(function () {
	
	var myApp = angular.module('app');
	myApp.controller('headerController', function($scope, $location) {
	
	$scope.isActive = function (viewLocation) {
		return viewLocation === $location.path();
		
	};
		
	});
	
})();
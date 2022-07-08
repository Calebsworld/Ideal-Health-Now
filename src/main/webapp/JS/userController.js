(function(){
	
	var myApp = angular.module('app');
	myApp.controller('userController', function($scope, $http, $location){
		
		$scope.clear = function() {
			$scope.user.firstName = "";
			$scope.user.lastName = "";
			$scope.user.email = "";
			$scope.disableCreate = false;
			$scope.createForm.$setUntouched();
			$scope.createForm.$setPristine();
		}
		
		
	})
	
})();
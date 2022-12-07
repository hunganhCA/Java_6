app.controller("product-ctrl",function($scope,$http){
   $scope.items=[];
	$scope.form={}
	
	$scope.initialize = function(){
		$http.get("/rest/product").then(resp=>{
			$scope.items = resp.data;
			$scope.items.forEach(item =>{
				item.createDate = new Date(item.createDate)
			})
		})
		
	}
	$scope.initialize();//khoi dau
	
	$scope.reset = function(){}
	
	$scope.edit=function(item){
		$scope.form=angular.copy(item);
	}
		
	$scope.create = function(){}
	
	$scope.update = function(){}
	
	$scope.delete = function(){}
	
	
	//edit image
	$scope.imageChanged = function(files){}
}) ;
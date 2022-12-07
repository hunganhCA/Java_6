var app = angular.module("adminApp",["ngRoute"]);
app.config(function($routeProvider){
	$routeProvider
	.when("/product",{
		templateUrl:"/admin/product/index.html",
		controller: "product-ctrl"
	})
	.when("/authorize",{
		templateUrl:"/admin/authority/index.html",
		controller: "authority-ctrl"
	})
	.when("/unauthorized",{
		templateUrl:"/admin/authority/unauthorized.html",
		controller: "authority-ctrl"
	})
	.otherwise({
		template:"<h1 class='text-center'>Welcome Admin!</h1>",
	})
})
var app = angular.module("myApp", ["ngRoute"]);


app.directive("navbarBootstrap", function() {
    return {
        restrict: "E",
        replace: true,
        transclude: true,
        templateUrl : "components/navbar.html"
    };
});
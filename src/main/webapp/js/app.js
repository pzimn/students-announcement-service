var app = angular.module('app', ['ui.bootstrap','ngRoute', 'dx']);

app.controller('MainController', MainController );
var MainController = function($scope){
    $scope.val = "Main controller variable value"
};

app.directive("navbarBootstrap", function() {
    return {
        restrict: "E",
        replace: true,
        transclude: true,
        templateUrl : "components/navbar.html"
    };
});
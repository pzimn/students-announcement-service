var app = angular.module("app", ["ui.bootstrap","ngRoute","dx"]);


app.factory('$exceptionHandler',['$injector', function($injector) {
    return function(exception, cause) {
        var errorHandling = $injector.get('errorHandling');
        errorHandling.add(exception.message);
        throw exception;
    };
}]);

app.directive("navbarBootstrap", function() {
    return {
        restrict: "E",
        replace: true,
        transclude: true,
        templateUrl : "components/navbar.html"
    };
});
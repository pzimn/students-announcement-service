var app1 = angular.module('app1',[]);

app1.controller('tableCtrl', ['$scope', 'MessageCRUDService', function ($scope, MessageCRUDService) {

    $scope.getAllMessages = function () {
        MessageCRUDService.getAllMessages()
            .then(function success(response){
                    console.log("pobrano wiadomosci");
                    $scope.messages = response.data;
                    $scope.message='sukces';
                    $scope.errorMessage = 'sukces';
                },
                function error (response){
                    $scope.message='';
                    $scope.errorMessage = 'Error getting users!';
                });
    }

    $scope.getAllUsers = function () {
        MessageCRUDService.getAllUsers()
            .then(function success(response){
                    console.log("pobrano userów");
                    $scope.users = response.data;
                    $scope.message='';
                    $scope.errorMessage = '';
                },
                function error (response){
                    $scope.message='';
                    $scope.errorMessage = 'Error getting users!';
                });
    }

    $scope.getUser = function (id) {
        MessageCRUDService.getUser(id)
            .then(function success(response){
                    $scope.user = response.data;
                    $scope.message='';
                    $scope.errorMessage = '';
                    console.log("pobrano usera");
                    console.log($scope.user);
                },
                function error (response ){
                    $scope.message = '';
                    if (response.status === 404){
                        $scope.errorMessage = 'User not found!';
                    }
                    else {
                        $scope.errorMessage = "Error getting user!";
                    }
                });
    }

}]);

app1.service('MessageCRUDService',['$http', function ($http) {

    this.getAllMessages = function getAllMessages(){
        return $http({
            method: 'GET',
            url: 'api/messages'
        });
    }

    this.getAllUsers = function getAllUsers(){
        return $http({
            method: 'GET',
            url: 'api/users'
        });
    }

    this.getUser = function getUser(userId){
        return $http({
            method: 'GET',
            url: './api/users/'+userId
        });
    }

}]);
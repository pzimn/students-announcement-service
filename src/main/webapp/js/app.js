var app = angular.module('app',[]);

app.controller('UserCRUDCtrl', ['$scope','UserCRUDService', function ($scope,UserCRUDService) {

    $scope.updateUser = function () {
        UserCRUDService.updateUser($scope.user.id,$scope.user.email, $scope.user.name, $scope.user.lastname, $scope.user.password, $scope.user.education, $scope.user.department, $scope.user.specialization)
            .then(function success(response){
                    $scope.message = 'User data updated!';
                    $scope.errorMessage = '';
                },
                function error(response){
                    $scope.errorMessage = 'Error updating user!';
                    $scope.message = '';
                });
    }
    $scope.getUser = function () {
        var id = $scope.user.id;
        UserCRUDService.getUser($scope.user.id)
            .then(function success(response){
                    $scope.user = response.data;
                    $scope.user.id = id;
                    $scope.message='';
                    $scope.errorMessage = '';
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

    $scope.addUser = function () {

            UserCRUDService.addUser($scope.user.name, $scope.user.email, $scope.user.lastname, $scope.user.password, $scope.user.education, $scope.user.department, $scope.user.specialization)
                .then (function success(response){
                        $scope.message = 'User added!';
                        $scope.errorMessage = 'a';
                    },
                    function error(response){
                        $scope.errorMessage = 'Error adding user!';
                        $scope.message = 'b';
                    });

    };

    $scope.deleteUser = function () {
        UserCRUDService.deleteUser($scope.user.id)
            .then (function success(response){
                    $scope.message = 'User deleted!';
                    $scope.user = null;
                    $scope.errorMessage='';
                },
                function error(response){
                    $scope.errorMessage = 'Error deleting user!';
                    $scope.message='';
                })
    }

    $scope.getAllUsers = function () {
        UserCRUDService.getAllUsers()
            .then(function success(response){
                    $scope.users = response.data;
                    $scope.message='1';
                    $scope.errorMessage = '2';
                },
                function error (response){
                    $scope.message='1';
                    $scope.errorMessage = 'Error getting users!';
                });
    }

}]);

app.service('UserCRUDService',['$http', function ($http) {

    this.getUser = function getUser(userId){
        return $http({
            method: 'GET',
            url: './api/users/'+userId
        });
    }

    this.addUser = function addUser(name, email, lastname, password, education, specialization,department){
        return $http({
            method: 'POST',
            url: 'api/users',
            data: {name:name, email:email, lastname:lastname, password:password, education:education,specialization:specialization, department:department}
        });
    }

    this.deleteUser = function deleteUser(id){
        return $http({
            method: 'DELETE',
            url: './api/users/'+id
        })
    }

    this.updateUser = function updateUser(id, name, email, lastname, password, education, specialization,department){
        return $http({
            method: 'PATCH',
            url: './api/users/'+id,
            data: {name:name, email:email, lastname:lastname, password:password, education:education,specialization:specialization, department:department}
        })
    }

    this.getAllUsers = function getAllUsers(){
        return $http({
            method: 'GET',
            url: 'api/users'
        });
    }

}]);
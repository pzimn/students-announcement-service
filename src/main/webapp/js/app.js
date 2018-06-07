var app = angular.module('app',[]);





app.controller('UserCRUDCtrl', ['$scope','UserCRUDService', function ($scope,UserCRUDService) {

    $scope.test1='abc13';
    var msgs;
    $scope.timestamp = new Date().getTime() ;


    $scope.addMsg = function () {

        UserCRUDService.addMsg($scope.senderId, $scope.recipientId, $scope.timestamp, $scope.content)
            .then (function success(response){
                    $scope.message = 'msg added!';
                    $scope.errorMessage = '';
                },
                function error(response){
                    $scope.errorMessage = 'error adding msg!';
                    $scope.message = '';
                });

    };

    $scope.getAllMessages = function () {
        UserCRUDService.getAllMessages()
            .then(function success(response){
                    $scope.messages = response.data;
                    msgs=response.data;
                    this.descriptions = msgs.join('\n');
                    $scope.message='ok';
                    $scope.errorMessage = '';
                },
                function error (response){
                    $scope.message='';
                    $scope.errorMessage = 'Error getting msgs!';
                });
    };

    $scope.updateUser = function () {
        UserCRUDService.updateUser($scope.user.id,$scope.user.email, $scope.user.name, $scope.user.lastname, $scope.user.password, $scope.user.education, $scope.user.schoolId, $scope.user.department, $scope.user.specialization)
            .then(function success(response){
                    $scope.message = 'User data updated!';
                    $scope.errorMessage = '';
                },
                function error(response){
                    $scope.errorMessage = 'Error updating user!';
                    $scope.message = '';
                });
    };
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
    };

    $scope.addUser = function () {

        UserCRUDService.addUser($scope.user.name, $scope.user.email, $scope.user.lastname, $scope.user.password, $scope.user.education, $scope.user.schoolId, $scope.user.department, $scope.user.specialization)
            .then (function success(response){
                    $scope.message = 'User added!';
                    $scope.errorMessage = '';
                },
                function error(response){
                    $scope.errorMessage = 'Error adding user!';
                    $scope.message = '';
                });

    };

    $scope.addAnnouncement = function () {

        UserCRUDService.addAnnouncement($scope.userId, $scope.categoryId, $scope.title, $scope.description, $scope.price )
            .then (function success(response){
                    console.log("dodano ogloszenie");
                    $scope.message = 'Announcement added!';
                    $scope.errorMessage = '';
                },
                function error(response){
                    $scope.errorMessage = 'Error adding announcement!';
                    $scope.message = '';
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

    $scope.getAllSchools = function () {
        UserCRUDService.Schools()
            .then(function success(response){
                    $scope.schools = response.data;
                    $scope.message='';
                    $scope.errorMessage = '';
                },
                function error (response){
                    $scope.message='';
                    $scope.errorMessage = 'Error getting users!';
                });
    }

    $scope.getAllUsers = function () {
        UserCRUDService.getAllUsers()
            .then(function success(response){
                    $scope.users = response.data;
                    $scope.message='';
                    $scope.errorMessage = '';
                },
                function error (response){
                    $scope.message='';
                    $scope.errorMessage = 'Error getting users!';
                });
    }

    $scope.getAnnouncements = function () {
        UserCRUDService.getAnnouncements()
            .then(function success(response){
                    $scope.announcements = response.data;
                    $scope.message='';
                    $scope.errorMessage = '';
                },
                function error (response){
                    $scope.message='';
                    $scope.errorMessage = 'Error getting anns!';
                });
    }

}]);

app.service('UserCRUDService',['$http', function ($http) {

    this.addMsg = function addMsg(senderId, recipientId, timestamp, content){
        return $http({
            method: 'POST',
            url: 'api/messages',
            data: {senderId:senderId, recipientId:recipientId, timestamp:timestamp, content:content}
        });
    }

    this.getUser = function getUser(userId){
        return $http({
            method: 'GET',
            url: './api/users/'+userId
        });
    }

    this.addUser = function addUser(name, email, lastname, password, education, schooldId, department, specialization){
        return $http({
            method: 'POST',
            url: 'api/users',
            data: {name:name, email:email, lastname:lastname, password:password, education:education, schoolId:schooldId ,department:department, specialization:specialization}
        });
    }

    this.addAnnouncement = function addAnnouncement(userId, categoryId, title, description, price){
        return $http({
            method: 'POST',
            url: 'api/announcements',
            data: {userId:userId, categoryId:categoryId, title:title, description:description, price:price}
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

    this.getAllSchools = function getAllSchools(){
        return $http({
            method: 'GET',
            url: 'api/schools'
        });
    }


    this.getAnnouncements = function getAnnouncements(){
        return $http({
            method: 'GET',
            url: 'api/announcements'
        });
    }

    this.getAllMessages = function getAllMessages() {


        return $http({
            method: 'GET',
            url: 'api/messages'
        });
    }

}]);

app.directive('jsonText', function() {
    return {
        restrict: 'A',
        require: 'ngModel',
        link: function(scope, element, attr, ngModel) {
            function into(input) {
                console.log(JSON.parse(input));
                return JSON.parse(input);
            }
            function out(data) {
                return JSON.stringify(data);
            }
            ngModel.$parsers.push(into);
            ngModel.$formatters.push(out);
        }
    };
});

var app = angular.module('app',[]);

app.controller('UserCRUDCtrl', ['$scope','UserCRUDService', function ($scope,UserCRUDService) {

    $scope.test1="bbb";
    var msgs;
    $scope.timestamp = new Date().getTime() ;
    $scope.userId=2;
    $scope.recipientId=1;
    $scope.log="";
    $scope.logcheck="";
    $scope.password="";
    $scope.pas="";
    $scope.aaa="";
    $scope.abc="";
    $scope.rate=0;
    $scope.content="";


    $scope.ps = function () {
        var it = document.getElementById('pass2').value;
        var it2 = document.getElementById('pass2').innerHTML;
        $scope.abc=it;
        $scope.aaa=it2;
        return it;
    }

    $scope.ps5 = function () {
        var it = document.getElementById('ckie').value;
        var it2 = document.getElementById('ckie').innerHTML;
        $scope.abc=it;
        $scope.aaa=it2;
        return it;
    }

    $scope.logierror = function () {
        $scope.loginerror = "Błąd logowania";
    }

    $scope.logi = function () {
        $scope.logcheck = "passed";
    }
    $scope.logi2 = function () {
        $scope.logcheck = "x";
    }

    $scope.ps2 = function (ab) {
        var it = ab;
        $scope.userId = parseInt(it);
        return it;
    }

    $scope.compare = function (repass) {
        $scope.isconfirm = $scope.user.password == repass ? true : false;
    }

    $scope.recipient = function (ab) {
        var it = ab;
        $scope.recipientId = parseInt(it);
        return it;
    }

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
                    localStorage.setItem('hej','aba')
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

    $scope.updateUser = function (id, rate) {
        UserCRUDService.updateUser(id, rate)
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
                    $scope.message = 'Użytkownik dodany!';
                    $scope.errorMessage = '';
                },
                function error(response){
                    $scope.errorMessage = 'Wystąpił błąd podczas dodawania użytkownika!';
                    $scope.message = '';
                });

    };

    $scope.getAnnouncement = function (id) {
        UserCRUDService.getAnnouncement(id)
            .then(function success(response){
                    $scope.announcement = response.data;
                    $scope.message='';
                    $scope.errorMessage = '';
                    console.log("pobrano ogłoszenie");
                    console.log($scope.announcement);
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

    $scope.addAnnouncement = function () {

        UserCRUDService.addAnnouncement($scope.userId, $scope.categoryId, $scope.title, $scope.description, $scope.price )
            .then (function success(response){
                    console.log("dodano ogloszenie");
                    $scope.message = 'Dodano ogloszenie!';
                    $scope.errorMessage = '';
                },
                function error(response){
                    $scope.errorMessage = 'Wystąpił błąd podczas dodawania ogłoszenia!';
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
                    //$scope.cat=localStorage.getItem(Item('cat'));
                    $scope.message='';
                    $scope.errorMessage = '';
                },
                function error (response){
                    $scope.message='';
                    $scope.errorMessage = 'Error getting anns!';
                });
    }

    $scope.getComments = function () {
        UserCRUDService.getComments()
            .then(function success(response){
                    $scope.comments = response.data;
                    $scope.message='';
                    $scope.errorMessage = '';
                },
                function error (response){
                    $scope.message='';
                    $scope.errorMessage = '';
                });
    }

    $scope.addComment = function (ab,bc,cd) {
        var it = ab;
        $scope.recipientId = parseInt(it);
        var it2 = bc;
        $scope.rate =parseInt(it2);
        var it3 = cd;
        $scope.content =it3;
        UserCRUDService.addComment($scope.userId, $scope.recipientId, $scope.rate, $scope.content)
            .then (function success(response){
                    console.log("dodano komentarz");
                    $scope.message = '';
                    $scope.errorMessage = '';
                },
                function error(response){
                    $scope.errorMessage = 'Wystąpił błąd';
                    $scope.message = '';
                });

    };

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

    this.getAnnouncement = function getAnnouncement(announcementId){
        return $http({
            method: 'GET',
            url: './api/announcements/'+announcementId
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

    this.addComment = function addComment(userId, recipientId, rate, content){
        return $http({
            method: 'POST',
            url: 'api/comments',
            data: {authorId:userId, targetId:recipientId, rate:rate, content:content, date:111111}
        });
    }

    this.deleteUser = function deleteUser(id){
        return $http({
            method: 'DELETE',
            url: './api/users/'+id
        })
    }

    this.updateUser = function updateUser(id, rate){
        return $http({
            method: 'POST',
            url: '/api/users',
            data: {id:id,rate:rate}
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

    this.getComments = function getComments(){
        return $http({
            method: 'GET',
            url: 'api/comments'
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


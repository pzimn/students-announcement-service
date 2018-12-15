var app1 = angular.module('app1',[]);

app1.filter('unique', function() {
    return function(collection, keyname) {
        var output = [],
            keys = [];

        angular.forEach(collection, function(item) {
            var key = item[keyname];
            if(keys.indexOf(key) === -1) {
                keys.push(key);
                output.push(item);
            }
        });
        return output;
    };
});

app1.controller('tableCtrl', ['$scope', 'MessageCRUDService', function ($scope, MessageCRUDService) {
    $scope.timestamp = new Date().getTime() ;
    $scope.senderId='';
    $scope.recipientId2='';
    $scope.recipientId='';

    $scope.recipient = function (x) {
        $scope.recipientId = x;
        document.getElementById('miig').value=x;
        document.getElementById('miig').innerHTML=x;
        $scope.recipientId.value=document.getElementById('miig').value;
        $scope.recipientId.value=document.getElementById('miig').innerHTML;
    }

    $scope.share = function () {
        var it = document.getElementById('miig').value;
        $scope.recipientId=parseInt(it);
        return it;
    }

    $scope.ps = function () {
        var it = document.getElementById('pass').value;

        return it;
    }

    $scope.ps3 = function (ab) {
        var it = ab;
        $scope.userId = it;
        return it;
    }

    $scope.ps2 = function (ab) {
        var it = ab;
        $scope.senderId = it;
        return it;
    }

    $scope.addMsg = function () {
        MessageCRUDService.addMsg($scope.senderId, $scope.recipientId, $scope.timestamp, $scope.content)
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
                    $scope.pass1=$scope.passs;
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

    this.addMsg = function createMessage(senderId, recipientId, timestamp, content){
        return $http({
            method: 'POST',
            url: 'api/messages',
            data: {senderId:senderId, recipientId:recipientId, timestamp:timestamp, content:content}
        });
    }

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
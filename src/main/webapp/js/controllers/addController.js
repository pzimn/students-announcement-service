app.controller('addController', ['$scope', '$uibModal', 'categoryService', 'UserCRUDService', '$window', function ($scope, $uibModal, categoryService, UserCRUDService, $window) {
    $scope.error_message = "";
    $scope.userId = 0;
    $scope.categoryId = 0;
    $scope.categoryName = "nie wybrano";

    $scope.setDefaultValues = function () {
        $scope.addTitle = "Proszę podać tytuł ogłoszenia";
        $scope.addCategory = 3;
        $scope.addPrice = 0;
        $scope.addDescription = "Proszę wpisać opis ogłoszenia";
    }

    $scope.addAnnouncement = function () {
        var title = $scope.addTitle;
        var category = $scope.addCategory;
        var price = $scope.addPrice;
        var description = $scope.addDescription;
    }

    $scope.open = function() {
        var modalInstance =  $uibModal.open({
            templateUrl: "././components/modalContent.html",
            controller: "ModalContentCtrl",
            size: '',
        });
        modalInstance.result.then(function(response){
            // noinspection JSAnnotator
            //$scope.result = `${response} button hitted`;
            $scope.categoryId = categoryService.getId();
            $scope.categoryName = categoryService.getName();
            $scope.getAnnouncement($scope.categoryId);

        });

    };

    $scope.addAnnouncement = function () {

        UserCRUDService.addAnnouncement($scope.userId, $scope.categoryId, $scope.addTitle, $scope.addDescription, $scope.addPrice)
            .then (function success(response){
                    console.log("Dodano ogloszenie");
					$scope.error_message = "Dodawanie ogłoszenia";
                    $window.location.href = "added.html";
                },
                function error(response){
                    console.log("Nie udało się dodać ogłoszenia!");
                    $scope.error_message = 'Wystąpił błąd podczas dodawania ogłoszenia!';
                });

    };

    $scope.announcements = "";

    $scope.getAnnouncement = function (id) {
        if(id > 2) {
            UserCRUDService.getAnnouncement(id)
                .then(function success(response) {
                        $scope.announcements = response.data;
                        $scope.message = '';
                        $scope.errorMessage = '';
                        console.log("Pobrano ogłoszenia z kategorii " + id);
                    },
                    function error(response) {
                        $scope.message = '';
                        if (response.status === 404) {
                            $scope.errorMessage = 'User not found!';
                            console.log("Nie działa pobieranie ogłoszen z danej kategorii");
                        }
                        else {
                            $scope.errorMessage = "Error getting user!";
                            console.log("Nie działa pobieranie ogłoszen z danej kategorii");
                        }
                    });
        }else{
            UserCRUDService.getAnnouncements()
                .then(function success(response){
                        $scope.announcements = response.data;
                        console.log("Pobrano wszystkie ogłoszenia!");
                    },
                    function error (response){
                        $scope.message='';
                        console.log("Nie pobrano ogłoszen!");
                    });
        }
    }

    $scope.user = "";

    $scope.foo = function (userId){
        $scope.getUser(userId);
        $scope.user_name = $scope.user.name;
        $scope.user_lastname = $scope.user.lastname;
        console.log($scope.user_name);

    }

    $scope.getName = function (userId){
        //getUser(userId);
        $scope.userLocal = $scope.user;
        return $scope.userLocal.name + " " + $scope.userLocal.lastname;
    }

    $scope.getUser = function (id) {
        UserCRUDService.getUser(id)
            .then(function success(response){
                    $scope.user = response.data;
                    console.log("User found");
                    console.log($scope.user);
                },
                function error (response ){
                    $scope.message = '';
                    if (response.status === 404){
                        $scope.errorMessage = 'User not found!';
                        console.log("Cant find user");
                    }
                    else {
                        $scope.errorMessage = "Error getting user!";
                        console.log("Cant find user");
                    }
                });
    };

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
    //lista ogłoszen
    // $scope.announcements = [
    //     {
    //         "id": 0,
    //         "title": "Korepetycje z metod probabilistycznych",
    //         "user_id": 0,
    //         "user_name": "Jan",
    //         "user_lastname": "Kowalski",
    //         "price": 60,
    //         "description": "Dzień dobry. Oferuję korepetycje z metod probabilistycznych. Jestem studentem 4 roku 1 stopnia informatyki na wydziale elektrycznym. Zapraszma do kontaktu",
    //         "school": "Politechnika Poznańska"
    //     },
    //     {
    //         "id": 0,
    //         "title": "Korepetycje Java dla początkujących",
    //         "user_id": 1,
    //         "user_name": "Piotr",
    //         "user_lastname": "Śpiewak",
    //         "price": 55,
    //         "description": "Dzień dobry. Jestem studentem kierunku Informatyka na wydziale elektrycznym i chciałbym zaoferować moją pomoc w programowaniu Java. Jest to mój ulubiony język dlatego znam się na nim i chciałbym podzielić się swoją wiedzą z innymi. Zapraszam do kontaktu",
    //         "school": "Politechnika Poznańska"
    //     },
    //     {
    //         "id": 0,
    //         "title": "Korepetycje C++",
    //         "user_id": 2,
    //         "user_name": "Damian",
    //         "user_lastname": "Ementaler",
    //         "price": 40,
    //         "description": "Witam. Jestem specjalistą od programowania w języki C++, dlatego zapraszam na korepetycje. Mam talent do wyjaśniania trudnych zagadnień dlatego postanowiłem podzielić się swoimi umiejętnościami. Pozdrawiam.",
    //         "school": "Politechnika Poznańska"
    //     }
    // ];

}]);

app.controller('ModalContentCtrl', function($scope, $uibModalInstance, categoryService) {

    $scope.searchMode = "contains";
    $scope.treeViewOptions = {
        bindingOptions: {
            searchMode: "searchMode",
        },
        items: products,
        width: 300,
        searchEnabled: true,

        onItemClick: function(e) {
            var item = e.itemData;
            $scope.productDbId = item.db_id;
            $scope.productName = item.text;
            $scope.cat = item.db_id;
            $scope.categoryId = item.db_id;
            categoryService.setId($scope.categoryId);
            categoryService.setName($scope.productName);
        }
    };
    $scope.searchModeOptions = {
        bindingOptions: {
            value: "searchMode"
        },
        dataSource: ["contains", "startsWith"]
    }


    $scope.ok = function(){
        $uibModalInstance.close("Ok");
    }

    $scope.cancel = function(){
        $uibModalInstance.dismiss();
    }

});

app.service('categoryService', function() {
    var categoryId = 0;
    var categoryName = "";

    var setName = function(Name) {
        categoryName = Name;
    }

    var getName = function(){
        return categoryName;
    }

    var setId = function(Id) {
        categoryId = Id;
    }

    var getId = function(){
        return categoryId;
    }

    return {
        setId: setId,
        getId: getId,
        setName: setName,
        getName: getName
    };
});

app.service('UserCRUDService',['$http', function ($http) {

    this.addAnnouncement = function addAnnouncement(userId, categoryId, title, description, price){
        return $http({
            method: 'POST',
            url: 'api/announcements',
            data: {userId:userId, categoryId:categoryId, title:title, description:description, price:price}
        });
    }

    this.getAnnouncement = function getAnnouncement(announcementId){
        return $http({
            method: 'GET',
            url: './api/announcements/'+announcementId
        });
    }

    this.getUser = function getUser(userId){
        return $http({
            method: 'GET',
            url: './api/users/'+userId
        });
    }


    this.getAllUsers = function getAllUsers(){
        return $http({
            method: 'GET',
            url: 'api/users'
        });
    }
    this.getAnnouncements = function getAnnouncements(){
        return $http({
            method: 'GET',
            url: 'api/announcements'
        });
    }

}]);
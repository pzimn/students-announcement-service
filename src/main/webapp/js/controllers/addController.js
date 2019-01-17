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

}]);
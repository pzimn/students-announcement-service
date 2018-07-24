var DemoApp = angular.module('DemoApp', ['dx', 'app']);



DemoApp.controller('treeController', function DemoController($scope) {

    $scope.productDbId='';
    $scope.searchValue = "";
    $scope.productName = "",
        $scope.productPrice = "",
        $scope.productImage = "";

    $scope.treeViewOptions = {
        items: products,
        width: 300,
        onItemClick: function(e) {
            var item = e.itemData;
            $scope.productDbId = item.db_id;
            $scope.productName = item.text;
            $scope.cat = item.db_id;
            $scope.categoryId = item.db_id;

        }
    };
});
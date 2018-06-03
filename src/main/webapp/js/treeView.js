var DemoApp = angular.module('DemoApp', ['dx', 'app']);

DemoApp.controller('treeController', function DemoController($scope) {
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
        }
    };
});
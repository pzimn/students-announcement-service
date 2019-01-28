messagesApp.controller('messagesCtrl', function($scope, $http) {
    $scope.test = "Damiano";
    $scope.responseList = [
        {
            "name": "Damian",
            "lastname": "Michalski",
            "count": 12,
            "date": "10.10.19"
        },
        {
            "name": "Piotr",
            "lastname": "Zimny",
            "count": 2344,
            "date": "10.11.19"
        },
        {
            "name": "Mariusz",
            "lastname": "Nowakowski",
            "count": 444,
            "date": "11.02.19"
        },
        {
            "name": "Paweł",
            "lastname": "Nowak",
            "count": 764,
            "date": "12.03.19"
        },
        {
            "name": "Daniel",
            "lastname": "Kornacki",
            "count": 345,
            "date": "13.09.19"
        }
    ];

    //tutaj to zastąpi tamtą zmienną później. Podać adres do API
    // $http.get("api/messages/userid").then(function (response) {
    //     $scope.responseList = response;
    //     console.log("Response: " + response.size)
    // });
});
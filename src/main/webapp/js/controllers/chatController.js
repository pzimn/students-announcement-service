chatApp.controller('Shell', function($scope) {

    var vm = this;
    $scope.test = 'siema';
    vm.messages = [
        {
            'username': 'Mariusz',
            'content': 'Hi!'
        },
        {
            'username': 'Piotr',
            'content': 'Hello!'
        },
        {
            'username': 'Mariusz',
            'content': 'Książki!'
        },
        {
            'username': 'Piotr',
            'content': 'ooo!'
        },
        {
            'username': 'Mariusz',
            'content': 'jutro przyjde!'
        },
        {
            'username': 'Piotr',
            'content': 'bćbarośćbad o długa wiadomość!'
        }
    ];

    vm.username = 'Marcin';

    vm.sendMessage = function(message, username) {
        if(message && message !== '' && username) {
            vm.messages.push({
                'username': username,
                'content': message
            });
        }
    };

    vm.setDefaultValues = function(){

    };
    vm.visible = true;
    vm.expandOnNew = true;
});
chatApp.controller('Shell', function($scope) {

    var vm = this;

    vm.messages = [
        {
            'username': 'Mariusz Nowakowski',
            'content': 'Dzień dobry. Piszę w sprawie korepetycji z programowania w Javie. Kiedy możemy się spotkać?'
        },
        {
            'username': 'Ja',
            'content': 'Dzień dobry. Możemy spotykać się w każdą sobotę po godzinie 15. Czy pasuje Panu taki układ?'
        },
        {
            'username': 'Mariusz Nowakowski',
            'content': 'Tak, pasuje mi idealnie. Proszę o dalszy kontakt pod nr 609 598 345. Pozdrawiam'
        },
        {
            'username': 'Ja',
            'content': 'W takim razie odezwę się na podany numer w Piątek po południu w celu umówienia dokładnej godziny. Pozdrawiam'
        }
    ];

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
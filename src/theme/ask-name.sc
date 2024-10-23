#
require: name/name.sc
    module = sys.zb-common
require: text/text.sc
    module = sys.zb-common
theme: /AskName
    
    state:AskName
        q!:* (кек) *
        script:
            $session.stateCounterInARow = 0
        if:($client.name)
            go!:/AskPhone/AskPhone
        else:
            # if:(lastState !== /AskName/AskName/CatchAll)
            #     a:С параметрами заявки почти закончили! Осталось указать контакты, чтобы менеджер смог связаться с вами.
            a:Введите, пожалуйста, ваше имя.
            
        state:Name 
            q!: * меня зовут ($Name/$Text) *
            if:($parseTree._Name)
                script:
                    $session.name = $parseTree._Name.name;
                a: {{$session.name}} привет
            else:
                script:
                    $session.userName = capitalize($parseTree._Text);
                a:Вас действительно зовут {{$session.userName}} ?
                            
        state:CatchAll || noContext = true
            event: noMatch
            script:
                $session.stateCounterInARow += 1
            if:$session.stateCounterInARow < 2
                if:($request.query == "не знаю")
                    a:Мне жаль, но без указания вашего имени отправить заявку не получится. Укажите его, пожалуйста.
                else:
                    script:
                        $session.request = $request.query
                    go!:/AskName/UnusualName
                
    state:UnusualName
        a:- Как необычно! Подскажите, вы точно хотели указать в качестве своего имени "{{ $session.request }}"?
            
        
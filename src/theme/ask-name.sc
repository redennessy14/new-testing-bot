# require: /patterns/name-pattern.sc

theme: /AskName
    state:AskName
        
        if:($client.name)
            go!:/AskPhone/AskPhone
        else:
            # if:(lastState !== /AskName/AskName/CatchAll)
            #     a:С параметрами заявки почти закончили! Осталось указать контакты, чтобы менеджер смог связаться с вами.
            a:Введите, пожалуйста, ваше имя.
    
    state:Name 
        q!: * @pymorphy.name | меня зовут $Name  *
        script: 
            $session.name = capitalize($parseTree["_pymorphy.name"]) |  $session.userName = $parseTree._Name.name;
        if:($session.name)
            a: {{$session.name}} привет
        else:
            a:Вас действительно зовут {{$session.userName}} ?
       
    state:CatchAll || noContext = true
        
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
        q!: * @pymorphy.name *
        script: $session.name = capitalize($parseTree["_pymorphy.name"])
        if:($session.name)
            a: {{$session.name}} привет
        else:
            a:Вас действительно зовут {{capitalize($parseTree["_pymorphy.name"])}} ?
       
    state:CatchAll || noContext = true
        
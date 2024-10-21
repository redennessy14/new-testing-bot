theme: /AskName
    state:AskName
        
        if:($client.name)
            go!:/AskPhone/AskPhone
        else:
            if:(lastState !== /AskName/CatchAll
                a:С параметрами заявки почти закончили! Осталось указать контакты, чтобы менеджер смог связаться с вами.
            a:Введите, пожалуйста, ваше имя.
    
    state:Name 
        if:()
        else:
        go!:/AskPhone/AskPhone
        
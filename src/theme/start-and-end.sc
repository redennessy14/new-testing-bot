theme: /StartAndEnd
    
    state: Start
        q!: $regex</start>
        script:
            $temp.botName = capitalize($injector.botName)
        if:($client.name)
            random:
                a:- {{ $client.name }}, здравствуйте! {{$temp.botName}} из Just Tour на связи. Рад снова видеть вас в чате!
                a:- {{ $client.name }}, приветствую! На связи {{$temp.botName}} из Just Tour, лучшей в мире туристической компании. Рад снова пообщаться с вами!

        else:
            random:
                a:- Здравствуйте! Меня зовут {{$temp.botName}}, бот-помощник компании Just Tour. Расскажу все о погоде в городах мира и помогу с оформлением заявки на подбор тура.
                a:- Приветствую вас! Я {{$temp.botName}}, работаю виртуальным ассистентом в Just Tour, лучшем туристическом агентстве. Проинформирую вас о погоде в разных городах и соберу все необходимые данные для запроса на подбор путевки
        go!:/StartAndEnd/HowCanIHelpYou
        
        
    state:DontHaveQuestions
        q!:* (нету вопросов) *
        random: 
            a:- Вас понял!
            a:- Хорошо!
            a:- Понял!
        go!:/GeneralStates/Goodbye
        
    state: HowCanIHelpYou
        random:
            a:- Чем могу помочь?
            a:- Что вас интересует?
            a:- Подскажите, какой у вас вопрос?
        buttons:
            "🌤️ Узнать прогноз погоды"
            "📝 Оформить заявку на подбор тура"
            
        state:CatchAll ||noContext = true
            event: noMatch
            script:
                $temp.stateCounterInARow += 1
            a: счетчик{{ $temp.stateCounterInARow }}
            if:($temp.stateCounterInARow < 3) 
                random: 
                    a: Извините, не совсем понял. Пожалуйста, подскажите, могу ли я чем-то вам помочь?
                    a: К сожалению, не смог понять, что вы имеете в виду. Подскажите, что вас интересует?
            else:
                a:Кажется, этот вопрос не в моей компетенции. Но я постоянно учусь новому, и, надеюсь, совсем скоро научусь отвечать и на него.
                go!:/StartAndEnd/SomethingElse
                
    state: SomethingElse
        random:
            a:- Хотите спросить что-то еще?
            a:- Могу ли я помочь чем-то еще?
            a:- Подскажите, у вас остались еще вопросы?
        buttons:
            "🌤️ Узнать прогноз погоды"
            "📝 Оформить заявку на подбор тура" 
            
        state:CatchAll || noContext = true
            

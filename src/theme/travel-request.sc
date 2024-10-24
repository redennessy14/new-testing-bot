
theme: /TravelRequest
    state:TravelRequest
        script: 
            $session.stateCounterInARow = 0 
        random:
            a:- Готов помочь вам оформить заявку на подбор тура. Как только я соберу от вас нужные для запроса данные, наш менеджер подберет самые подходящие варианты и свяжется с вами.
            a:- Рад помочь с оформлением запроса на подбор тура. Как только мы заполним заявку, наш специалист свяжется с вами, чтобы предложить наиболее подходящие варианты путешествий.
        if:($session.country)
            go!:/TravelRequest/AskNumberOfPeople
        else:
            a:Подскажите, вы уже определились с страной прибытия?
            
        state:Agree
            q:*($yes/$City)*
            if:($parseTree._City)
                script:
                    $session.country = $parseTree._City.name;
                    
                a:Отлично, я передам консультанту, что местом пребывания станет {{ $session.country }}. А теперь давайте перейдем к указанию оставшихся параметров.
                go!:/TravelRequest/AskNumberOfPeople
            else:
                a:Введите название страны.
                
            state:Country
                q:$City
                script:
                    $session.country = $parseTree._City.name;
                a:Отлично, я передам консультанту, что местом пребывания станет {{ $session.country }}. А теперь давайте перейдем к указанию оставшихся параметров.
                go!:/TravelRequest/AskNumberOfPeople
            
            state: CatchAll || noContext = true
                event: noMatch 
                script:
                    $session.stateCounterInARow += 1
                if:$session.stateCounterInARow < 3
                    random:
                        a:- Извините, не совсем понял вас. Назовите, пожалуйста, нужную вам страну.
                        a:- К сожалению, не понял вас. Введите название страны для поездки.
                else:
                    script:
                        $session.countre = "Не указано"
                    a:Простите! Так и не получилось вас понять. Когда консультант получит заявку, он подберет варианты стран для вас. А теперь давайте перейдем к указанию оставшихся параметров.
                    go!:/TravelRequest/AskNumberOfPeople
        state:Disagree
            q:* $no *
            script: 
                $session.countre = "Не указано"
            a:Понял вас. В таком случае, когда консультант получит заявку, он подберет варианты стран для вас. А теперь давайте перейдем к указанию оставшихся параметров.
            go!: /TravelRequest/AskNumberOfPeople
            
        state:CatchAll ||noContext = true
            event: noMatch
            script:
                $session.stateCounterInARow += 1
            if:$session.stateCounterInARow < 3
                random:
                    a:- Извините, не совсем понял вас. Подскажите, вы выбрали страну для путешествия?
                    a:- К сожалению, не понял вас. Вы выбрали страну для поездки?
                # toState!:/TravelRequest/TravelRequest
            else:
                script:
                    $session.country = "Не указано"
                a:Простите! Так и не получилось вас понять. Когда консультант получит заявку, он подберет варианты стран для вас. А теперь давайте перейдем к указанию оставшихся параметров.
                go!:/TravelRequest/AskNumberOfPeople
            
            
    state:AskNumberOfPeople
        a:Укажите количество человек, которые отправятся в путешествие.
        script:
            $session.stateCounterInARow = 0 
            
        state:Number
            q:*  $Number *
            script: 
                $session.numberOfPeople = $parseTree._Number
            go!:/TravelRequest/AskStartData
            
        state:DontKnow
            q:$dontKnow
            script:
                $session.numberOfPeople = "Не указано"
            go!:/TravelRequest/AskStartData
            
        state:CatchAll ||noContext = true
            event: noMatch 
            script:
                $session.stateCounterInARow += 1
            if:$session.stateCounterInARow < 3
                if: $Number < $NumberZero
                    a:К сожалению, не могу принять такой ответ. Пожалуйста, введите валидное число людей - оно должно быть больше 0.
                else:
                    random:
                        a:- Извините, не совсем понял вас. Сколько человек планирует отправиться в поездку?
                        a:- К сожалению, не понял вас. Сколько человек поедет в тур?
            else:
                go!:/TravelRequest/AskNumberOfPeople/DontKnow
                
                
    state:AskStartData
        a:Еще мне потребуется предполагаемая дата начала поездки. Пожалуйста, напишите ее.
        
        state:Date
        q:
        
        state:DontKnow
            
        state:CatchAll || noContext = true
            event: noMatch
        


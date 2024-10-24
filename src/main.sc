require: slotfilling/slotFilling.sc
  module = sys.zb-common
require:index.sc

theme: /GeneralStates
            
    state:AreYouRobot
        q!:*(кто/робот*/бот*)*
        random:
            a:- Я Артур — бот-помощник компании Just Tour, всегда готов отвечать на ваши вопросы.
            a:- Вы общаетесь с Артуром — чат-ботом, разработанным командой Just Tour, чтобы помогать вам. Всегда рад пообщаться с вами!
                
        
    state:WhatCanYouDo
        q!:*(уме*)
        random:
            a:- Умею рассказывать о погоде в городах мира и составлять заявки на подбор подходящего именно вам путешествия.
            a:- С удовольствием расскажу вам о ближайших метеопрогнозах для разных городов и помогу составить запрос на подбор тура.
        go!:/StartAndEnd/SomethingElse
        
    state: Match
        event!: match
        a: {{$context.intent.answer}}
        
    state: NoMatch 
        event!: noMatch
        random:  
         a: Извините я вас не понял  , не могли ли вы уточнить вопрос ? 
         a: К сожелению , я вас не понял давайте уточним вопрос ?
         a: На этот вопрос у меня нету ответа переформулируйте свой вопрос 
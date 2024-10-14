require: slotfilling/slotFilling.sc
  module = sys.zb-common
theme: /

    state: Start
        q!: $regex</start>
        a: Начнём.

    state: Hello
        intent!: /привет
        a: Привет привет

    state: Bye
        intent!: /пока
        a: Пока пока


    state: Match
        event!: match
        a: {{$context.intent.answer}}

    state: Weather
        intent!: /какая сегодня погода ?
        a: Сегодня прохладно !


theme : /CatchAll  
    state: NoMatch
        event!: noMatch
   random :  
        a: Извините я вас не понял  , не могли ли вы уточнить вопрос ? 
        a: К сожелению , я вас не понял давайте уточним вопрос ?
        a: На этот вопрос у меня нету ответа переформулируйте свой вопрос 
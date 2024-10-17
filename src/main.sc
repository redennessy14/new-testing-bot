require: slotfilling/slotFilling.sc
  module = sys.zb-common
require:index.sc

theme: /

    # state: Hello
    #     intent!: /привет
    #     q!: * $hello *
    #     a: Привет
        
    # state: Bye
    #     intent!: /пока
    #     a: Пока пока


    state: Match
        event!: match
        a: {{$context.intent.answer}}
        
    state: NoMatch
        event!: noMatch
        random:  
         a: Извините я вас не понял  , не могли ли вы уточнить вопрос ? 
         a: К сожелению , я вас не понял давайте уточним вопрос ?
         a: На этот вопрос у меня нету ответа переформулируйте свой вопрос 
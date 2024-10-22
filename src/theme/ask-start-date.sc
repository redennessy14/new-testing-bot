theme: /AskStartDate
    
    state:AskStartDate
        a:Еще мне потребуется предполагаемая дата начала поездки. Пожалуйста, напишите ее.
        
        state:Date
            go!:/AskDuration/AskDuration
            
        state:DontKnow
            
        state:CatchAll ||noContext = true

theme: /AskNumberOfPeople
    
    state:AskNumberOfPeople
        a:Укажите количество человек, которые отправятся в путешествие.
        
        
        
        state:Number
            go!:/AskStartDate/AskStartDate
            
            
        state:DontKnow
            
            go!://AskStartDate/AskStartDate
            
        state:CatchAll ||noContext = true
            
            
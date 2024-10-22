theme: /AskDuration 
    
    
    
    state:AskDuration 
        a:Также укажите, сколько дней будет длиться путешествие.
        
        state:Number
            go!:/AskService/AskService
            
        state:DontKnow
            
            
        state:CatchAll

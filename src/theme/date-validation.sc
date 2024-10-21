theme: /DateValidation
    
    state:GetDate
        random:
            a:- На какую дату требуется прогноз?
            a:- Прогноз погоды на какую дату вам нужен?
            
            state:UserDate
                go!:/CheckDate
            state:CatchAll
    
    state:CheckDate
        
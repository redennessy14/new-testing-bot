theme: /AskService 
    
    state:AskService 
        a:Уточните, пожалуйста, какой пакет услуг вам интересен?
        buttons:
           "🏷️ Эконом"
           "🏨 Стандарт"
           "👑 VIP"
           
           
    state:Package
        q!:* ($economy/$standart/$vip) *
       
        script: 
            $session.services = getPackage($parseTree)
        go!:/AskName/
      
            
    state:WhatIsIncluded
        # q!:* ($economy/$standart/$vip) *
        a:Ру
        if:($session.service)
            a:В пакет услуг "{{$session.services}}" входят следующие опции: [Входящие в него услуги - 1], [Входящие в него услуги - 2], ... [Входящие в него услуги - N].
            
    state:Price
        
            
                   
    state:CatchAll ||noContext = true
        
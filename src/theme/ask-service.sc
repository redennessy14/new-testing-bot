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
                $session.services = "эконом"
            a:ващ {{$session.services}} 
                   
                   
    state:CatchAll ||noContext = true
        
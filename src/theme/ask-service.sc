theme: /AskService 
    
    state:AskService 
        a:Уточните, пожалуйста, какой пакет услуг вам интересен?
        buttons:
           "🏷️ Эконом"
           "🏨 Стандарт"
           "👑 VIP"
           state:Package
               q!:(эконом*/стандарт*/vip)
               
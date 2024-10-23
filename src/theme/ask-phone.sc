theme: /AskPhone
    
    state:AskPhone
        if:$client.phone 
            go!:
        else:
            a:Укажите номер телефона для связи.
            
            
        state:Phone
            q!: * (мой номер) *
            script:
                $client.phone
            
            
        state:CatchAll ||noContext = true
            
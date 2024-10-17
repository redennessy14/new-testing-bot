theme: /Pizza 
    state:PizzaOrder ||modal = true
        q!:Хочу заказать пиццу 
        a:Какую пиццу вы хотите заказать ? 
        buttons:
            "Маргарита"
            "Пепперони"
            "Мексиканская"
            
        state:ChoosePizza
                q!:*(маргарит*)*
                go!: /HowManyPizza
                
        state:LocalCatchAll
            event: noMatch
            a:Такой пиццы нету , выберите из списка 
            go!:..
    state:HowManyPizza
        a:Сколько пиццы вы хотите заказать?
 
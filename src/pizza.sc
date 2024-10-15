theme:/Pizza
    state:PizzaOrder || modal = true
    q!:Хочу заказать пиццу 
    a: Какую пиццу вы хотите заказать? 
    buttons:
    "Маргарита"
    "Пепперони"
    "Мексиканская"

    state:ChoosePizza
    q!: * (маргарит*) *
    q!: * (пепперон*/переон*) *
    q!: * (мексиканск*)*
    go!: /HowManyPizza


    state:HowManyPizza
    a!:Сколько нужно будет пиццы ?
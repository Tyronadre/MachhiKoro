package com.henrik.model.cards.types;

import com.henrik.model.cards.Card;

public abstract class Blue extends Card{

    public Blue(int cost) {
        super(cost);
    }

    public ActivationType getActivationType(){
        return ActivationType.IMMER;
    }

}

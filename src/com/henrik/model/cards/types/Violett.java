package com.henrik.model.cards.types;

import com.henrik.model.cards.Card;

public abstract class Violett extends Card {

    public Violett(int cost) {
        super(cost);
    }

    public ActivationType getActivationType(){
        return ActivationType.SELBER;
    }
}

package com.henrik.model.cards.types;

import com.henrik.model.cards.Card;

public abstract class Green extends Card {
    public Green(int cost) {
        super(cost);
    }

    public ActivationType getActivationType(){
        return ActivationType.SELBER;
    }
}

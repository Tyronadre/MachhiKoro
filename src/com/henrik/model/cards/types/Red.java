package com.henrik.model.cards.types;

import com.henrik.model.cards.Card;

public abstract class Red extends Card {

    public Red(int cost) {
        super(cost);
    }

    public ActivationType getActivationType(){
        return ActivationType.GEGNER;
    }
}

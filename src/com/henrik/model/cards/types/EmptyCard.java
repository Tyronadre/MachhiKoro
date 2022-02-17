package com.henrik.model.cards.types;

import com.henrik.model.Player;
import com.henrik.model.cards.Card;
import com.henrik.model.cards.CardType;

public class EmptyCard extends Card {
    public EmptyCard() {
        super(Integer.MAX_VALUE);
    }

    @Override
    public ActivationType getActivationType() {
        return null;
    }

    @Override
    public void consume(Player owner) {
        throw new UnsupportedOperationException();
    }

    @Override
    public CardType getCardType() {
        return CardType.EMPTY;
    }

    @Override
    public boolean isEmpty() {
        return true;
    }
}

package com.henrik.model.cards.types;

import com.henrik.model.Player;
import com.henrik.model.cards.Card;
import com.henrik.model.cards.CardType;

public class Moebelfabrik extends Green{
    public Moebelfabrik() {
        super(3);
    }

    @Override
    public void consume(Player owner) {
        owner.getCards().stream().filter(Card::isWorkingPlace).forEach(card -> owner.addCoins(3));
    }

    @Override
    public CardType getCardType() {
        return CardType.MOEBELFABRIK;
    }


    @Override
    public boolean isFabrik() {
        return true;
    }
}

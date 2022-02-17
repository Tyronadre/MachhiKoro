package com.henrik.model.cards.types;

import com.henrik.model.Player;
import com.henrik.model.cards.Card;
import com.henrik.model.cards.CardType;

public class Molkerei extends Green{

    public Molkerei() {
        super(5);
    }

    @Override
    public void consume(Player owner) {
        owner.getCards().stream().filter(Card::isTierFarm).forEach(card -> owner.addCoins(3));
    }

    @Override
    public CardType getCardType() {
        return CardType.MOLKEREI;
    }


    @Override
    public boolean isFabrik() {
        return true;
    }
}

package com.henrik.model.cards.types;

import com.henrik.model.Player;
import com.henrik.model.cards.Card;
import com.henrik.model.cards.CardType;

public class Markthalle extends Green {

    public Markthalle() {
        super(2);
    }

    @Override
    public void consume(Player owner) {
        owner.getCards().stream().filter(Card::isPflanzenFarm).forEach(card -> owner.addCoins(2));
    }

    @Override
    public CardType getCardType() {
        return CardType.MARKTHALLE;
    }


    @Override
    public boolean isShop() {
        return true;
    }
}

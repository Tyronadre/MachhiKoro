package com.henrik.model.cards.types;

import com.henrik.model.Player;
import com.henrik.model.cards.Card;
import com.henrik.model.cards.CardType;

public class Stadion extends Violett {

    public Stadion() {
        super(6);
    }

    @Override
    public void consume(Player owner) {
        if (controller.getDice() == 6)
            for(Player player: controller.getOtherPlayers()){
                owner.addCoins(player.removeCoins(2));
            }

    }

    @Override
    public CardType getCardType() {
        return CardType.STADION;
    }


    @Override
    public boolean isBuilding() {
        return true;
    }
}

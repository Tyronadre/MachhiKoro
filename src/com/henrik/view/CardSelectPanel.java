package com.henrik.view;

import com.henrik.controller.Controller;
import com.henrik.model.Player;
import com.henrik.model.cards.Card;
import com.henrik.model.cards.CardType;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;

public class CardSelectPanel extends JPanel {

    Controller controller = Controller.getController();
    private java.util.List<CardButton> buttons = new ArrayList<>();

    public CardSelectPanel() {

        this.setSize(1000,1000);
        this.setLayout(new GridLayout(3,3));

        fillGrid();
    }


    private void fillGrid() {

        addCard(controller.drawCard());

        while (buttons.size() < 9) addCard(controller.drawCard());

    }

    private void addCard(Card card) {

        if (card == null) {
            CardButton button = new CardButton(null);
            add(button);
            buttons.add(button);
            return;
        }

        CardButton button = buttons.stream().filter(cardButton -> card.getCardType().equals(cardButton.getCardType())).findAny().orElse(null);

        if (button != null) {
            button.addCard(card);
        } else {
            button = createButton(card);
            add(button);

        }


    }

    private CardButton createButton(Card card) {
        CardButton button = new CardButton(card);

        button.addActionListener(e -> {

            Player player = controller.getCurrentPlayer();

            if (player.getCoins() >= card.getCost()) {
                player.addCard(card);
                player.removeCoins(card.getCost());
                remove(button);
            }
        });

        buttons.add(button);

        return button;
    }

    private class CardButton extends JButton {

        java.util.List<Card> cards = new ArrayList<>();
        CardType cardType;
        JLabel jLabel = new JLabel();

        public CardButton(Card card) {
            if (card == null) return;
            setLayout(new BorderLayout());
            cardType = card.getCardType();
            add(jLabel, BorderLayout.NORTH);
            addCard(card);
        }

        public Card removeCard() {
            Card card = cards.remove(cards.size() - 1);
            if (cards.isEmpty()) buttons.remove(this);
            return card;
        }

        public void addCard(Card card) {
            if (!card.getCardType().equals(cardType)) throw new IllegalArgumentException("card parameter has wrong type");
            cards.add(card);
            jLabel.setText(cards.get(0).getName() + ", " + cards.size());
        }

        public CardType getCardType() {
            return cardType;
        }
    }

}

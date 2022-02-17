package com.henrik.view;

import com.henrik.controller.CardHelper;
import com.henrik.controller.Controller;
import com.henrik.model.cards.Card;
import com.henrik.model.cards.CardType;
import com.henrik.view.actionListeners.BuyCard;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class CardSelectPanel extends JPanel {

    Controller controller = Controller.getController();
    private final java.util.List<CardButton> cardButtons = new ArrayList<>();
    int numberOfCards;

    public CardSelectPanel(int numberOfCards) {
        this.numberOfCards = numberOfCards;
        this.setSize(CardHelper.getWidth() * numberOfCards / 2, CardHelper.getHeight() * 2);
        this.setLayout(new GridLayout(2, numberOfCards/2));
        while (cardButtons.size() < numberOfCards) drawCard(controller.drawCard());

    }

    private void drawCard(Card card) {
        //TODO Wenn alle schon null sind
        if (card == null) {
            CardButton cardButton = new CardButton(null);
            add(cardButton);
            cardButtons.add(cardButton);
            return;
        }

        CardButton existingCardButton = cardButtons.stream().filter(cardButton -> card.getCardType().equals(cardButton.getCardType())).findAny().orElse(null);

        if (existingCardButton != null) {
            existingCardButton.addCard(card);
        } else {
            existingCardButton = createButton(card);
            add(existingCardButton);
        }
    }

    private void removeButton(CardButton cardButton){
        cardButtons.remove(cardButton);
        remove(cardButton);
        this.revalidate();
        this.repaint();
        System.out.println(this.cardButtons.size());
    }

    private CardButton createButton(Card card) {
        CardButton button = new CardButton(card);

        button.addActionListener(e -> {
            if (controller.getCurrentPlayer().getCoins() >= card.getCost()) {
                controller.getCurrentPlayer().removeCoins(card.getCost());
                controller.getCurrentPlayer().addCard(button.removeCard());
                for (var temp:cardButtons){
                    System.out.println(temp.count.getText());
                }
            }
        });
        cardButtons.add(button);
        return button;
    }

    private class CardButton extends JButton {
        java.util.List<Card> cards = new ArrayList<>();
        CardType cardType;
        JLabel count = new JLabel();

        public CardButton(Card card) {
            if (card == null) {
                cardType = CardType.EMPTY;
                return;
            }
            cardType = card.getCardType();
            add(count, BorderLayout.NORTH);
            addCard(card);
        }

        public Card removeCard() {
            Card card = cards.remove(cards.size() - 1);
            if (cards.isEmpty()) {
                removeButton(this);
                //RESTOCK
                while (cardButtons.size() < numberOfCards && controller.hasDrawCard())
                    drawCard(controller.drawCard());
                return card;
            }
            count.setText(cards.get(0).getName() + ", " + cards.size());
            return card;
        }

        public void addCard(Card card) {
            if (!card.getCardType().equals(cardType))
                throw new IllegalArgumentException("card parameter has wrong type");
            cards.add(card);
            count.setText(cards.get(0).getName() + ", " + cards.size());
        }

        public CardType getCardType() {
            return cardType;
        }
    }

}

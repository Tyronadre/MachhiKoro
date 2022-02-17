package com.henrik.view;

import com.henrik.controller.CardHelper;
import com.henrik.controller.Controller;
import com.henrik.model.cards.Card;
import com.henrik.model.cards.CardType;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class CardSelectPanel extends JPanel {

    private final java.util.List<CardButton> cardButtons = new ArrayList<>();
    Controller controller = Controller.getController();
    int numberOfCards;
    int lastDeletedPos = -1;

    public CardSelectPanel(int numberOfCards) {
        this.numberOfCards = numberOfCards;
        this.setSize(CardHelper.getWidth() * numberOfCards / 2, CardHelper.getHeight() * 2);
        this.setLayout(new GridLayout(2, numberOfCards / 2));
        while (cardButtons.size() < numberOfCards) drawCard(controller.drawCard());

    }

    private void drawCard(Card card) {
        if (card.getCardType().equals(CardType.EMPTY)) {
            CardButton cardButton = new CardButton(card);
            cardButtons.add(lastDeletedPos, cardButton);
            repaintGrid();
            return;
        }

        CardButton existingCardButton = cardButtons.stream().filter(cardButton -> card.getCardType().equals(cardButton.getCardType())).findAny().orElse(null);

        if (existingCardButton != null) {
            existingCardButton.addCard(card);
        } else {
            existingCardButton = createButton(card);
            add(existingCardButton);
        }
        repaintGrid();
    }

    private void repaintGrid() {
        this.removeAll();
        for (CardButton cardButton : cardButtons)
            this.add(cardButton);
        revalidate();
    }

    private CardButton createButton(Card card) {
        CardButton button = new CardButton(card);

        button.addActionListener(e -> {
            if (controller.getCurrentPlayer().getCoins() >= card.getCost()) {
                controller.getCurrentPlayer().removeCoins(card.getCost());
                controller.getCurrentPlayer().addCard(button.removeCard());
            }
        });
        if (lastDeletedPos != -1)
            cardButtons.add(lastDeletedPos, button);
        else
            cardButtons.add(button);
        return button;
    }

    private class CardButton extends JButton {
        java.util.List<Card> cards = new ArrayList<>();
        CardType cardType;
        JLabel count = new JLabel();
        ImageIcon image;

        public CardButton(Card card) {
            super(ResourceHandler.getCardImage(card.getCardType()));
            if (card.isEmpty()) {
                setEnabled(false);
            }

            cardType = card.getCardType();
            this.addCard(card);
            this.add(count, BorderLayout.EAST);
        }

        public Card removeCard() {
            Card card = cards.remove(cards.size() - 1);
            if (cards.isEmpty()) {
                lastDeletedPos = cardButtons.indexOf(this);
                cardButtons.remove(this);
                //RESTOCK
                while (cardButtons.size() < numberOfCards)
                    drawCard(controller.drawCard());

                return card;
            }
            count.setText(String.valueOf(cards.size()));
            return card;
        }

        public void addCard(Card card) {
            if (!card.getCardType().equals(cardType))
                throw new IllegalArgumentException("card parameter has wrong type");
            cards.add(card);
            if (card.isEmpty())
                count.setText("");
            else
                count.setText(String.valueOf(cards.size()));
        }

        public CardType getCardType() {
            return cardType;
        }
    }

}

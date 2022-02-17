package com.henrik.controller;

import com.henrik.model.Player;
import com.henrik.model.cards.Card;
import com.henrik.model.cards.Monuments;
import com.henrik.model.cards.types.Red;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Controller {

    private Player currentPlayer;
    private Player actOnPlayer;
    private List<Player> players = null;
    private List<Card> cardStack;
    private ControllerState state;
    private List<Integer> diceResults;

    private static final Controller instance = new Controller();

    private Controller() {
    }

    public static Controller getController() {
        return instance;
    }

    public void init(int playerCount) {
        initCards();
        initDice();
        
        state = ControllerState.PLAYER_SELECT;

        //TODO implement player selection
        acceptPlayerSelect(PlayerHelper.getInitPlayers(4));
        state = ControllerState.CHOOSE_DICE_AMOUNT;
       // play();
    }
    
    private void initCards() {
        cardStack = CardHelper.getInitStack();
    }

    private void initDice() {
        diceResults = new ArrayList<>();
        diceResults.add(null);
        diceResults.add(null);
    }
    
    public void play() {

        while (true) {

            if (state == ControllerState.CHOOSE_DICE_AMOUNT) {
                if (!currentPlayer.hasMonument(Monuments.Monument.BAHNHOF)) {
                    rollDice(1);
                }
            }
            else if (state == ControllerState.DISTRIBUT_MONEY) {
                distributeMoney();
            }

            if (checkForWin()) {
                state = ControllerState.PLAYER_WON;
                break;
            }
        }
    }

    public void acceptPlayerSelect(List<Player> players) {
        if (players.size() < 2) {
            //TODO show error Frame
            return;
        }

        Collections.shuffle(players);
        this.players = players;
        currentPlayer = players.get(0);
        state = ControllerState.CHOOSE_DICE_AMOUNT;
    }

    public boolean acceptCardChosen(Card card) {
        if (currentPlayer.getCoins() >= card.getCost()) {
            currentPlayer.removeCoins(card.getCost());
            currentPlayer.addCard(card);
            nextTurn();
            return true;
        }
        return false;
    }

    public void nextTurn() {
        state = ControllerState.CHOOSE_DICE_AMOUNT;
        currentPlayer = players.indexOf(currentPlayer) == players.size() - 1 ? players.get(0) : players.get(players.indexOf(currentPlayer) + 1);
    }

    public void distributeMoney() {
        int currentPlayerIndex = players.indexOf(currentPlayer);
        for (int i = currentPlayerIndex - 1; i != currentPlayerIndex; i--) {
            if (i < 0) i = players.size() - 1;

            for (Card Card : players.get(i).getCards().stream().filter(card -> card instanceof Red).collect(Collectors.toList())) {
                drawCard().consume(players.get(i));
            }
        }

        for (Card card : currentPlayer.getCards()) {
            card.consume(currentPlayer);
        }

        if (currentPlayer.getCoins() == 0) currentPlayer.addCoins(1);

        state = ControllerState.CHOOSE_CARD;
    }

    public boolean checkForWin() {
        return currentPlayer.getAllMonuments().size() == Monuments.Monument.values().length;
    }

    public Card drawCard() {
        return cardStack.isEmpty() ? null : cardStack.remove(0);
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public Player getActOnPlayer() {
        return actOnPlayer;
    }

    public List<Player> getOtherPlayers() {
        return players.stream().filter(player -> player != currentPlayer).collect(Collectors.toList());
    }

    public List<Player> getAllPlayers() {
        return players;
    }

    public void rollDice(int amount) {
        Random random = new Random();
        diceResults.clear();
        diceResults.add(random.nextInt(6) + 1);
        diceResults.add(amount == 1 ? null : random.nextInt(6) + 1);
        state = ControllerState.DISTRIBUT_MONEY;
    }

    public int getDice() {
        Integer first = diceResults.get(0);
        Integer second = diceResults.get(1);

        if (first == null && second == null) return -1;
        if (first != null && second != null) return first + second;
        if (first != null) return first;
        else return second;
    }

    public ControllerState getState() {
        return state;
    }

    public boolean hasDrawCard() {
        return cardStack.size() > 0;
    }

    public enum ControllerState {
        CHOOSE_CARD,
        CHOOSE_DICE_AMOUNT,
        PLAYER_SELECT,
        PLAYER_WON,
        DISTRIBUT_MONEY
    }
}

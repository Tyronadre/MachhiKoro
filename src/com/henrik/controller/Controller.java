package com.henrik.controller;

import com.henrik.model.Player;
import com.henrik.model.cards.Card;

import java.util.List;
import java.util.stream.Collectors;

public class Controller {

    private Player currentPlayer;
    private Player actOnPlayer;
    private List<Player> players = null;
    private List<Card> cardStack;

    private static final Controller instance = new Controller();

    private Controller() {
    }

    public static Controller getController() {
        return instance;
    }

    public void init(int playerCount) {
        cardStack = CardHelper.getInitStack();
        players = PlayerHelper.getInitPlayers(playerCount);
        play(players.get(0));
    }

    public void play(Player player) {
        currentPlayer = player;
        //SPIELEN
        //play(players.get(players.indexOf(player) + 1 == players.size()? 0 : players.indexOf(player) + 1));
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

    public int getDice() {
        return -1;
    }
}

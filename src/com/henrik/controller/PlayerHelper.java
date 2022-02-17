package com.henrik.controller;

import com.henrik.model.Player;

import java.util.ArrayList;
import java.util.List;

public class PlayerHelper {

    public static List<Player> getInitPlayers(int count){
        List<Player> playerList = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            playerList.add(new Player(String.valueOf(i)));
        }
        return playerList;
    }


}

package com.henrik.view;

import com.henrik.controller.Controller;
import com.henrik.model.Player;
import com.henrik.model.cards.Card;

import javax.swing.*;
import java.util.List;

public class PlayerView extends JPanel {
    Controller controller = Controller.getController();
    List<Player> players;

    public PlayerView(){
        players = controller.getAllPlayers();

    }



}

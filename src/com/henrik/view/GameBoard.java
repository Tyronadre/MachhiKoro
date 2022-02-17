package com.henrik.view;

import com.henrik.controller.Controller;
import com.henrik.model.Player;
import com.henrik.model.cards.CardType;
import com.henrik.view.components.CardSelectPanel;
import com.henrik.view.components.DraggableCard;
import com.henrik.view.components.PlayerView;

import javax.swing.*;
import java.awt.*;

public class GameBoard extends JPanel {

    public GameBoard()  {
        CardSelectPanel cardSelectPanel = new CardSelectPanel(10);
        this.setSize(Toolkit.getDefaultToolkit().getScreenSize());
        // add(new DraggableCard(CardType.EMPTY));

        add(cardSelectPanel);
        for (Player player : Controller.getController().getAllPlayers())
            add(new PlayerView(player));
    }
}

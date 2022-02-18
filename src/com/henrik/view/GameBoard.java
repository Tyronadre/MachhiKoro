package com.henrik.view;

import com.henrik.controller.Controller;
import com.henrik.model.Player;
import com.henrik.view.components.CardSelectPanel;
import com.henrik.view.components.PlayerView;

import javax.swing.*;
import java.awt.*;

public class GameBoard extends View {

    public GameBoard() {

        CardSelectPanel cardSelectPanel = new CardSelectPanel(10);
        this.setSize(Toolkit.getDefaultToolkit().getScreenSize());
        // add(new DraggableCard(CardType.EMPTY));
        this.setLayout(new BorderLayout());

        JPanel topRow = new JPanel();
        JPanel bottomRow = new JPanel();
        topRow.setSize(this.getWidth(),300);
        bottomRow.setSize(this.getWidth(),300);
        topRow.setLayout(new GridLayout(1, 3));
        bottomRow.setLayout(new GridLayout(1, 3));
        int count = 0;
        for (Player player : Controller.getController().getAllPlayers()) {
            if (count % 2 == 0)
                bottomRow.add(new PlayerView(player));
            else
                topRow.add(new PlayerView(player));
            count++;
        }
        this.add(topRow,BorderLayout.NORTH);
        this.add(cardSelectPanel, BorderLayout.CENTER);
        this.add(bottomRow,BorderLayout.SOUTH);

    }
}

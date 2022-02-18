package com.henrik.view;

import com.henrik.controller.Controller;
import com.henrik.model.Player;
import com.henrik.view.components.CardSelectPanel;
import com.henrik.view.components.PlayerView;
import com.henrik.view.components.StickyRow;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class GameBoard extends View {
    java.util.List<PlayerView> playerViewList = new ArrayList<>();

    public GameBoard() {

        CardSelectPanel cardSelectPanel = new CardSelectPanel(10,this);
        this.setSize(Toolkit.getDefaultToolkit().getScreenSize());
        // add(new DraggableCard(CardType.EMPTY));

        JPanel topRow = new StickyRow(new Dimension(this.getWidth(),300));
        JPanel bottomRow = new StickyRow(new Dimension(this.getWidth(),300));
        int count = 0;
        for (Player player : Controller.getController().getAllPlayers()) {
            PlayerView playerView = new PlayerView(player);
            playerViewList.add(playerView);
            if (count % 2 == 0)
                bottomRow.add(playerView);
            else
                topRow.add(playerView);
            count++;
        }
        System.out.println(count);
        System.out.println(Controller.getController().getAllPlayers().size());
        this.add(topRow,BorderLayout.NORTH);
        this.add(cardSelectPanel,BorderLayout.CENTER);
        this.add(bottomRow,BorderLayout.SOUTH);

    }

    public void updateGUI() {
        for(var playerView: playerViewList){
            playerView.updateView();
        }
    }
}

package com.henrik.view;

import com.henrik.controller.Controller;
import com.henrik.model.Player;
import com.henrik.model.cards.CardType;
import com.henrik.view.components.CardSelectPanel;
import com.henrik.view.components.DraggableCard;
import com.henrik.view.components.PlayerView;

import javax.swing.*;
import java.awt.*;

public class MainView extends JFrame {
    JPanel activePanel = new JPanel();

    private static final MainView instance = new MainView();

    private MainView() {

    }

    public void init (){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setMinimumSize(new Dimension(800,600));
        this.setActiveView(new GameBoard());
        this.setVisible(true);
    }

    public static MainView getMainView() {
        return instance;
    }

    public void setActiveView(JPanel view){
        this.removeAll();
        this.add(view);
        repaint();
    }
}

package com.henrik.view;

import javax.swing.*;
import java.awt.*;

public class MainView extends JFrame {

    public MainView(){
        //NUMBEROFCARDS IMMER DURCH 3 TEILBAR!!!
        CardSelectPanel cardSelectPanel = new CardSelectPanel(9);
        PlayerView playerView = new PlayerView();
        this.setSize(Toolkit.getDefaultToolkit().getScreenSize());

        add(cardSelectPanel);
        add(playerView);




    }
}

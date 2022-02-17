package com.henrik.view.components;

import com.henrik.model.Player;
import com.henrik.model.cards.Monuments;

import javax.swing.*;
import java.awt.*;

public class PlayerView extends JPanel {
    private final Player player;
    private final JLabel name;


    public PlayerView(Player player){
        this.player = player;
        this.name = new JLabel(player.getName());
        updateView();
    }

    public void updateView() {
        this.removeAll();
        JPanel upperRow = new JPanel();
        JLabel coins = new JLabel(String.valueOf(player.getCoins()));
        JPanel monumentPanel = new JPanel();
        monumentPanel.setLayout(new GridLayout(Monuments.Monument.values().length,1));
        for (Monuments.Monument monument: player.getAllMonuments()) {
            monumentPanel.add(new JPanel(){
                @Override
                public void paint(Graphics g) {
                    super.paint(g);
                    g.drawImage(ResourceHandler.getMonument(monument,player.hasMonument(monument)),0,0,null);
                }
            });
        }
        upperRow.setLayout(new GridLayout(1,3));
        upperRow.add(name);
        upperRow.add(monumentPanel);
        upperRow.add(coins);

        JPanel CardPanel = getCardPanel();

        this.setLayout(new GridLayout(2,1));
        this.add(upperRow);
        this.add(CardPanel);
        repaint();
    }

    private JPanel getCardPanel() {
        return new JPanel();
    }


}

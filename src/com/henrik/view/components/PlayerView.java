package com.henrik.view.components;

import com.henrik.controller.CardHelper;
import com.henrik.controller.Controller;
import com.henrik.model.Player;
import com.henrik.model.cards.Monuments;

import javax.sound.sampled.Line;
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.util.Objects;

public class PlayerView extends JPanel {
    private final Player player;
    private final JLabel name;


    public PlayerView(Player player){
        this.player = player;
        this.name = new JLabel(player.getName());
        updateView();
    }

    public void updateView() {
        Dimension monumentDim = CardHelper.getMonumentDim();
        this.removeAll();
        this.setBorder(new LineBorder(Color.BLUE, 3));
        JPanel upperRow = new StickyRow(new Dimension(600, monumentDim.height));
        JLabel coins = new JLabel(String.valueOf(player.getCoins()));
        JPanel monumentPanel = new StickyRow(new Dimension(Monuments.Monument.values().length * monumentDim.width, monumentDim.height));
        monumentPanel.setBorder(new LineBorder(Color.RED,3));
        monumentPanel.setLayout(new GridLayout(1,Monuments.Monument.values().length));
        for (Monuments.Monument monument: Monuments.Monument.values())
            monumentPanel.add(new ImagePanel(Objects.requireNonNull(ResourceHandler.getMonument(monument, player.hasMonument(monument))).getScaledInstance(monumentDim.width,monumentDim.height,Image.SCALE_DEFAULT)));

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

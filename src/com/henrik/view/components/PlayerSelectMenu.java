package com.henrik.view.components;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class PlayerSelectMenu extends JPanel {

    public static void main(String[] args) {

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000,1000);

        frame.add(new PlayerSelectMenu());
        frame.setVisible(true);


    }

        JTable playerTable = new JTable();

        public PlayerSelectMenu() {

            setLayout(new BorderLayout());

            DefaultTableModel model = new DefaultTableModel(new String[] {"Name"}, 0);




            playerTable.setModel(model);

            add(playerTable, BorderLayout.CENTER);

            JTable addTable = new JTable();

            addTable.add(new TextField(""));
            addTable.add(new Button("Test"));

            add(addTable, BorderLayout.SOUTH);
        }



}

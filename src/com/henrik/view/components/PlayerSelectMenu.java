package com.henrik.view.components;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class PlayerSelectMenu extends JPanel {

    public static void main(String[] args) {

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500,500);

        frame.add(new PlayerSelectMenu());
        frame.setVisible(true);


    }

    JTable playerTable = new JTable();

    public PlayerSelectMenu() {

        JButton button;
        setLayout(new GridBagLayout());



        addLabel(0, 0.47);
        addLabelTest(0, 0.47);

        addTextField();

        addLabel(2, 0.47);
        addLabelTest(2, 0.47);

        addButton();
    }

    private void addButton() {
        GridBagConstraints c = new GridBagConstraints();
        c.gridy = 7;
        c.gridx = 1;
        c.fill = GridBagConstraints.BOTH;
        c.anchor = GridBagConstraints.CENTER;
        add(new Button("Start"), c);
    }

    private void addLabel(int i, double weighty) {
        GridBagConstraints c= new GridBagConstraints();
        c.anchor = GridBagConstraints.LINE_END;
        c.gridx = 0;
        c.gridy = i;
        c.weightx = 0.2;
        c.weighty = weighty;
        add(new JLabel(Integer.toString(i)), c);
    }

    private void addLabelTest(int i, double weighty) {
        GridBagConstraints c= new GridBagConstraints();
        c.anchor = GridBagConstraints.LINE_START;
        c.gridx = 2;
        c.gridy = i;
        c.weightx = 0.2;
        c.weighty = weighty;
        add(new JLabel(Integer.toString(i)), c);
    }

    private void addTextField() {
        GridBagConstraints c = new GridBagConstraints();
        c.anchor = GridBagConstraints.CENTER;
        c.gridx = 1;
        c.gridy = 1;
        c.weightx = 0.6;
        c.weighty = 0.1;
        c.fill = GridBagConstraints.HORIZONTAL;
        //tf.setSize((int) (getSize().width*0.4), tf.getHeight());
        add(new TextFieldPanel(), c);
    }

    private class TextFieldPanel extends JPanel {

        public TextFieldPanel() {
            setLayout(new GridLayout(6,1));

            for (int i = 0; i < 6; i++) {
                add(new TextField());
            }
        }
    }

}
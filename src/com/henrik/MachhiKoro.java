package com.henrik;

import com.henrik.controller.Controller;
import com.henrik.view.CardSelectPanel;

import javax.swing.*;

public class MachhiKoro {

    public static void main(String[] args) {

        Controller.getController().init(2);

        JFrame frame = new JFrame();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setSize(1000,1000);
        frame.add(new CardSelectPanel());

        frame.setVisible(true);

    }
}

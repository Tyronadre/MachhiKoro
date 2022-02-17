package com.henrik;

import com.henrik.controller.Controller;
import com.henrik.view.CardSelectPanel;
import com.henrik.view.MainView;
import com.sun.tools.javac.Main;

import javax.swing.*;

public class MachhiKoro {

    public static void main(String[] args) {

        Controller.getController().init(2);

        JFrame frame = new MainView();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }
}

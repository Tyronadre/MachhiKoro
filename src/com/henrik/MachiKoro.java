package com.henrik;

import com.henrik.controller.Controller;
import com.henrik.view.MainView;
import com.sun.tools.javac.Main;

import javax.swing.*;
import java.awt.*;

public class MachiKoro {

    public static void main(String[] args) {

        Controller.getController().init(2);
        MainView.getMainView().init();
        MainView.getMainView().setVisible(true);

    }


}

package com.henrik;

import com.henrik.controller.Controller;
import com.henrik.view.MainFrame;

public class MachiKoro {

    public static void main(String[] args) {
        Controller.getController().init(2);
        MainFrame.getMainView().init();
    }


}

package com.henrik.view;

import com.henrik.controller.CardHelper;
import com.henrik.model.cards.CardType;

import javax.swing.*;
import java.awt.*;
import java.net.URL;
import java.nio.file.Path;

public class ResourceHandler {

    public static ImageIcon getCardImage(CardType cardType){
        URL url = switch (cardType){
            case WEIZENFELD -> ResourceHandler.class.getClassLoader().getResource("cardPictures/weizenfeld.png");
            case CAFE -> ResourceHandler.class.getClassLoader().getResource("cardPictures/cafe.png");
            case WALD -> ResourceHandler.class.getClassLoader().getResource("cardPictures/wald.png");
            case EMPTY -> ResourceHandler.class.getClassLoader().getResource("cardPictures/empty.png");
            case STADION -> ResourceHandler.class.getClassLoader().getResource("cardPictures/stadion.png");
            case BERGWERK -> ResourceHandler.class.getClassLoader().getResource("cardPictures/bergwerk.png");
            case MOLKEREI -> ResourceHandler.class.getClassLoader().getResource("cardPictures/molkerei.png");
            case BAECKEREI -> ResourceHandler.class.getClassLoader().getResource("cardPictures/baeckerei.png");
            case BAUERNHOF -> ResourceHandler.class.getClassLoader().getResource("cardPictures/bauernhof.png");
            case BUEROHAUS -> ResourceHandler.class.getClassLoader().getResource("cardPictures/buerohaus.png");
            case MARKTHALLE -> ResourceHandler.class.getClassLoader().getResource("cardPictures/markthalle.png");
            case MINI_MARKT -> ResourceHandler.class.getClassLoader().getResource("cardPictures/mini_markt.png");
            case MOEBELFABRIK -> ResourceHandler.class.getClassLoader().getResource("cardPictures/moebelfabrik.png");
            case APFELPLANTAGE -> ResourceHandler.class.getClassLoader().getResource("cardPictures/apfelplantage.png");
            case FERNSEHSENDER -> ResourceHandler.class.getClassLoader().getResource("cardPictures/fernsehsender.png");
            case FAMILIEN_RESTAURANT -> ResourceHandler.class.getClassLoader().getResource("cardPictures/familien_restaurant.png");
        };
        if (url ==  null)
            return new ImageIcon();
        ImageIcon imageIcon = new ImageIcon(url);
        imageIcon.setImage(imageIcon.getImage().getScaledInstance(CardHelper.getWidth(),CardHelper.getHeight(), Image.SCALE_DEFAULT));
        return imageIcon;
    }
}

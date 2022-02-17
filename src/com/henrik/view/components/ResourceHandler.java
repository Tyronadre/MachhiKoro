package com.henrik.view.components;

import com.henrik.model.cards.CardType;
import com.henrik.model.cards.Monuments;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

public class ResourceHandler {

    public static BufferedImage getCardImage(CardType cardType){
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
        try {
            return ImageIO.read(url);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static BufferedImage getMonument(Monuments.Monument monument, boolean b) {
        URL url = switch (monument) {
            case BAHNHOF -> b ? ResourceHandler.class.getClassLoader().getResource("monumentPictures/bahnhof_on.png") : ResourceHandler.class.getClassLoader().getResource("monumentPictures/bahnhof_off.png") ;
            case EINKAUFSZENTRUM -> b ? ResourceHandler.class.getClassLoader().getResource("monumentPictures/einkaufszentrum_on.png") : ResourceHandler.class.getClassLoader().getResource("monumentPictures/einkaufszentrum_off.png") ;
            case FREIZEITPARK -> b ? ResourceHandler.class.getClassLoader().getResource("monumentPictures/freizeitpark_on.png") : ResourceHandler.class.getClassLoader().getResource("monumentPictures/freizeitpark_off.png") ;
            case FUNKTURM -> b ? ResourceHandler.class.getClassLoader().getResource("monumentPictures/funkturm_on.png") : ResourceHandler.class.getClassLoader().getResource("monumentPictures/funkturm_off.png") ;
        };
        try {
            return ImageIO.read(url);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}

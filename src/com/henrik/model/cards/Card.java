package com.henrik.model.cards;

import com.henrik.controller.Controller;
import com.henrik.model.Player;
import com.henrik.model.cards.types.*;

import java.util.Locale;
import java.util.Objects;
import java.util.UUID;

public abstract class Card {

    protected Controller controller = Controller.getController();
    protected final int cost;


    public Card(int cost) {
        this.cost = cost;
    }

    public int getCost() {
        return cost;
    }

    public String getName() {
        return getCardType().toString().toUpperCase().charAt(0) + getCardType().toString().toLowerCase().substring(1);
    }

    abstract public ActivationType getActivationType();

    abstract public void consume(Player owner);

    abstract public CardType getCardType();

   // abstract public CardType getActualCardType();


    public static Card getCardOfType(CardType type) {

        return switch (type) {
            case CAFE -> new Cafe();
            case WALD -> new Wald();
            case STADION -> new Stadion();
            case BERGWERK -> new Bergwerk();
            case MOLKEREI -> new Molkerei();
            case BAECKEREI -> new Baeckerei();
            case BAUERNHOF -> new Bauernhof();
            case BUEROHAUS -> new Buerohaus();
            case MARKTHALLE -> new Markthalle();
            case MINI_MARKT -> new MiniMarkt();
            case WEIZENFELD -> new WeizenFeld();
            case MOEBELFABRIK -> new Moebelfabrik();
            case APFELPLANTAGE -> new Apfelplantage();
            case FERNSEHSENDER -> new Fernsehsender();
            case FAMILIEN_RESTAURANT -> new Familienrestaurant();
        };

    }



    public boolean isPflanzenFarm() {
        return false;
    }

    public boolean isTierFarm() {
        return false;
    }

    public boolean isLebensmittelgeschaeft() {
        return false;
    }

    public boolean isRestaurant() {
        return false;
    }

    public boolean isWorkingPlace() {
        return false;
    }

    public boolean isBuilding() {
        return false;
    }

    public boolean isFabrik() {
        return false;
    }

    public boolean isShop() {
        return false;
    }
}

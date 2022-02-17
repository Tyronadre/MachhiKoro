package com.henrik.view.components;

import com.henrik.controller.CardHelper;
import com.henrik.model.cards.CardType;
import com.henrik.view.MainView;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.Objects;

public class DraggableCard extends JComponent {
    private final MainView mainView = MainView.getMainView();
    private final CardType cardType;
    private int screenX = 0;
    private int screenY = 0;
    private int myX = 0;
    private int myY = 0;
    private int maxX = MainView.getMainView().getWidth() - CardHelper.getWidth();
    private int maxY = MainView.getMainView().getHeight() - CardHelper.getHeight();

    public DraggableCard(CardType cardType) {
        this.cardType = cardType;
        setBorder(new LineBorder(Color.BLUE, 3));
        setSize(CardHelper.getWidth(), CardHelper.getHeight());
        setOpaque(false);

        ;

        addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {

            }


            @Override
            public void mousePressed(MouseEvent e) {
                screenX = e.getXOnScreen();
                screenY = e.getYOnScreen();
                myX = getX();
                myY = getY();
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }

        });
        addMouseMotionListener(new MouseMotionListener() {

            @Override
            public void mouseDragged(MouseEvent e) {
                int newX = myX + e.getXOnScreen() - screenX;
                int newY = myY + e.getYOnScreen() - screenY;
                if (newX < mainView.getX())
                    newX = 0;
                else if (newX > mainView.getX() + mainView.getWidth())
                    newX = mainView.getX() + mainView.getWidth();
                if (newY < mainView.getY())
                    newY = 0;
                else if (newY > mainView.getY() + mainView.getHeight())
                    newY = mainView.getY() + mainView.getHeight();

                setLocation(newX, newY);
            }

            @Override
            public void mouseMoved(MouseEvent e) {
            }

        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(Objects.requireNonNull(ResourceHandler.getCardImage(cardType)).getScaledInstance(CardHelper.getWidth(), CardHelper.getHeight(), Image.SCALE_DEFAULT), 0, 0, null);
    }
}

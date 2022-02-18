package com.henrik.view.components;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class ImagePanel extends JPanel {
    Image image;

    public ImagePanel(Image image) {
        this.image = image;
        this.setBorder(new LineBorder(Color.CYAN,3));
    }

    @Override
    public Dimension getMaximumSize()
    {
        return (new Dimension(image.getWidth(null), image.getHeight(null)));
    }

    @Override
    public Dimension getMinimumSize()
    {
        return (new Dimension(image.getWidth(null), image.getHeight(null)));
    }

    @Override
    public Dimension getPreferredSize()
    {
        return (new Dimension(image.getWidth(null), image.getHeight(null)));
    }

    @Override
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.drawImage(image.getScaledInstance(image.getWidth(null), image.getHeight(null),Image.SCALE_DEFAULT), 0, 0, this);
    }
}

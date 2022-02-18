package com.henrik.view.components;

import javax.swing.*;
import java.awt.*;

public class StickyRow extends JPanel {
    Dimension size;

    public StickyRow(Dimension size) {
        super();
        this.size = size;
    }

    @Override
    public Dimension getPreferredSize() {
        return size;
    }

    @Override
    public Dimension getMaximumSize() {
        return size;
    }

    @Override
    public Dimension getMinimumSize() {
        return size;
    }
}

package com.henrik.view;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * Stellt die Grundeinheit einer Ansicht des Fensters dar.
 *
 */
@SuppressWarnings("serial")
public class View extends JPanel {

    /**
     * Wird aufgerufen, damit die sich Ansicht an die neue Fenstergröße anpassen kann.
     */
    public void onResize() {}

}

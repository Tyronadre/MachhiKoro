package com.henrik.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Arrays;

public class MainFrame extends JFrame {
    private static final MainFrame instance = new MainFrame();
    private View activeView;


    private MainFrame() {}

    public void init (){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setMinimumSize(new Dimension(800,600));
        this.setActiveView(new GameBoard());
        this.setTitle("Machi Koro");
        addComponentListener(new ComponentAdapter() {

            @Override
            public void componentResized(ComponentEvent componentEvent) {
                onResize();
            }

        });
        addKeyListener(new KeyAdapter() {

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_F11)
                    setExtendedState(getExtendedState() == Frame.MAXIMIZED_BOTH ? Frame.NORMAL : Frame.MAXIMIZED_BOTH);
            }

        });
        this.setVisible(true);
        System.out.println(Arrays.toString(this.getComponents()));
    }

    private void onResize() {
        activeView.onResize();
    }

    public static MainFrame getMainView() {
        return instance;
    }


    public void setActiveView(View view){
        activeView = view;
        activeView.setSize(getContentPane().getSize());
        activeView.onResize();
        setContentPane(view);
        requestFocus();
    }
}

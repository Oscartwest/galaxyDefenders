package com.wayneschools;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Menu extends JPanel implements ActionListener, MouseListener {
    JLayeredPane p;
    JLabel image;
    JFrame frame;
    JLabel winScreen;
    private final JTextArea instructions;

    //creates a menu with a start button and two areas for the two players to select their characters
    public Menu(JFrame f, int win) {
        p = new JLayeredPane();
        setFocusable(true);
        setLayout(null);
        frame = f;
        winScreen = new JLabel();
        winScreen.setBounds(494, 0, 1105, 122);
        image = new JLabel();
        image.setIcon(new ImageIcon("src/images/StartScreen.png"));
        image.setBounds(0, 0, 1600, 900);
        instructions = new JTextArea();
        instructions.setLineWrap(true);
        instructions.setWrapStyleWord(true);
        instructions.setText(" Player 1 Below... \n Jump: W \n Left: A \n Right: D \n Punch/Kick: F \n Fireball: G \n \n Player 2 Below... \nJump: Up Arrow \nLeft: Left Arrow \nRight: Right Arrow\nPunch/Kick: Enter \nProjectile: Shift \n ");
        instructions.setBounds(0, 50, 300, 225);
        p.add(image, JLayeredPane.DEFAULT_LAYER);
        p.add(instructions, JLayeredPane.POPUP_LAYER);
        instructions.setVisible(false);
        instructions.setEditable(false);
        addMouseListener(this);
        setPreferredSize(new Dimension(1600, 900));
        setMinimumSize(new Dimension(1600, 900));
        if (win == 1) {
            winScreen.setIcon(new ImageIcon("src/images/p1winScreen.png"));
            p.add(winScreen, JLayeredPane.POPUP_LAYER);
        } else if (win == 2) {
            winScreen.setIcon(new ImageIcon("src/images/p2winScreen.png"));
            p.add(winScreen, JLayeredPane.POPUP_LAYER);
        }
        p.setBounds(0, 0, 1600, 900);
        add(p);
        frame.pack();
    }

    public void actionPerformed(ActionEvent e) {

    }

    public void mouseExited(MouseEvent e) {

    }

    public void mouseEntered(MouseEvent e) {
    }

    public void mouseReleased(MouseEvent e) {
    }

    public void mousePressed(MouseEvent e) {
    }

    public void mouseClicked(MouseEvent e) {
        if (e.getX() > 630 && e.getX() < 975 && e.getY() > 450 && e.getY() < 560) {
            System.out.println("HELLO");
            removeAll();
            frame.remove(this);
            frame.setContentPane(new Game(frame));
            frame.setVisible(true);
            frame.pack();
            frame.getContentPane().requestFocusInWindow();
            frame.getContentPane().revalidate();
            frame.getContentPane().repaint();
        }
        if ((e.getX() >= 500 && e.getX() <= 1100) && (e.getY() >= 587 && e.getY() <= 700)) {
            if (instructions.isVisible()) {
                instructions.setVisible(false);
                revalidate();
            } else {
                instructions.setVisible(true);
                System.out.println("Yes");
                revalidate();
            }

        }
    }


}

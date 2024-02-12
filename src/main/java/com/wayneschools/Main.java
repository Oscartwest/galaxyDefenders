package com.wayneschools;

import javax.swing.*;

class Main {
    public static void main(String[] args) {
        JFrame f = new JFrame();
        f.setContentPane(new Menu(f, 0));
        f.pack();
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setTitle("Galaxy Defenders");
    }
}
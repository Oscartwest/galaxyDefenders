package com.wayneschools;

import java.awt.*;

public class Fireball extends Laser {
    private final Image fireball;

    public Fireball(int posX, int posY, int velocityX, boolean isGoingRight) {
        super(posX, posY, velocityX, isGoingRight);
        Toolkit tk = Toolkit.getDefaultToolkit();
        fireball = tk.getImage("src/images/fireball.png");
    }

    public void draw(Graphics g) {

        //   g.setColor(Color.RED);
        // g.fillRect(getX(),getY(),15,1);
        g.drawImage(fireball, getX(), getY(), null);


    }
}
package com.wayneschools;

import java.awt.*;
import java.util.ArrayList;

public class Astronaut extends Character {
    private final ArrayList<Laser> lasers = new ArrayList<Laser>();

    public Astronaut(int health, int posX, int posY, int width, int height, int velocityX, int velocityY, int gravity, boolean isGreen) {
        super(health, posX, posY, width, height, velocityX, velocityY, gravity, isGreen);

    }

    public void projectileAttack() {

        if (lasers.size() <= 2) {

            Laser l = new Laser(getX() - 15, getY() + 10, 10, false);
            if (isFacingRight()) {
                l.setX(getX() + getWidth());
                l.setIsGoingRight(true);
            }

            lasers.add(l);
        }
    }

    public void draw(Graphics g) {

        g.setColor(Color.RED);
        g.drawRect(getX(), getY(), getWidth(), getHeight());
        for (int i = 0; i < lasers.size(); i++) {

            Laser l = lasers.get(i);
            if (l.getX() >= 1600 || l.getX() <= 0 || l.hasCollided()) {
                lasers.remove(i);
                i--;
            }
        }
        for (int j = 0; j < lasers.size(); j++) {
            Laser l = lasers.get(j);
            l.draw(g);
            if (l.isGoingRight()) {

                if (l.willCollide(getCharacter())) {

                    l.setHasCollided(true);
                    l.setX(getCharacter().getX() - 15);
                    getCharacter().damage(5, "projectile");
                } else {
                    l.moveRight();
                }
            } else {
                if (l.willCollide(getCharacter())) {
                    l.setHasCollided(true);
                    l.setX(getCharacter().getX() + getCharacter().getWidth());
                    getCharacter().damage(5, "projectile");
                } else {
                    l.moveLeft();
                }

            }


        }
    }


}

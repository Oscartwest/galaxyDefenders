package com.wayneschools;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Alien extends Character {
    private final ArrayList<Fireball> fireballs = new ArrayList<Fireball>();

    public Alien(int health, int posX, int posY, int width, int height, int velocityX, int velocityY, int gravity, boolean isGreen) {
        super(health, posX, posY, width, height, velocityX, velocityY, gravity, isGreen);
    }

    public void draw(Graphics g) {
        //   g.setColor(Color.GREEN);
        //g.drawRect(getX(), getY(), getWidth(), getHeight());
        if (isFacingRight() && animState.equals("idle") && isGreen()) {
            try {
                g.drawImage(ImageIO.read(new File("src/images/AlienStandstillGreen.png")), getX(), getY(), null);
            } catch (IOException e) {
            }
        } else if (animState.equals("idle") && isGreen()) {
            try {
                g.drawImage(ImageIO.read(new File("src/images/AlienStandstillGreen.png")), getX() + getWidth(), getY(), -getWidth(), getHeight(), null);
            } catch (IOException e) {

            }
        }
        if (isFacingRight() && animState.equals("idle") && !isGreen()) {
            try {
                g.drawImage(ImageIO.read(new File("src/images/AlienStandstillBlue.png")), getX(), getY(), null);
            } catch (IOException e) {
            }
        } else if (animState.equals("idle") && !isGreen()) {
            try {
                g.drawImage(ImageIO.read(new File("src/images/AlienStandstillBlue.png")), getX() + getWidth(), getY(), -getWidth(), getHeight(), null);
            } catch (IOException e) {

            }
        }


        if (animState.equals("walking1") && isFacingRight() && isGreen()) {
            try {
                g.drawImage(ImageIO.read(new File("src/images/AlienWalk1Green.png")), getX(), getY(), null);
            } catch (IOException e) {

            }
        } else if (animState.equals("walking1") && isGreen()) {
            try {
                g.drawImage(ImageIO.read(new File("src/images/AlienWalk1Green.png")), getX() + getWidth(), getY(), -getWidth(), getHeight(), null);
            } catch (IOException e) {

            }
        }
        if (animState.equals("walking1") && isFacingRight() && !isGreen()) {
            try {
                g.drawImage(ImageIO.read(new File("src/images/AlienWalk1.png")), getX(), getY(), null);
            } catch (IOException e) {

            }
        } else if (animState.equals("walking1") && !isGreen()) {
            try {
                g.drawImage(ImageIO.read(new File("src/images/AlienWalk1.png")), getX() + getWidth(), getY(), -getWidth(), getHeight(), null);
            } catch (IOException e) {

            }
        }

        if (animState.equals("walking2") && isFacingRight() && isGreen()) {
            try {
                g.drawImage(ImageIO.read(new File("src/images/AlienWalk2Green.png")), getX(), getY(), null);
            } catch (IOException e) {

            }
        } else if (animState.equals("walking2") && isGreen()) {
            try {
                g.drawImage(ImageIO.read(new File("src/images/AlienWalk2Green.png")), getX() + getWidth(), getY(), -getWidth(), getHeight(), null);
            } catch (IOException e) {

            }
        }
        if (animState.equals("walking2") && isFacingRight() && !isGreen()) {
            try {
                g.drawImage(ImageIO.read(new File("src/images/AlienWalk2Blue.png")), getX(), getY(), null);
            } catch (IOException e) {

            }
        } else if (animState.equals("walking2") && !isGreen()) {
            try {
                g.drawImage(ImageIO.read(new File("src/images/AlienWalk2Blue.png")), getX() + getWidth(), getY(), -getWidth(), getHeight(), null);
            } catch (IOException e) {

            }
        }


        if (animState.equals("walking3") && isFacingRight() && isGreen()) {
            try {
                g.drawImage(ImageIO.read(new File("src/images/AlienWalk3Green.png")), getX(), getY(), null);
            } catch (IOException e) {

            }
        } else if (animState.equals("walking3") && isGreen()) {
            try {
                g.drawImage(ImageIO.read(new File("src/images/AlienWalk3Green.png")), getX() + getWidth(), getY(), -getWidth(), getHeight(), null);
            } catch (IOException e) {

            }
        }
        if (animState.equals("walking3") && isFacingRight() && !isGreen()) {
            try {
                g.drawImage(ImageIO.read(new File("src/images/AlienWalk3Blue.png")), getX(), getY(), null);
            } catch (IOException e) {

            }
        } else if (animState.equals("walking3") && !isGreen()) {
            try {
                g.drawImage(ImageIO.read(new File("src/images/AlienWalk3Blue.png")), getX() + getWidth(), getY(), -getWidth(), getHeight(), null);
            } catch (IOException e) {

            }
        }

        if (animState.equals("punch") && isFacingRight() && isGreen()) {
            try {
                g.drawImage(ImageIO.read(new File("src/images/AlienPunchGreen.png")), getX(), getY(), null);
            } catch (IOException e) {

            }
        } else if (animState.equals("punch") && isGreen()) {
            try {
                g.drawImage(ImageIO.read(new File("src/images/AlienPunchGreen.png")), getX() + getWidth(), getY(), -getWidth(), getHeight(), null);
            } catch (IOException e) {

            }
        }
        if (animState.equals("punch") && isFacingRight() && !isGreen()) {
            try {
                g.drawImage(ImageIO.read(new File("src/images/AlienPunchBlue.png")), getX(), getY(), null);
            } catch (IOException e) {

            }
        } else if (animState.equals("punch") && !isGreen()) {
            try {
                g.drawImage(ImageIO.read(new File("src/images/AlienPunchBlue.png")), getX() + getWidth(), getY(), -getWidth(), getHeight(), null);
            } catch (IOException e) {

            }
        }

        if (animState.equals("kick") && isFacingRight() && isGreen()) {
            try {
                g.drawImage(ImageIO.read(new File("src/images/AlienKickGreen.png")), getX(), getY(), null);
            } catch (IOException e) {

            }
        } else if (animState.equals("kick") && isGreen()) {
            try {
                g.drawImage(ImageIO.read(new File("src/images/AlienKickGreen.png")), getX() + getWidth(), getY(), -getWidth(), getHeight(), null);
            } catch (IOException e) {

            }
        }
        if (animState.equals("kick") && isFacingRight() && !isGreen()) {
            try {
                g.drawImage(ImageIO.read(new File("src/images/AlienKickBlue.png")), getX(), getY(), null);
            } catch (IOException e) {

            }
        } else if (animState.equals("kick") && !isGreen()) {
            try {
                g.drawImage(ImageIO.read(new File("src/images/AlienKickBlue.png")), getX() + getWidth(), getY(), -getWidth(), getHeight(), null);
            } catch (IOException e) {

            }
        }


        for (int i = 0; i < fireballs.size(); i++) {

            Fireball f = fireballs.get(i);
            if (f.getX() >= 1600 || f.getX() <= 0 || f.hasCollided()) {
                fireballs.remove(i);
                i--;
            }
        }
        for (int j = 0; j < fireballs.size(); j++) {
            Fireball f = fireballs.get(j);
            f.draw(g);
            if (f.isGoingRight()) {

                if (f.willCollide(getCharacter())) {

                    f.setHasCollided(true);
                    f.setX(getCharacter().getX() - 15);
                    getCharacter().damage(5, "projectile");
                } else {
                    f.moveRight();
                }
            } else {
                if (f.willCollide(getCharacter())) {
                    f.setHasCollided(true);
                    f.setX(getCharacter().getX() + getCharacter().getWidth());
                    getCharacter().damage(5, "projectile");
                } else {
                    f.moveLeft();
                }

            }


        }
    }

    public void projectileAttack() {

        if (fireballs.size() < 2) {

            Fireball f = new Fireball(getX() - 15, getY() + 75, 6, false);
            if (isFacingRight()) {
                f.setX(getX() + getWidth());
                f.setIsGoingRight(true);
            }

            fireballs.add(f);
        }
    }

}
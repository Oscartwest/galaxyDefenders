package com.wayneschools;

import java.awt.*;

public class Laser {
    private int posX;
    private final int posY;
    private final int velocityX;
    private boolean isGoingRight;
    private final boolean willCollide = false;
    private boolean hasCollided = false;

    public Laser(int posX, int posY, int velocityX, boolean isGoingRight) {
        this.posX = posX;
        this.posY = posY;
        this.velocityX = velocityX;
        this.isGoingRight = isGoingRight;
    }

    public void draw(Graphics g) {

        g.setColor(Color.GREEN);
        g.fillRect(posX, posY, 15, 1);


    }

    public void moveRight() {
        posX += velocityX;

    }

    public void moveLeft() {
        posX -= velocityX;
    }

    public boolean isGoingRight() {
        return isGoingRight;
    }

    public void setIsGoingRight(boolean b) {
        isGoingRight = b;
    }

    public boolean hasCollided() {
        return hasCollided;
    }

    public int getX() {
        return posX;
    }

    public void setX(int num) {
        posX = num;
    }

    public void setHasCollided(boolean b) {
        hasCollided = b;
    }

    public int getY() {
        return posY;
    }

    public boolean willCollide(Character c) {
        int closestX = 0;
        int farthestX = 0;
        int charLowerY = 0;
        int charUpperY = 0;
        if (isGoingRight) {
            farthestX = posX + velocityX + 15;
            closestX = posX;

            if (c.getX() <= farthestX && (c.getX() >= closestX || c.getWidth() + c.getX() >= closestX) && !c.isMovingRight() && !c.isMovingLeft()) {

                charUpperY = c.getY();
                charLowerY = c.getY() + c.getHeight();
                if (c.getVelocityYCopy() <= 0 && c.getY() < 650) {
                    charUpperY = c.getY() + c.getVelocityYCopy();
                    charLowerY = c.getY() + c.getHeight();
                    //  System.out.println("Collosion X Y+");
                    return getY() >= charUpperY && getY() <= charLowerY;
                } else //  System.out.println("Collosion X");
                    if (c.getVelocityYCopy() >= 0 && c.getY() < 650) {
                    charUpperY = c.getY();
                    charLowerY = c.getY() + c.getHeight() + c.getVelocityYCopy();
                        //  System.out.println("Collosion X Y-");
                        return getY() >= charUpperY && getY() <= charLowerY;
                } else return getY() >= charUpperY && getY() <= charLowerY;
            } else if (c.getX() + c.getVelocityX() <= farthestX && (c.getX() + c.getVelocityX() >= closestX || c.getX() + c.getWidth() + c.getVelocityX() >= closestX) && c.isMovingRight()) {
                charUpperY = c.getY();
                charLowerY = c.getY() + c.getHeight();
                if (c.getVelocityYCopy() <= 0 && c.getY() < 650) {
                    charUpperY = c.getY() + c.getVelocityYCopy();
                    charLowerY = c.getY() + c.getHeight();
                    // System.out.println("Collosion R Y+");
                    return getY() >= charUpperY && getY() <= charLowerY;
                } else //  System.out.println("Collosion R");
                    if (c.getVelocityYCopy() >= 0 && c.getY() < 650) {
                    charUpperY = c.getY();
                    charLowerY = c.getY() + c.getHeight() + c.getVelocityYCopy();
                        // System.out.println("Collosion R Y-");
                        return getY() >= charUpperY && getY() <= charLowerY;
                } else return getY() >= charUpperY && getY() <= charLowerY;

            } else if (c.getX() - c.getVelocityX() <= farthestX && (c.getX() - c.getVelocityX() >= closestX || c.getX() + c.getWidth() - c.getVelocityX() >= closestX) && c.isMovingLeft()) {
                charUpperY = c.getY();
                charLowerY = c.getY() + c.getHeight();
                if (c.getVelocityYCopy() <= 0 && c.getY() < 650) {
                    charUpperY = c.getY() + c.getVelocityYCopy();
                    charLowerY = c.getY() + c.getHeight();
                    // System.out.println("Collosion L Y+");
                    return getY() >= charUpperY && getY() <= charLowerY;
                } else // System.out.println("Collosion L");
                    if (c.getVelocityYCopy() >= 0 && c.getY() < 650) {
                    charUpperY = c.getY();
                    charLowerY = c.getY() + c.getHeight() + c.getVelocityYCopy();
                        //  System.out.println("Collosion L Y-");
                        return getY() >= charUpperY && getY() <= charLowerY;
                } else return getY() >= charUpperY && getY() <= charLowerY;
            }
        } else {
            farthestX = (posX - velocityX);
            closestX = posX + 15;
            if (c.getX() + c.getWidth() >= farthestX && c.getX() <= closestX && !c.isMovingRight() && !c.isMovingLeft()) {
                charUpperY = c.getY();
                charLowerY = c.getY() + c.getHeight();
                if (c.getVelocityYCopy() <= 0 && c.getY() < 650) {
                    charUpperY = c.getY() + c.getVelocityYCopy();
                    charLowerY = c.getY() + c.getHeight();
                    // System.out.println("Collosion -X Y+");
                    return getY() >= charUpperY && getY() <= charLowerY;
                } else // System.out.println("Collosion -X");
                    if (c.getVelocityYCopy() >= 0 && c.getY() < 650) {
                    charUpperY = c.getY();
                    charLowerY = c.getY() + c.getHeight() + c.getVelocityYCopy();
                        // System.out.println("Collosion -X Y-");
                        return getY() >= charUpperY && getY() <= charLowerY;
                } else return getY() >= charUpperY && getY() <= charLowerY;
            } else if (c.getX() + c.getVelocityX() + c.getWidth() >= farthestX && c.getX() + c.getVelocityX() <= closestX && c.isMovingRight()) {
                charUpperY = c.getY();
                charLowerY = c.getY() + c.getHeight();
                if (c.getVelocityYCopy() <= 0 && c.getY() < 650) {
                    charUpperY = c.getY() + c.getVelocityYCopy();
                    charLowerY = c.getY() + c.getHeight();
                    //  System.out.println("Collosion -R Y+");
                    return getY() >= charUpperY && getY() <= charLowerY;
                } else //  System.out.println("Collosion -R");
                    if (c.getVelocityYCopy() >= 0 && c.getY() < 650) {
                    charUpperY = c.getY();
                    charLowerY = c.getY() + c.getHeight() + c.getVelocityYCopy();
                        // System.out.println("Collosion -R Y-");
                        return getY() >= charUpperY && getY() <= charLowerY;
                } else return getY() >= charUpperY && getY() <= charLowerY;
            } else if (c.getX() - c.getVelocityX() + c.getWidth() >= farthestX && c.getX() - c.getVelocityX() <= closestX && c.isMovingLeft()) {
                charUpperY = c.getY();
                charLowerY = c.getY() + c.getHeight();
                if (c.getVelocityYCopy() <= 0 && c.getY() < 650) {
                    charUpperY = c.getY() + c.getVelocityYCopy();
                    charLowerY = c.getY() + c.getHeight();
                    //  System.out.println("Collosion -L Y+");
                    return getY() >= charUpperY && getY() <= charLowerY;
                } else //  System.out.println("Collosion L");
                    if (c.getVelocityYCopy() >= 0 && c.getY() < 650) {
                    charUpperY = c.getY();
                    charLowerY = c.getY() + c.getHeight() + c.getVelocityYCopy();
                        // System.out.println("Collosion L Y-");
                        return getY() >= charUpperY && getY() <= charLowerY;
                } else return getY() >= charUpperY && getY() <= charLowerY;
            }
        }


        return false;
    }


}
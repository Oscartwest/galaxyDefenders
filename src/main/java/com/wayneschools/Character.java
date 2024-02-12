package com.wayneschools;

import java.awt.*;

public class Character {
    protected String animState;
    protected int animTimer;
    protected boolean isPunching;
    protected boolean isKicking;
    protected boolean isHitRight;
    protected boolean isHitLeft;
    private int health;
    private int posX;
    private int posY;
    private final int velocityX;
    private final int velocityY;
    private final int gravity;
    private boolean isJumping;
    private final int time;
    private int velocityYCopy;
    private final int height;
    private final int width;
    private boolean isMovingRight;
    private boolean isMovingLeft;
    private boolean isProjectileAttacking;
    private boolean facingRight;
    private boolean lastJump = false;
    private Character c;
    private final boolean isGreen;


    public Character(int health, int posX, int posY, int width, int height, int velocityX, int velocityY, int gravity, boolean isGreen) {
        isPunching = false;
        isKicking = false;
        animTimer = 0;
        animState = "idle";
        this.health = health;
        this.posX = posX;
        this.posY = posY;
        this.velocityX = velocityX;
        this.velocityY = -1 * velocityY;
        this.gravity = gravity;
        this.isJumping = false;
        this.time = 0;
        this.velocityYCopy = this.velocityY;
        this.height = height;
        this.width = width;
        this.isMovingLeft = false;
        this.isMovingRight = false;
        this.isProjectileAttacking = false;
        this.facingRight = true;
        this.isHitLeft = false;
        this.isHitRight = false;
        this.isGreen = isGreen;
    }

    public void setIsMovingRight(boolean s) {
        this.isMovingRight = s;
    }

    public void setIsMovingLeft(boolean s) {
        this.isMovingLeft = s;
    }

    public boolean isMovingRight() {
        return isMovingRight;
    }

    public boolean isMovingLeft() {
        return isMovingLeft;
    }

    public double getHealth() {
        return health;
    }

    public int getX() {
        return posX;
    }

    public int getY() {
        return posY;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Character getCharacter() {
        return c;
    }

    public void setCharacter(Character c) {
        this.c = c;
    }

    public void draw(Graphics g) {
        g.setColor(Color.BLUE);
        g.drawRect(posX, posY, width, height);
    }

    public void moveRight() {

        if (posX + velocityX + width > 1600) {

        } else {
            posX += velocityX;
            this.facingRight = true;
        }
    }

    public void moveLeft() {
        if (posX - velocityX < 0) {

        } else {
            posX -= velocityX;
            this.facingRight = false;
        }
    }

    public void jump() {


        posY += velocityYCopy;
        velocityYCopy += gravity;
        if (posY + width >= 900) {

            posY = 650;

            velocityYCopy = velocityY;
            if (lastJump) {
                setIsJumping(false);
            }
        }

    }

    public void setIsJumping(boolean b) {
        this.isJumping = b;
    }

    public boolean isJumping() {
        return isJumping;
    }

    public void setIsProjectileAttacking(boolean b) {
        this.isProjectileAttacking = b;
    }

    public boolean isProjectileAttacking() {
        return this.isProjectileAttacking;
    }

    public int getAnimTimer() {
        return animTimer;
    }

    public void resetAnimTimer() {
        animTimer = 0;
    }


    public void incrementAnimTimer() {
        animTimer++;
    }

    public boolean getIsPunching() {
        return isPunching;
    }

    public void setIsPunching(boolean isAttacking) {
        this.isPunching = isAttacking;
    }

    public boolean getIsKicking() {
        return isKicking;
    }

    public void setIsKicking(boolean isKicking) {
        this.isKicking = isKicking;
    }

    public boolean attack() {
        if (facingRight) {
            Rectangle r1 = new Rectangle(getX(), getY(), getWidth() + 20, getHeight());
            Rectangle r2 = new Rectangle(c.getX(), c.getY(), c.getWidth(), c.getHeight());
            return r1.intersects(r2);
        } else {
            Rectangle r1 = new Rectangle(getX(), getY(), getWidth(), getHeight());
            Rectangle r2 = new Rectangle(c.getX(), c.getY(), c.getWidth() + 20, c.getHeight());
            return r1.intersects(r2);
        }

    }

    public void projectileAttack() {

    }

    public String getAnimState() {
        return animState;
    }

    public void setAnimState(String state) {
        this.animState = state;
    }

    public void damage(int damage, String attack) {
        if (health > 0)
            this.health -= damage;
        if (health < 0)
            health = 0;
        if (getCharacter().isFacingRight() && (attack.equals("kick") || attack.equals("punch"))) {
            this.setIsHitRight(true);
        }
        if (!getCharacter().isFacingRight() && (attack.equals("kick") || attack.equals("punch"))) {
            this.setIsHitLeft(true);
        }
    }

    public boolean isFacingRight() {
        return this.facingRight;
    }

    public void setLastJump(boolean b) {
        lastJump = b;
    }

    public int getVelocityX() {
        return velocityX;
    }

    public int getVelocityYCopy() {
        return velocityYCopy;
    }

    public int getGravity() {
        return gravity;
    }

    public boolean getIsHitRight() {
        return isHitRight;
    }

    public void setIsHitRight(boolean isHitRight) {
        this.isHitRight = isHitRight;
    }

    public boolean getIsHitLeft() {
        return isHitLeft;
    }

    public void setIsHitLeft(boolean isHitLeft) {
        this.isHitLeft = isHitLeft;
    }

    public boolean isGreen() {
        return isGreen;
    }
}

package com.wayneschools;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


public class Game extends JPanel implements ActionListener, MouseMotionListener, MouseListener, KeyListener {

    JFrame f;
    private final Character p1;
    private boolean reset;
    private final Character p2;
    private final CharacterManager characterManager;
    private final Timer t;
    private final BufferedImage image;
    private final BufferedImage barBorder;
    private final int animInterval;
    private final int gravity;
    private boolean p1hit, p2hit;
    private int p2hitcounter, p1hitcounter;

    public Game(JFrame f) {
        this.f = f;
        p1hit = false;
        p2hit = false;
        animInterval = 5;
        reset = false;
        setFocusable(true);
        setLayout(null);
        addMouseMotionListener(this);
        addKeyListener(this);
        addMouseListener(this);
        gravity = 2;
        p1 = new Alien(100, 20, 650, 250, 250, 10, 40, gravity, false);
        p2 = new Alien(100, 1100, 650, 250, 250, 10, 40, gravity, true);
        characterManager = new CharacterManager();
        characterManager.addCharacter(p1);
        characterManager.addCharacter(p2);
        t = new Timer(16, this);
        t.start();
        setPreferredSize(new Dimension(1600, 900));
        setMinimumSize(new Dimension(1600, 900));
        try {
            image = ImageIO.read(new File("src/images/MoonArena.png"));
            barBorder = ImageIO.read(new File("src/images/BarBorder.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        p2hitcounter = 0;
        p1hitcounter = 0;


    }

    public boolean checkCollision(Character c, boolean isRight) {
        for (int i = 0; i < characterManager.getCharacters().size(); i++) {

            if ((c.getY() + c.getHeight() >= characterManager.getCharacters().get(i).getY()) && (c.getY() <= (characterManager.getCharacters().get(i).getY() + characterManager.getCharacters().get(i).getHeight()))) {
                //right
                if ((c.getX() + c.getWidth()) == (characterManager.getCharacters().get(i).getX() - 1) && isRight) {
                    return false;
                }
                //left
                if (c.getX() - 1 == characterManager.getCharacters().get(i).getX() + characterManager.getCharacters().get(i).getWidth() && !isRight) {
                    return false;
                }
            }
        }
        return true;
    }

    public void actionPerformed(ActionEvent e) {
        if ((p1.getHealth() <= 0 && !reset)) {
            reset = true;
            System.out.println("Game!");
            removeAll();
            f.remove(this);
            f.setContentPane(new Menu(f, 2));
        } else if ((p2.getHealth() <= 0 && !reset)) {
            reset = true;
            System.out.println("Game!");
            removeAll();
            f.remove(this);
            f.setContentPane(new Menu(f, 1));
        }
        f.pack();
        p1.setCharacter(p2);
        p2.setCharacter(p1);
        if (t.isRunning()) {
            repaint();
        }
        if (p1.isJumping()) {
            p1.jump();
        }
        if (p2.isJumping()) {
            p2.jump();
        }
        if (p1.getIsHitRight()) {
            p1hitcounter++;
            for (int i = 0; i < 7; i++)
                p1.moveRight();
            if (p1hitcounter == 3) {
                p1.setIsHitRight(false);
                p1hitcounter = 0;
            }
        }
        if (p1.getIsHitLeft()) {
            p1hitcounter++;
            for (int i = 0; i < 7; i++)
                p1.moveLeft();
            if (p1hitcounter == 3) {
                p1.setIsHitLeft(false);
                p1hitcounter = 0;
            }
        }
        if (p2.getIsHitRight()) {
            p2hitcounter++;
            for (int i = 0; i < 7; i++)
                p2.moveRight();
            if (p2hitcounter == 3) {
                p2.setIsHitRight(false);
                p2hitcounter = 0;
            }
        }
        if (p2.getIsHitLeft()) {
            p2hitcounter++;
            for (int i = 0; i < 7; i++)
                p2.moveLeft();
            if (p2hitcounter == 3) {
                p2.setIsHitLeft(false);
                p2hitcounter = 0;
            }
        }
        if (p1.getIsPunching()) {
            p1.setIsMovingLeft(false);
            p1.setIsMovingRight(false);
        }
        if (p2.getIsPunching()) {
            p2.setIsMovingLeft(false);
            p2.setIsMovingRight(false);
        }
        if (p1.isMovingRight()) {
            p1.incrementAnimTimer();
            p1.moveRight();
            if (p1.getAnimState().equals("idle") && p1.getAnimTimer() > animInterval) {
                p1.setAnimState("walking1");
                p1.resetAnimTimer();
            } else if (p1.getAnimState().equals("walking1") && p1.getAnimTimer() > animInterval) {
                p1.setAnimState("walking2");
                p1.resetAnimTimer();
            } else if (p1.getAnimState().equals("walking2") && p1.getAnimTimer() > animInterval) {
                p1.setAnimState("walking3");
                p1.resetAnimTimer();
            } else if (p1.getAnimState().equals("walking3") && p1.getAnimTimer() > animInterval) {
                p1.setAnimState("walking1");
                p1.resetAnimTimer();
            }
        } else if (p1.isMovingLeft()) {
            p1.incrementAnimTimer();
            p1.moveLeft();
            if (p1.getAnimState().equals("idle") && p1.getAnimTimer() > animInterval) {
                p1.setAnimState("walking1");
                p1.resetAnimTimer();
            } else if (p1.getAnimState().equals("walking1") && p1.getAnimTimer() > animInterval) {
                p1.setAnimState("walking2");
                p1.resetAnimTimer();
            } else if (p1.getAnimState().equals("walking2") && p1.getAnimTimer() > animInterval) {
                p1.setAnimState("walking3");
                p1.resetAnimTimer();
            } else if (p1.getAnimState().equals("walking3") && p1.getAnimTimer() > animInterval) {
                p1.setAnimState("walking1");
                p1.resetAnimTimer();
            }
        }
        if (p2.isMovingRight()) {
            p2.incrementAnimTimer();
            p2.moveRight();
            if (p2.getAnimState().equals("idle") && p2.getAnimTimer() > animInterval) {
                p2.setAnimState("walking1");
                p2.resetAnimTimer();
            } else if (p2.getAnimState().equals("walking1") && p2.getAnimTimer() > animInterval) {
                p2.setAnimState("walking2");
                p2.resetAnimTimer();
            } else if (p2.getAnimState().equals("walking2") && p2.getAnimTimer() > animInterval) {
                p2.setAnimState("walking3");
                p2.resetAnimTimer();
            } else if (p2.getAnimState().equals("walking3") && p2.getAnimTimer() > animInterval) {
                p2.setAnimState("walking1");
                p2.resetAnimTimer();
            }
        } else if (p2.isMovingLeft()) {
            p2.incrementAnimTimer();
            p2.moveLeft();
            if (p2.getAnimState().equals("idle") && p2.getAnimTimer() > animInterval) {
                p2.setAnimState("walking1");
                p2.resetAnimTimer();
            } else if (p2.getAnimState().equals("walking1") && p2.getAnimTimer() > animInterval) {
                p2.setAnimState("walking2");
                p2.resetAnimTimer();
            } else if (p2.getAnimState().equals("walking2") && p2.getAnimTimer() > animInterval) {
                p2.setAnimState("walking3");
                p2.resetAnimTimer();
            } else if (p2.getAnimState().equals("walking3") && p2.getAnimTimer() > animInterval) {
                p2.setAnimState("walking1");
                p2.resetAnimTimer();
            }
        }
        if (!p1.isMovingLeft() && !p1.isMovingRight()) {
            if (p1.getAnimTimer() == 5 && p1.getAnimState().equals("punch")) {
                p1.setAnimState("idle");
                p1.resetAnimTimer();
            } else if (p1.getAnimState().equals("punch")) {
                p1.incrementAnimTimer();
            } else {
                p1.setAnimState("idle");
                p1.setIsPunching(false);
            }
        }
        if (!p2.isMovingLeft() && !p2.isMovingRight()) {
            if (p2.getAnimTimer() == 5 && p2.getAnimState().equals("punch")) {
                p2.setAnimState("idle");
                p2.resetAnimTimer();
            } else if (p2.getAnimState().equals("punch")) {
                p2.incrementAnimTimer();
            } else {
                p2.setAnimState("idle");
                p2.setIsPunching(false);
            }
        }
        if (p1.getIsKicking() && !p1.isJumping()) {
            p1.setIsKicking(false);
            p1.setIsMovingLeft(false);
            p1.setIsMovingRight(false);
            p1.setAnimState("idle");
        }
        if (p2.getIsKicking() && !p2.isJumping()) {
            p2.setIsKicking(false);
            p2.setIsMovingLeft(false);
            p2.setIsMovingRight(false);
            p2.setAnimState("idle");
        }
        if (p1.getIsKicking() && !p1hit) {
            if (p1.attack()) {
                p2.damage(5, "kick");
                p1hit = true;
            }
        }
        if (p2.getIsKicking() && !p2hit) {
            if (p2.attack()) {
                p1.damage(5, "kick");
                p2hit = true;
            }
        }
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, null);
        characterManager.draw(g);
        g.setColor(Color.BLACK);
        g.drawRect(0, 0, 1600, 900);
        g.setColor(Color.GREEN);
        g.fillRect(45, 25, (int) ((p1.getHealth() / 100.0) * 720), 50);
        g.drawImage(barBorder, 25, 25, null);
        g.fillRect(835, 25, (int) ((p2.getHealth() / 100.0) * 720), 50);
        g.drawImage(barBorder, 825 + 750/*width*/, 25, -750/*-width*/, 50, null);


    }

    public void mouseReleased(MouseEvent e) {

    }

    public void mouseEntered(MouseEvent e) {

    }

    public void mouseExited(MouseEvent e) {

    }

    public void mouseMoved(MouseEvent e) {


    }

    public void mouseDragged(MouseEvent e) {

    }

    public void mouseClicked(MouseEvent e) {


    }

    public void mousePressed(MouseEvent e) {

    }

    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_D && (!p1.getIsPunching() && !p1.getIsKicking())) {
            p1.setIsMovingRight(true);
        }
        if (e.getKeyCode() == KeyEvent.VK_A && (!p1.getIsPunching() && !p1.getIsKicking())) {
            p1.setIsMovingLeft(true);
        }

        if (e.getKeyCode() == KeyEvent.VK_W && (!p1.getIsPunching() && !p1.getIsKicking())) {
            p1.setIsJumping(true);
            p1.setLastJump(false);
        }


        if (e.getKeyCode() == KeyEvent.VK_RIGHT && (!p2.getIsPunching() && !p2.getIsKicking())) {
            p2.setIsMovingRight(true);
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT && (!p2.getIsPunching() && !p2.getIsKicking())) {
            p2.setIsMovingLeft(true);
        }
        if (e.getKeyCode() == KeyEvent.VK_UP && (!p2.getIsPunching() && !p2.getIsKicking())) {
            p2.setIsJumping(true);

            p2.setLastJump(false);
        }


    }

    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_D && !p1.getIsKicking()) {
            p1.setIsMovingRight(false);
        }
        if (e.getKeyCode() == KeyEvent.VK_A && !p1.getIsKicking()) {
            p1.setIsMovingLeft(false);
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT && !p2.getIsKicking()) {
            p2.setIsMovingRight(false);
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT && !p2.getIsKicking()) {
            p2.setIsMovingLeft(false);
        }


        if (e.getKeyCode() == KeyEvent.VK_W) {

            p1.setLastJump(true);
        }
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            p2.setLastJump(true);
        }
        if (e.getKeyCode() == KeyEvent.VK_G) {
            p1.projectileAttack();

        }
        if (e.getKeyCode() == KeyEvent.VK_SHIFT) {
            p2.projectileAttack();

        }
        if (e.getKeyCode() == KeyEvent.VK_ENTER && !p2.isJumping() && !p2.getIsPunching()) {
            p2.resetAnimTimer();
            p2.setAnimState("punch");
            p2.setIsPunching(true);
            if (p2.attack()) {
                p1.damage(5, "punch");
            }

        } else if (e.getKeyCode() == KeyEvent.VK_ENTER && !p2.getIsKicking()) {
            p2hit = false;
            p2.resetAnimTimer();
            p2.setAnimState("kick");
            p2.setIsKicking(true);
        }

        if (e.getKeyCode() == KeyEvent.VK_F && !p1.isJumping() && !p1.getIsPunching()) {
            p1.resetAnimTimer();
            p1.setAnimState("punch");
            p1.setIsPunching(true);
            if (p1.attack()) {
                p2.damage(5, "punch");
            }


        } else if (e.getKeyCode() == KeyEvent.VK_F && !p1.getIsKicking()) {
            p1hit = false;
            p1.resetAnimTimer();
            p1.setAnimState("kick");
            p1.setIsKicking(true);

        }


    }

    public void keyTyped(KeyEvent e) {

    }

}
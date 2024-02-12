package com.wayneschools;

import java.awt.*;
import java.util.ArrayList;

public class CharacterManager {
    private final ArrayList<Character> characters;

    public CharacterManager() {
        characters = new ArrayList<Character>();
    }

    public void addCharacter(Character c) {
        characters.add(c);
    }

    public ArrayList<Character> getCharacters() {
        return characters;
    }

    public void draw(Graphics g) {
        for (int i = 0; i < characters.size(); i++) {
            Character c = characters.get(i);
            c.draw(g);

        }
    }

}
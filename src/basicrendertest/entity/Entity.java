/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basicrendertest.entity;

import basicrendertest.graphics.Screen;
import basicrendertest.level.Level;
import java.util.Random;

/**
 *
 * @author Ben Allen
 */
public abstract class Entity {

    public int x, y;
    private boolean removed = false;
    protected Level level;
    protected final Random random = new Random();

    public void update() {

    }

    public void render(Screen screen) {

    }

    public void remove() {
        //remove from level
        removed = true;
    }

    public boolean isRemoved() {
        return removed;
    }
}

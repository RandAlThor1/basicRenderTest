/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basicrendertest.level;

import java.util.Random;

/**
 *
 * @author Ben Allen
 */
public class RandomLevel extends Level {

    private static final Random RANDOM = new Random();

    public RandomLevel(int width, int height) {
        super(width, height);
    }

    protected void generateLevel() {
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                tilesint[x + y * width] = RANDOM.nextInt(4);
            }
        }
    }

}

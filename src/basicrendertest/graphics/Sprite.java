/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basicrendertest.graphics;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author Ben Allen
 */
public class Sprite {

    public final int SIZE;
    private int x, y;
    public int[] pixels;
    private SpriteSheet sheet;

    public static Sprite grass = new Sprite(16, 0, 0, SpriteSheet.tiles);
    public static Sprite rocks = new Sprite(16, 1, 0, SpriteSheet.tiles);
    public static Sprite water = new Sprite(16, 2, 0, SpriteSheet.tiles);
    public static Sprite flowers = new Sprite(16, 3, 0, SpriteSheet.tiles);
    public static Sprite pink = new Sprite(16, 4, 0, SpriteSheet.tiles);
    public static Sprite voidSprite = new Sprite(16, 0);

    public static Sprite player_front = new Sprite(32, 0, 5, SpriteSheet.tiles);
    public static Sprite player_back = new Sprite(32, 1, 5, SpriteSheet.tiles);
    public static Sprite player_left = new Sprite(32, 2, 5, SpriteSheet.tiles);
    public static Sprite player_right = new Sprite(32, 3, 5, SpriteSheet.tiles);
    public static Sprite player_front_1 = new Sprite(32, 0, 6, SpriteSheet.tiles);
    public static Sprite player_front_2 = new Sprite(32, 0, 7, SpriteSheet.tiles);
    public static Sprite player_back_1 = new Sprite(32, 1, 6, SpriteSheet.tiles);
    public static Sprite player_back_2 = new Sprite(32, 1, 7, SpriteSheet.tiles);
    public static Sprite player_left_1 = new Sprite(32, 2, 6, SpriteSheet.tiles);
    public static Sprite player_left_2 = new Sprite(32, 2, 7, SpriteSheet.tiles);
    public static Sprite player_right_1 = new Sprite(32, 3, 6, SpriteSheet.tiles);
    public static Sprite player_right_2 = new Sprite(32, 3, 7, SpriteSheet.tiles);
    

    public Sprite(int size, int x, int y, SpriteSheet sheet) {
        this.SIZE = size;
        this.x = x * size;
        this.y = y * size;
        this.sheet = sheet;
        pixels = new int[SIZE * SIZE];
        load();
    }

    public Sprite(int size, int colour) {
        this.SIZE = 0;
        pixels = new int[SIZE * SIZE];
        setColour(colour);
    }

    private void setColour(int colour) {
        for (int i = 0; i < SIZE * SIZE; i++) {
            pixels[i] = colour;
        }
    }

    private void load() {
        for (int y = 0; y < SIZE; y++) {
            for (int x = 0; x < SIZE; x++) {
                pixels[x + y * SIZE] = sheet.pixels[(x + this.x) + (y + this.y) * sheet.SIZE];
            }
        }
    }

}

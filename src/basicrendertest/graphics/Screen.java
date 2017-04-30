/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basicrendertest.graphics;

import basicrendertest.entity.mob.Player;
import basicrendertest.level.tile.Tile;
import java.awt.Color;
import java.util.Random;

/**
 *
 * @author Ben Allen
 */
public class Screen {

    public int width, height;
    public int[] pixels;
    public final int MAP_SIZE = 16;
    public final int MAP_SIZE_MASK = MAP_SIZE - 1;
    public int[] tiles = new int[MAP_SIZE * MAP_SIZE];

    public int xOffset, YOffset;

    private Random random = new Random();

    public Screen(int width, int height) {
        this.width = width;
        this.height = height;
        pixels = new int[width * height];

        for (int i = 0; i < MAP_SIZE * MAP_SIZE; i++) {
            tiles[i] = random.nextInt(0xffffff);
        }
    }

    public void clear() {
        for (int i = 0; i < pixels.length; i++) {
            pixels[i] = 0;
        }
    }

    public void renderTile(int xp, int yp, Tile tile) {
        xp -= xOffset;
        yp -= YOffset;
        for (int y = 0; y < tile.sprite.SIZE; y++) {
            int ya = y + yp;
            for (int x = 0; x < tile.sprite.SIZE; x++) {
                int xa = x + xp;
                if (xa < -tile.sprite.SIZE || xa >= width || ya < 0 || ya >= height) {
                    break;
                }
                {
                    if (xa < 0) {
                        xa = 0;
                    }
                    pixels[xa + ya * width] = tile.sprite.pixels[x + y * tile.sprite.SIZE];
                }
            }
        }
    }

    public void setOffset(int xOffset, int YOffset) {
        this.xOffset = xOffset;
        this.YOffset = YOffset;
    }

    public void renderPlayer(int xp, int yp, Sprite sprite) {
        xp -= xOffset;
        yp -= YOffset;
        for (int y = 0; y < 32; y++) {
            int ya = y + yp;
            for (int x = 0; x < 32; x++) {
                int xa = x + xp;
                if (xa < -32 || xa >= width || ya < 0 || ya >= height) break;
                if (xa < 0) xa = 0;
                int col = sprite.pixels[x + y * 32];
                if (col != 0xFFFF00FF) pixels[xa + ya * width] = col;
                }
            }
        }
    }


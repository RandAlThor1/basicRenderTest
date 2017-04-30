/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basicrendertest.level;

import basicrendertest.graphics.Screen;
import basicrendertest.level.tile.Tile;

/**
 *
 * @author Ben Allen
 */
public class Level {

    protected int width, height;
    protected int[] tilesint;
    //protected int[] tiles;
    protected Tile[] tiles;
    

    public Level(int width, int height) {
        this.width = width;
        this.height = height;
        this.tilesint = new int[width * height];
        generateLevel();
    }

    public Level(String path) {
        loadLevel(path);
        generateLevel();
    }

    protected void generateLevel() {

    }

    protected void loadLevel(String path) {

    }

    public void update() {

    }

    public void render(int xScroll, int yScroll, Screen screen) {
        screen.setOffset(xScroll, yScroll);
        int x0 = xScroll >> 4;
        int x1 = (xScroll + screen.width + 16) >> 4;
        int y0 = yScroll >> 4;
        int y1 = (yScroll + screen.height + 16) >> 4;

        for (int y = y0; y < y1; y++) {
            for (int x = x0; x < x1; x++) {
                if (x + y * 16 < 0 || x + y * 16 >= 16 * 16) {
                    Tile.voidTile.render(x, y, screen);
                    continue;
                }
                tiles[x + y * 16].render(x, y, screen);
                //getTile(x, y).render(x, y, screen);
            }
        }
    }

    public Tile getTile(int x, int y) {
        if (x < 0 || y < 0 || x >= width || y >= height) {
            return Tile.voidTile;
        }
        if (tilesint[x + y * width] == 0) {
            return Tile.grass;
        }
        if (tilesint[x + y * width] == 1) {
            return Tile.rocks;
        }
        if (tilesint[x + y * width] == 2) {
            return Tile.flowers;
        }
        if (tilesint[x + y * width] == 3) {
            return Tile.water;
        }
        return Tile.voidTile;
    }

    private void time() {

    }
}

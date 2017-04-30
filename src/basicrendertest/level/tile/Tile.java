/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basicrendertest.level.tile;

import basicrendertest.graphics.Screen;
import basicrendertest.graphics.Sprite;

/**
 *
 * @author Ben Allen
 */
public class Tile {

    public int x, y;
    public Sprite sprite;

    public static Tile grass = new GrassTile(Sprite.grass);
    public static Tile rocks = new RockTile(Sprite.rocks);
    public static Tile flowers = new FlowerTile(Sprite.flowers);
    public static Tile water = new WaterTile(Sprite.water);

    public static Tile voidTile = new VoidTile(Sprite.voidSprite);

    public Tile(Sprite sprite) {
        this.sprite = sprite;
    }

    public void render(int x, int y, Screen screen) {
    }

    public boolean solid() {
        return false;
    }
}

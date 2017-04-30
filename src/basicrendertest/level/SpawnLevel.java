/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basicrendertest.level;

import basicrendertest.level.tile.Tile;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

/**
 *
 * @author Ben Allen
 */
public class SpawnLevel extends Level {

    //private Tile[] tiles;
    //private int[] tiles;
    private int[] levelPixels;
    

    public SpawnLevel(String path) {
        super(path);
    }

    protected void loadLevel(String path) {
        try {
            BufferedImage image = ImageIO.read(SpawnLevel.class.getResource(path));
            int w = image.getWidth();
            int h = image.getHeight();
            tiles  = new Tile[w * h];
            levelPixels = new int[w * h];
            image.getRGB(0, 0, w, h, levelPixels, 0 ,w);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("EXCEPTION: LEVEL FILE LOAD LEVEL FAILURE!");
        }

    }
    
    // Grass  = 0xff00FF00
    // flower = 0xffFFFF00
    // rock   = 0xfff7F7F00
    // water  = 0xff0000ff
    // Void   = 0Xff
    protected void generateLevel(){
        
        for (int i = 0; i < tiles.length; i++) {
            if (levelPixels[i] == 0xff00ff00) tiles[i] = Tile.grass;
            if (levelPixels[i] == 0xffffff00) tiles[i] = Tile.flowers;
            if (levelPixels[i] == 0Xff7f7f00) tiles[i] = Tile.rocks;
            if (levelPixels[i] == 0xFF0000FF) tiles[i] = Tile.water;
            if (levelPixels[i] == 0xFF) tiles[i] = Tile.voidTile;
            //else tiles[i] = Tile.voidTile;
            
        }
    }

}

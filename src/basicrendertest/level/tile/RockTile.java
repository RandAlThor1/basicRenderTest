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
class RockTile extends Tile {
    
    public RockTile(Sprite sprite) {
        super(sprite);
    }
    @Override
    public void render(int x, int y, Screen screen) {
        screen.renderTile(x << 4, y << 4, this);
    }
    public boolean solid(){
        return true;
    }
    
}

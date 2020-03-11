/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package videogame;

import java.awt.image.BufferedImage;

/**
 *
 * @author diego
 */
public class Animation {
    
    private int speed;
    private int index;
    private long lastTime;
    private long timer;
    private BufferedImage[] frames;
    
    public Animation(BufferedImage[] frames, int speed) {
        this.frames = frames;
        this.speed = speed;
        index = 0;
        timer = 0;
        lastTime = System.currentTimeMillis();
    }
    
    public BufferedImage getCurrentFrame() {
        return frames[index];
    }
    
    
}

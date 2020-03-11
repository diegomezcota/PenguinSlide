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
    
    /*
    * to update the animation to get the right index of the frame to paint
    */
    public void tick(){
        // acumulating time from the previous tick to this one
        timer += System.currentTimeMillis() - lastTime;
        // updating the lastTime for the next tick
        lastTime = System.currentTimeMillis();
        // check the timer to increase the index
        if (timer > speed){
            ++index;
            timer = 0;
            // check index not to get out of the bounds
            if (index >= frames.length){
                index = 0;
            }
        }
    }   
        
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package videogame;

import java.awt.image.BufferedImage;

/**
 *
 * @author antoniomejorado
 */
public class Assets {
    public static BufferedImage background; // to store background image
    public static BufferedImage player;     // to store the player image
    public static BufferedImage sprites;    // to store the sprites
    public static BufferedImage playerUp[]; // pictures to go up
    public static BufferedImage playerLeft[];   // pictures to go left
    public static BufferedImage playerDown[];   // pictures to go down
    public static BufferedImage playerRight[];  // pictures to right

    /**
     * initializing the images of the game
     * HOLI
     */
    public static void init() {
        // load every image
        background = ImageLoader.loadImage("/images/spongebob.jpg");
        player = ImageLoader.loadImage("/images/michael.png");
        // getting the sprites from the picture
    }   
}

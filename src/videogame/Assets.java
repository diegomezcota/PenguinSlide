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
    public static BufferedImage dizzyPlayer;    // to store the dizzy player image

    /**
     * initializing the images of the game
     */
    public static void init() {
        // load every image
        background = ImageLoader.loadImage("/images/spongebob.jpg");
        player = ImageLoader.loadImage("/images/michael.png");
        dizzyPlayer = ImageLoader.loadImage("/images/crashed.png");
    }
    
}

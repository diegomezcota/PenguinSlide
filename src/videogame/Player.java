/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package videogame;

import java.awt.Graphics;

/**
 *
 * @author mairna mtz
 */
public class Player extends Item {

    private int velocity;       // to store player's velocity
    private int colisionTimer;  // to store a timer to change the sprite
    private boolean colision;   // checks if a colision is made with the limits of the canvas
    private String direction;   // direction of the player
    private Game game;          // to have a reference for the main game
    private Animation animationUp;  // to store the animation for going up
    private Animation animationLeft;    // to store the animation for going left
    private Animation animationDown;    // to store the animation for going down
    private Animation animationRight;    // to store the animation for going right

    /**
     * To build a Player object
     * @param x an <code>int</code> value to get the x coordinate
     * @param y an <code>int</code> value to get the y coordinate
     * @param direction an <code>int</code> value to get the direction
     * @param width an <code>int</code> value to get the width
     * @param height an <code>int</code> value to get the height
     * @param game  a <code>game</code> object to get outside elements
     */
    public Player(int x, int y, int direction, int width, int height, Game game) {
        // initialize every value
        super(x, y, width, height);
        this.velocity = 1;
        this.direction = "RIGHT";
        this.game = game;
        this.colision = false;
        this.colisionTimer = 15;
        
        this.animationUp = new Animation(Assets.playerUp, 100);
        this.animationLeft = new Animation(Assets.playerLeft, 100);
        this.animationDown = new Animation(Assets.playerDown, 100);
        this.animationRight = new Animation(Assets.playerRight, 100);
    }

    // returns the direction of the player
    public String getDirection() {
        return direction;
    }

    // sets the direction of the player
    public void setDirection(String direction) {
        this.direction = direction;
    }

    // manages the velocity of the player
    public void reduceVelocity() {
        if (velocity > 1) {
            velocity--;
        } else {
            velocity = 1;
        }
    }

    // moves the player depending on the current direction
    public void moveCurrentDirection() {
        switch (getDirection()) {
            case "RIGHT":
                setX(getX() + 1 * velocity);
                break;
            case "LEFT":
                setX(getX() - 1 * velocity);
                break;
            case "UP":
                setY(getY() - 1 * velocity);
                break;
            case "DOWN":
                setY(getY() + 1 * velocity);
                break;
            default:
                break;
        }
    }

    // updates the direction of the player and the player's speed
    public void updateMoves() {
        // moving player depending on flags
        if (game.getKeyManager().up) {
            setDirection("UP");
            game.getKeyManager().releaseUp();
        }
        if (game.getKeyManager().down) {
            setDirection("DOWN");
            game.getKeyManager().releaseDown();
        }
        if (game.getKeyManager().left) {
            setDirection("LEFT");
            game.getKeyManager().releaseLeft();
        }
        if (game.getKeyManager().right) {
            setDirection("RIGHT");
            game.getKeyManager().releaseRight();
        }
    }

    // manages colisions of the player and changes direction when needed
    public void manageColisions() {
        // reset x position and y position if colision
        if (getX() + 60 >= game.getWidth()) {
            setDirection("LEFT");
            colision = true;
        } else if (getX() <= -30) {
            setDirection("RIGHT");
            colision = true;
        }
        if (getY() + 80 >= game.getHeight()) {
            setDirection("UP");
            colision = true;
        } else if (getY() <= -20) {
            setDirection("DOWN");
            colision = true;
        }
    }

    // sets a timer to change the player sprite
    public void checkColisionSprite() {
        if (colision) {
            this.colisionTimer--;
            if (this.colisionTimer == 0) {
                colision = false;
                this.colisionTimer = 15;
            }
        }
    }

    @Override
    public void tick() {
        // moving character
        moveCurrentDirection();
        updateMoves();
        // updating animation
        this.animationRight.tick();
        this.animationLeft.tick();
        this.animationUp.tick();
        this.animationDown.tick();
    }

    @Override
    public void render(Graphics g) {
        if (getDirection() == "RIGHT")
            g.drawImage(animationRight.getCurrentFrame(), getX(), getY(), getWidth(), getHeight(), null);
        else if (getDirection() == "LEFT")
            g.drawImage(animationLeft.getCurrentFrame(), getX(), getY(), getWidth(), getHeight(), null);
        else if (getDirection() == "UP")
            g.drawImage(animationUp.getCurrentFrame(), getX(), getY(), getWidth(), getHeight(), null);
        else g.drawImage(animationDown.getCurrentFrame(), getX(), getY(), getWidth(), getHeight(), null);
    }
}

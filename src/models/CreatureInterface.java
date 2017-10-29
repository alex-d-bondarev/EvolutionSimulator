package models;

import java.awt.*;

public interface CreatureInterface {


    /**
     * Draw creature on screen
     * @param g
     */
    void display(Graphics g);

    /**
     * Set and get X and Y positions of this creature
     */
    void setXPosition(int x);
    void setYPosition(int y);
    int getXPosition();
    int getYPosition();


    /**
     * Make creature to update it's state (move, clone, attack, do nothing, etc)
     */
    void update();
}

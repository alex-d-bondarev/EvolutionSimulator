package models;

import java.awt.*;

/**
 *  Provide interface for models that will describe general public methods,
 *  which will make interfaces more flexible.
 */
public interface WorldInterface {

    /**
     * Send signal to all controllers to display their current state
     *
     * @param g Graphics
     */
    void display(Graphics g);


    /**
     * Send signal to all controllers to update their current state
     */
    void update();


    /**
     * Add given creature to this world
     *
     * @param creature given creature will be added to this world in given position
     * @param positionX X position of creature
     * @param positionY Y position of creature
     */
    void addCreature(CreatureInterface creature, int positionX, int positionY);


    /**
     * @param positionX X position of creature
     * @param positionY Y position of creature
     * @return          creature from given position or null if given position is empty
     */
    CreatureInterface getCreature(int positionX, int positionY);


    /**
     * @return X size of world array (world will be a square)
     */
    int getWorldSize();

}

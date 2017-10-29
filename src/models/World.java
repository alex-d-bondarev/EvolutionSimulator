package models;

import settings.GameSettings;

import javax.swing.*;
import java.awt.*;

public class World extends JPanel implements WorldInterface {

    private static WorldInterface instance = null;

    /**
     * Game settings
     */
    private GameSettings settings = GameSettings.getInstance();

    /**
     * World map that stores all creatures and their corpses. Null represents empty cells.
     */
    private CreatureInterface[][] worldMap;

    /**
     * Size of square window to display
     */
    private int frameSize = 0;

    /**
     * Starting point of the first creature posX = posY = startPoint
     */
    private int startPoint = 0;

    /**
     * Constructor:
     *
     * Create world with first creature in startPoint
     * Specify controller that will be used for creature
     */
    private World(){
        frameSize = settings.getWorldSize();
        worldMap = new CreatureInterface[frameSize][frameSize];

        Creature creature = new Creature();
        worldMap[startPoint][startPoint] = creature;

        instance = this;
    }

    public static WorldInterface getInstance() {
        if(instance == null) new World();
        return instance;
    }

    /**
     * Collect all creatures from worldMap in a list,
     * order them by strength and energy, and
     * send each creature an update signal according to their order
     */
    @Override
    public void update(){
        for (int x = 0; x < frameSize; x++){
            for(int y = 0; y < frameSize; y++){
                if(worldMap[x][y] != null){
                    worldMap[x][y].update();
                }
            }
        }
    }

    @Override
    public void addCreature(CreatureInterface creature, int positionX, int positionY) {
        worldMap[positionX][positionY] = creature;
    }

    @Override
    public CreatureInterface getCreature(int positionX, int positionY) {
        return null;
    }

    /**
     * Send each controller and creature a display signal
     *
     * @param g Graphics
     */
    @Override
    public void display(Graphics g) {
        draw(g);
        displayEachCreature(g);
    }

    private void draw(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLACK);
        g.fillRect(0,0
                ,settings.getWorldSize()*settings.getScale()
                ,settings.getWorldSize()*settings.getScale());
    }

    /**
     * Send each creature in world model their coordinates and display signal
     *
     * @param g
     */
    private void displayEachCreature(Graphics g){
        for (int x = 0; x < frameSize; x++){
            for(int y = 0; y < frameSize; y++){
                if(worldMap[x][y] != null){
                    worldMap[x][y].setXPosition(x);
                    worldMap[x][y].setYPosition(y);
                    worldMap[x][y].display(g);
                }
            }
        }
    }

    @Override
    public int getWorldSize() {
        return frameSize;
    }
}

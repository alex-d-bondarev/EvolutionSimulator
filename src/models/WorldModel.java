package models;

import controllers.ControllerInterface;
import controllers.CreatureController;
import settings.GameSettings;

import java.awt.*;

public class WorldModel implements ModelInterface{

    private int frameSize, startPoint = 0;

    GameSettings settings = GameSettings.getInstance();
    CreatureModel[][] worldMap;
    ControllerInterface controller;

    public WorldModel(){
        CreatureModel creature = new CreatureModel();
        CreatureController cController = new CreatureController(creature);
        creature.addController(cController);

        frameSize = settings.getScreenSize();
        worldMap = new CreatureModel[frameSize][frameSize];
        worldMap[startPoint][startPoint] = creature;
    }

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
    public void addController(ControllerInterface controller) {
        this.controller = controller;
    }

    @Override
    public void display(Graphics g) {
        controller.draw(g);
        displayEachCreature(g);
    }

    private void displayEachCreature(Graphics g){
        for (int x = 0; x < frameSize; x++){
            for(int y = 0; y < frameSize; y++){
                if(worldMap[x][y] != null){
                    worldMap[x][y].setPosX(x);
                    worldMap[x][y].setPosY(y);
                    worldMap[x][y].display(g);
                }
            }
        }
    }
}

package models;

import controllers.ControllerInterface;

import java.util.ArrayList;
import java.util.List;

public class ExperimentModel implements ModelInterface{

    public ExperimentModel(int fs){
        posX = posY = 40;
        velocityX = 1;
        velocityY = velocityX*2;
        frameSize = fs;
    }

    private int posX, posY, velocityX, velocityY, frameSize, startPoint = 0;

    List<ControllerInterface> controllers = new ArrayList<>();

    public void update(){
        posX = (posX != frameSize) ? (posX + velocityX) : startPoint;
        posY = (posY != frameSize) ? (posY + velocityY) : startPoint;

    }

    public void addController(ControllerInterface controller){
        controllers.add(controller);
    }

    @Override
    public void sendSignals() {
        for (ControllerInterface controller : controllers) {
            controller.setPositionX(posX);
            controller.setPositionY(posY);
        }
    }
}

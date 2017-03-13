package controllers;

import models.ModelInterface;

import javax.swing.*;
import java.awt.*;

public class ExperimentController extends JPanel implements ControllerInterface{

    ModelInterface model;

    int size, posX, posY;

    public ExperimentController(ModelInterface m){

        model = m;
        size = 10;
    }

    @Override
    public void setPositionX(int x) {
        posX = x;
    }

    @Override
    public void setPositionY(int y) {
        posY = y;
    }

    public void draw(Graphics g) {
        g.setColor(Color.CYAN);
        g.fillRect(posX, posY, size, size);
    }
}

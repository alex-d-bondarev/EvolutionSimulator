package controllers;

import models.ModelInterface;
import settings.GameSettings;

import javax.swing.*;
import java.awt.*;

public class CreatureController extends JPanel implements ControllerInterface {

    GameSettings settings = GameSettings.getInstance();
    ModelInterface model;

    int size, posX, posY;

    public CreatureController(ModelInterface m){

        model = m;
        size = settings.getCreatureSize()*settings.getScale();
    }

    public void draw(Graphics g) {
        g.setColor(Color.CYAN);
        g.fillRect(posX, posY, size, size);
    }

    public void setPosX(int pos) { posX = pos; }
    public void setPosY(int pos) { posY = pos; }
}

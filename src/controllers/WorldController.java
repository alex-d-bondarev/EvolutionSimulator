package controllers;

import settings.GameSettings;

import javax.swing.*;
import java.awt.*;

public class WorldController extends JPanel implements ControllerInterface {

    GameSettings settings = GameSettings.getInstance();

    public void draw(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLACK);
        g.fillRect(0,0,settings.getScreenSize()*settings.getScale(),settings.getScreenSize()*settings.getScale());
    }
}

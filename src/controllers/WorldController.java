package controllers;

import javax.swing.*;
import java.awt.*;

public class WorldController extends JPanel {

    public void draw(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.GREEN);
        g.fillRect(20,20,10,10);
    }
}

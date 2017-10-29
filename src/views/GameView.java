package views;

import models.World;
import settings.GameSettings;

import javax.swing.*;
import java.awt.*;

/**
 * My first version of game view
 */
public class GameView extends JPanel implements ViewInterface{

    /**
     * Specify game settings
     */
    GameSettings settings = GameSettings.getInstance();

    /**
     * Constructor:
     * Initialize game parameters: settings, main model and main controller,
     * Initialize and setup JFrame
     */
    public GameView(){
        int windowSize = settings.getWorldSize()*settings.getScale();

        JFrame frame = new JFrame("Evolution Simulator");
        frame.setLocation(settings.getScreenLocation(), settings.getScreenLocation());
        frame.setMinimumSize(new Dimension(windowSize, windowSize));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        frame.getContentPane().add(this);

        frame.pack();
        frame.setVisible(true);
    }

    /**
     * Display world of creatures
     * @param g
     */
    @Override
    protected void paintComponent(Graphics g) {
        World.getInstance().display(g);
    }

    /**
     * Repaint world of creatures
     */
    @Override
    public void draw() {
        repaint();
    }
}

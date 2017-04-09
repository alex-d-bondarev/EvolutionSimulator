package views;

import controllers.ControllerInterface;
import models.ModelInterface;
import controllers.WorldController;
import settings.GameSettings;

import javax.swing.*;
import java.awt.*;

public class ExperimentGameView extends JPanel implements ViewInterface{

    GameSettings settings = GameSettings.getInstance();
    ModelInterface worldModel;
    ControllerInterface worldController = new WorldController();

    public ExperimentGameView(ModelInterface m){
        int windowSize = settings.getScreenSize()*settings.getScale();

        worldModel = m;
        m.addController(worldController);

        JFrame frame = new JFrame("Evolution Simulator");
        frame.setLocation(settings.getScreenLocation(), settings.getScreenLocation());
        frame.setMinimumSize(new Dimension(windowSize, windowSize));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        frame.getContentPane().add(this);

        frame.pack();
        frame.setVisible(true);
    }

    @Override
    protected void paintComponent(Graphics g) {
        worldModel.display(g);
    }

    @Override
    public void updateModel() {
        worldModel.update();
    }

    @Override
    public void draw() {
        repaint();
    }
}

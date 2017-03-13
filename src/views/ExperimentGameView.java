package views;

import models.ModelInterface;
import controllers.ExperimentController;
import controllers.WorldController;

import javax.swing.*;
import java.awt.*;

public class ExperimentGameView extends JPanel implements ViewInterface{

    ModelInterface model;

    WorldController world = new WorldController();
    ExperimentController controller;

    public ExperimentGameView(ModelInterface m, int frameSize){

        model = m;
        controller = new ExperimentController(m);
        m.addController(controller);

        JFrame frame = new JFrame("Evolution Simulator");
        frame.setLocation(50, 50);
        frame.setMinimumSize(new Dimension(frameSize, frameSize));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        frame.getContentPane().add(this);

        frame.pack();
        frame.setVisible(true);
    }

    @Override
    protected void paintComponent(Graphics g) {
        world.draw(g);
        controller.draw(g);
    }

    @Override
    public void updateControllers() {
        model.sendSignals();
    }

    @Override
    public void updateModel() {
        model.update();
    }

    @Override
    public void draw() {
        repaint();
    }
}

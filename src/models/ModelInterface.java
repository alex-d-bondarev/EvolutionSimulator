package models;

import controllers.ControllerInterface;

import java.awt.*;

public interface ModelInterface {

    void addController(ControllerInterface controller);
    void display(Graphics g);
    void update();

}

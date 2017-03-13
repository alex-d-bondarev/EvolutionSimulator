package models;

import controllers.ControllerInterface;

public interface ModelInterface {

    void update();
    void addController(ControllerInterface controller);
    void sendSignals();

}

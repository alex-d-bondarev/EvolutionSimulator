package commands;

import controllers.CreatureController;
import models.CreatureModel;

public interface CommandInterface {
    public void execute(CreatureController world, CreatureModel creature);
}

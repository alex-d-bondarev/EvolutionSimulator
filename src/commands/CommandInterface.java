package commands;

import models.CreatureInterface;
import models.WorldInterface;

public interface CommandInterface {
    void execute(CreatureInterface creature);
}

package commands;


import models.CreatureInterface;
import models.World;
import models.WorldInterface;

public class Move implements CommandInterface {

    @Override
    public void execute(CreatureInterface creature) {
        WorldInterface world = World.getInstance();

        CreatureInterface removeCreature = null;
        int newYPosition = creature.getYPosition() + 1;
        if (newYPosition >= world.getWorldSize()) newYPosition = 0;

        world.addCreature(creature, creature.getXPosition(), newYPosition);
        world.addCreature(removeCreature, creature.getXPosition(), creature.getYPosition());

        creature.setYPosition(newYPosition);
    }
}

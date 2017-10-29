package commands;

import models.CreatureInterface;
import models.WorldInterface;

import java.util.HashMap;
import java.util.Map;

/**
 * Store list of commands. Call needed command if it exists.
 * Return DNA position.
 */
public class Commands{

    private static Map<Integer, CommandInterface> commands = null;

    public static boolean commandExists(int command){
        if(commands == null) initCommands();
        return commands.containsKey(command);
    }

    public static void execute(CreatureInterface creature, int command) {
        if(commands == null) initCommands();
        commands.get(command).execute(creature);
    }

    private static void initCommands(){
        commands = new HashMap<>();
        commands.put(0, new Move());
    }
}

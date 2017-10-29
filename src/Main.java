import models.WorldInterface;
import models.World;
import views.GameView;
import views.ViewInterface;

/**
 * Runs application. Should have no logic, except for key classes initialization.
 */
public class Main {

    /**
     * Run application
     */
    public static void main(String[] args) {

        int gameMoves = 5;

        World.getInstance();
        ViewInterface view = new GameView();

        for (int i = gameMoves; i>0; i--){
        System.out.println("Move# " + i);
            World.getInstance().update();
            view.draw();
            try { Thread.sleep(200); } catch (Exception e) {}
        }
    }
}

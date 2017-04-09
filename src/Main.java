import models.WorldModel;
import models.ModelInterface;
import views.ExperimentGameView;
import views.ViewInterface;

public class Main {

    public static void main(String[] args) {

        int counter = 100;

        ModelInterface model = new WorldModel();
        ViewInterface v = new ExperimentGameView(model);

        while (counter>0){
            counter--;
            v.updateModel();
            v.draw();
            try { Thread.sleep(200); } catch (Exception e) {}
        }
    }
}

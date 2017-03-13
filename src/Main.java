import models.ExperimentModel;
import models.ModelInterface;
import views.ExperimentGameView;
import views.ViewInterface;

public class Main {

    public static void main(String[] args) {

        int counter = 100;
        int frameSize = 100;


        ModelInterface model = new ExperimentModel(frameSize);
        ViewInterface v = new ExperimentGameView(model, frameSize);

        while (counter>0){
            counter--;
            v.updateModel();
            v.updateControllers();
            v.draw();
            try { Thread.sleep(100); } catch (Exception e) {}
        }
    }
}

package settings;

public class GameSettings {

    private static GameSettings settings = null;

    private int creatureSize;
    private int scale;

    private int screenLocation;
    private int screenSize;

    private GameSettings(){
        creatureSize = 1;
        scale = 10;
        screenLocation = 500;
        screenSize = 50;
    }

    public static synchronized GameSettings getInstance(){
        if(settings == null) {
            settings = new GameSettings();
        }
        return settings;
    }

    public int getCreatureSize() {
        return creatureSize;
    }

    public void setCreatureSize(int creatureSize) {
        this.creatureSize = creatureSize;
    }

    public int getScale() {
        return scale;
    }

    public void setScale(int scale) {
        this.scale = scale;
    }

    public int getScreenLocation() {
        return screenLocation;
    }

    public void setScreenLocation(int screenLocation) {
        this.screenLocation = screenLocation;
    }

    public int getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(int screenSize) {
        this.screenSize = screenSize;
    }

}

package settings;

/**
 * Specify game settings. In future will load settings from file.
 */
public class GameSettings {

    /**
     * Self storage
     */
    private static GameSettings settings = null;

    /**
     * Applications scale
     */
    private int scale;

    /**
     * Application's window location on the screen
     */
    private int screenLocation;

    /**
     * Size of the world (there will be maximum worldSize^2 creatures)
     */
    private int worldSize;

    /**
     * Constructor:
     *
     * Initialize settings. TODO: read from config file
     */
    private GameSettings(){
        setScale(10);
        setScreenLocation(500);
        setWorldSize(50);
    }

    /**
     * Get instance of settings
     *
     * @return GameSettings
     */
    public static synchronized GameSettings getInstance(){
        if(settings == null) {
            settings = new GameSettings();
        }
        return settings;
    }


    /////////////////////////////
    //   Getters and setters   //
    /////////////////////////////

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

    public int getWorldSize() {
        return worldSize;
    }

    public void setWorldSize(int worldSize) {
        this.worldSize = worldSize;
    }

}

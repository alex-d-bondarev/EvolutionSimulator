package models;

import commands.Commands;
import settings.GameSettings;

import javax.swing.*;
import java.awt.*;


/**
 * Model for creature
 */
public class Creature extends JPanel implements CreatureInterface{

    /**
     * Creature will be displayed as rectangle with given size, with coordinates of top left corner in posX and posY
     */
    int size, posX, posY;

    /**
     * Will store creature's color.
     */
    Color color = Color.CYAN;

    /**
     * Where is creature looking
     * 0 -> north       x   y--
     * 1 -> north-east  x++ y--
     * 2 -> east        x++ y
     * 3 -> south-east  x++ y++
     * 4 -> south       x   y++
     * 5 -> south-west  x-- y++
     * 6 -> west        x-- y
     * 7 -> nort-west   x-- y--
     */
    private int direction;

    /**
     *  Int array of properties and commands, like:
     *  [1,10,5...], as:
     *  [move creature, change dna position to 10, attack, ...]
     */
    private int[] dna;

    /**
     * Current position in dna (which command from dna to perform)
     */
    private int dnaPosition;

    /**
     * Current energy level (at any moment of turn):
     * 0 - Creature dies
     * Max - Creature creates child and looses half of energy, or
     *       Creature dies, because there is no empty space around for new child, so that it cannot be created
     *          and consume half of energy, so its too much energy to store.
     *       Maximum energy size depends on dna length
     * New creature is born with max/2 energy
     * Energy is encreased, when creature is resting, eating, etc.
     * Energy is decreased, when creature is under attack, moves, etc.
     */
    private int energy;

    /**
     * Energy limit that can be consumed per turn.
     * This parameter will restore to default before each turn.
     * This parameter will decrease with the same speed per turn as energy.
     * If creature has energyPerTurn >= 1 it can perform any command, even the one that consumes more energy,
     *  than Creature has in energy and energyPerTurn parameters
     *
     * This parameter will help to limit creature from doing to much staff per turn
     */
    private int energyPerTurn;

    /**
     * Creature with more strength goes first.
     * Creature is consuming strength * commandPrice energy per turn.
     */
    private int strength;

    /**
     * Constructor:
     * Create default creature
     */
    public Creature(){
        dna = new int[1];
        dna[0] = 1;
        dnaPosition = 0;
        strength = 1;
        energy = 1;
        direction = 1;
        energyPerTurn = 1;
        size = GameSettings.getInstance().getScale();
    }


    /**
     * Send controller signal to draw creature
     *
     * @param g Graphics
     */
    public void display(Graphics g) {
        g.setColor(color);
        g.fillRect(posX, posY, size, size);
    }

    /**
     * Perform commands (dnaPosition) from dna, based on creature's parameters
     */
    @Override
    public void update() {
        int command = dnaPosition;
        if(Commands.commandExists(command)) Commands.execute(this, command);
    }

    /////////////////////////////
    //   Getters and setters   //
    /////////////////////////////

    @Override
    public void setXPosition(int x) {
        posX = x;
    }

    @Override
    public void setYPosition(int y) {
        posY = y;
    }

    @Override
    public int getXPosition() {
        return posX;
    }

    @Override
    public int getYPosition() {
        return posY;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int[] getDna() {
        return dna;
    }

    public void setDna(int[] dna) {
        this.dna = dna;
    }

    public int getDnaPosition() {
        return dnaPosition;
    }

    public void setDnaPosition(int dnaPosition) {
        this.dnaPosition = dnaPosition;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getEnergy() {
        return energy;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
    }

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public int getEnergyPerTurn() {
        return energyPerTurn;
    }

    public void setEnergyPerTurn(int energyPerTurn) {
        this.energyPerTurn = energyPerTurn;
    }

}

package models;

import controllers.ControllerInterface;
import controllers.CreatureController;

import java.awt.*;


public class CreatureModel implements ModelInterface {

    CreatureController creatureController;

    // Where is creature looking (see move Command)
    // 0 -> north       x   y--
    // 1 -> north-east  x++ y--
    // 2 -> east        x++ y
    // 3 -> south-east  x++ y++
    // 4 -> south       x   y++
    // 5 -> south-west  x-- y++
    // 6 -> west        x-- y
    // 7 -> nort-west   x-- y--
    private int direction;

    // array of properties and commands
    private int[] dna;

    // current position in dna (which command from dna to perform)
    private int dnaPosition;

    // determines current energy level
    private int energy;

    // How much energy can be used per turn
    // Conditional commands, like Observe, do not stop creature's turn, but consume 1 energy
    // This parameter will help to limit creature from thinking too much
    private int energyPerTurn;

    // determines speed\power of each action and energy consumption by this action
    private int strength;

    public CreatureModel(){
        dna = new int[1];
        dna[0] = 1;
        dnaPosition = 0;
        strength = 1;
        energy = 1;
        direction = 1;
        energyPerTurn = 1;
    }

    @Override
    public void addController(ControllerInterface controller) {
        creatureController = (CreatureController) controller;
    }

    @Override
    public void display(Graphics g) {
        creatureController.draw(g);
    }

    @Override
    public void update() {

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


    public void setPosX(int pos) { creatureController.setPosX(pos); }
    public void setPosY(int pos) { creatureController.setPosY(pos); }
}

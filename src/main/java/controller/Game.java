package controller;

import logic.brick.Brick;
import logic.level.Level;
import logic.level.Levels;


import java.util.List;
import java.util.Observable;
import java.util.Observer;

/**
 * Game logic controller class.
 *
 * @author Fabiola Rivera
 */

public class Game implements Observer {

    private int myBalls;
    private Level currentLevel;
    private boolean winner;


    public Game(int balls) {
        this.winner = false;
        this.myBalls = balls;
        this.currentLevel = new Levels("Invalid Level", 0, 0.0, 0.0, 0);
        ((Levels) this.currentLevel).addObserver(this);
        // TODO more
    }

    /**
     * Checks whether the game has a winner or not
     *
     * @return true if the game has a winner, false otherwise
     */
    public boolean winner() {
        return this.winner;
    }

    public Level newLevelWithBricksFull(String name, int numberOfBricks, double probOfGlass, double probOfMetal, int seed) {
        Levels n = new Levels(name, numberOfBricks, probOfGlass, probOfMetal, seed);
        n.addObserver(this);
        return n;
    }

    public Level newLevelWithBricksNoMetal(String name, int numberOfBricks, double probOfGlass, int seed) {
        Levels n = new Levels(name, numberOfBricks, probOfGlass, 0.0, seed);
        n.addObserver(this);
        return n;
    }

    public int numberOfBricks() {
        return this.currentLevel.getNumberOfBricksLeft();
    }

    public List<Brick> getBricks() {
        return this.currentLevel.getBricks();
    }

    public boolean hasNextLevel() {
        return this.currentLevel.hasNextLevel();
    }

    public void goNextLevel() {
        if (this.currentLevel.hasNextLevel()) {
            setCurrentLevel(this.currentLevel.getNextLevel());
        } else {
            setCurrentLevel(new Levels("Game over", 0, 0.0, 0.0, 0));
        }
    }

    public boolean hasCurrentLevel() {
        return this.currentLevel.isPlayableLevel();
    }

    public String getLevelName() {
        return this.currentLevel.getName();
    }

    public Level getCurrentLevel() {
        return this.currentLevel;
    }

    public void setCurrentLevel(Level level) {
        this.currentLevel = level;
        ((Levels) level).addObserver(this);
    }

    public void addPlayingLevel(Level level) {
        ((Levels) level).addObserver(this);
        this.currentLevel.addPlayingLevel(level);
    }

    public int getLevelPoints() {
        return this.currentLevel.getPoints();
    }

    public int getCurrentPoints() {
        return this.currentLevel.getCurrentPoints();
    }

    public int getBallsLeft() {
        return this.myBalls;
    }

    public int dropBall() {
        if (this.myBalls > 0) {
            this.myBalls -= 1;
        }
        return this.myBalls;
    }

    public boolean isGameOver() {
        return winner() || (this.myBalls == 0);
    }

    @Override
    public void update(Observable o, Object arg) {
        // TODO implementar
    }
}

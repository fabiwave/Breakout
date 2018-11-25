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
    private int currentAccumulatedScore = 0;
    private boolean winner;


    public Game(int balls) {
        this.winner = false;
        this.myBalls = balls;
        this.currentLevel = new Levels("", 0, 0.0, 0.0, 0);
        ((Levels) this.currentLevel).addObserver(this);
    }

    /**
     * Checks whether the game has a winner or not
     *
     * @return true if the game has a winner, false otherwise
     */
    public boolean winner() {
        return this.winner;
    }

    /**
     * Creates a new level with the given parameters.
     *
     * @param name           the name of the level
     * @param numberOfBricks the number of bricks in the level
     * @param probOfGlass    the probability of a {@link logic.brick.GlassBrick}
     * @param probOfMetal    the probability of a {@link logic.brick.MetalBrick}
     * @param seed           the seed for the random number generator
     * @return a new level determined by the parameters
     * @see Level
     */
    public Level newLevelWithBricksFull(String name, int numberOfBricks, double probOfGlass, double probOfMetal, int seed) {
        Levels n = new Levels(name, numberOfBricks, probOfGlass, probOfMetal, seed);
        n.addObserver(this);
        return n;
    }

    /**
     * Creates a new level without MetalBrick with the given parameters.
     *
     * @param name           the name of the level
     * @param numberOfBricks the number of bricks in the level
     * @param probOfGlass    the probability of a {@link logic.brick.GlassBrick}
     * @param seed           the seed for the random number generator
     * @return a new level determined by the parameters
     * @see Level
     */
    public Level newLevelWithBricksNoMetal(String name, int numberOfBricks, double probOfGlass, int seed) {
        Levels n = new Levels(name, numberOfBricks, probOfGlass, 0.0, seed);
        n.addObserver(this);
        return n;
    }

    /**
     * Gets the number of {@link Brick} in the current level, that are still not destroyed
     *
     * @return the number of intact bricks in the current level
     */
    public int numberOfBricks() {
        return this.currentLevel.getNumberOfBricksLeft();
    }

    /**
     * Gets the list of {@link Brick} in the current level.
     *
     * @return the list of bricks
     */
    public List<Brick> getBricks() {
        return this.currentLevel.getBricks();
    }

    /**
     * Whether the current {@link Level}'s next level is playable or not.
     *
     * @return true if the current level's next level is playable, false otherwise
     */
    public boolean hasNextLevel() {
        return this.currentLevel.hasNextLevel();
    }

    /**
     * Pass to the next level of the current {@link Level}. Ignores all conditions and skip to the next level.
     */
    public void goNextLevel() {
        if (this.currentLevel.hasNextLevel()) {
            setCurrentLevel(this.currentLevel.getNextLevel());
        } else {
            if (this.myBalls > 0) {
                this.winner = true;
            }
            setCurrentLevel(new Levels("Game over", 0, 0.0, 0.0, 0));
        }
    }

    /**
     * Gets whether the current {@link Level} is playable or not.
     *
     * @return true if the current level is playable, false otherwise
     */
    public boolean hasCurrentLevel() {
        return this.currentLevel.isPlayableLevel();
    }

    /**
     * Gets the name of the current {@link Level}.
     *
     * @return the name of the current level
     */
    public String getLevelName() {
        return this.currentLevel.getName();
    }

    /**
     * Gets the current {@link Level}.
     *
     * @return the current level
     * @see Level
     */
    public Level getCurrentLevel() {
        return this.currentLevel;
    }

    /**
     * Sets a {@link Level} as the current playing level.
     *
     * @param level the level to be used as the current level
     * @see Level
     */
    public void setCurrentLevel(Level level) {
        this.currentLevel = level;
        ((Levels) level).addObserver(this);
    }

    /**
     * Adds a level to the list of {@link Level} to play. This adds the level in the last position of the list.
     *
     * @param level the level to be added
     */
    public void addPlayingLevel(Level level) {
        ((Levels) level).addObserver(this);
        this.currentLevel.addPlayingLevel(level);
    }

    /**
     * Gets the number of points required to pass to the next level. Gets the points obtainable in the current {@link Level}.
     *
     * @return the number of points in the current level
     */
    public int getLevelPoints() {
        return this.currentLevel.getPoints();
    }

    /**
     * Gets the accumulated points through all levels and current {@link Level}.
     *
     * @return the cumulative points
     */
    public int getCurrentPoints() {
        return this.currentAccumulatedScore;
    }

    /**
     * Gets the current number of available balls to play.
     *
     * @return the number of available balls
     */
    public int getBallsLeft() {
        return this.myBalls;
    }

    /**
     * Reduces the count of available balls and returns the new number.
     *
     * @return the new number of available balls
     */
    public int dropBall() {
        if (this.myBalls > 0) {
            this.myBalls -= 1;

            if (this.myBalls == 0) {
                this.currentLevel.setNextLevel(null);
                this.goNextLevel();
            }
        }
        return this.myBalls;
    }

    /**
     * Checks whether the game is over or not. A game is over when the number of available balls are 0 or the player won the game.
     *
     * @return true if the game is over, false otherwise
     */
    public boolean isGameOver() {
        return winner() || (this.myBalls == 0);
    }

    /**
     * Updates the game base of the type of notification from the observables
     * @param o
     * @param arg
     */
    @Override
    public void update(Observable o, Object arg) {
        int action = ((int) arg);

        if (action == 0) {
            this.goNextLevel();
        } else if (action == 1) {
            this.myBalls += 1;
        } else {
            this.currentAccumulatedScore += action;
        }
    }
}

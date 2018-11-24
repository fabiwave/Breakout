package logic.level;

import logic.brick.Brick;

import java.util.List;

/**
 * Interface that represents the basics of a level to be played on.
 *
 * @author Fabiola Rivera
 */
public interface Level {
    /**
     * Gets the level's name, number of Bricks, prob of GlassBrick, prob of MetalBrick and a seed
     *
     *
     * @return the table's name
     */

    String getName();

    /**
     * Gets the number of {@link Brick} in the level.
     *
     * @return the number of Bricks in the level
     */
    int getNumberOfBricks();

    /**
     * Gets the {@link List} of {@link Brick}s in the level.
     *
     * @return the bricks in the level
     */
    List<Brick> getBricks();

    /**
     * Gets the next level of a level object. Each level have a reference to the next level to play.
     *
     * @return the next level
     */
    Level getNextLevel();

    /**
     * Gets whether the level is playable or not.
     *
     * @return true if the level is playable, false otherwise
     */
    boolean isPlayableLevel();

    /**
     * Whether the level's next level is playable or not.
     *
     * @return true if the level's next level is playable, false otherwise
     */
    boolean hasNextLevel();

    /**
     * Gets the total number of points obtainable in level.
     *
     * @return the number of points in the current level
     */
    int getPoints();

    /**
     * Adds a level to the list of levels. This adds the level in the last position of the list.
     *
     * @param level the level to be added
     */
    Level addPlayingLevel(Level level);

    /**
     * Sets the reference for the next level of a level object.
     *
     * @param level the next level of a level object
     */
    void setNextLevel(Level level);

    /**
     * Adds the score to the current points of the level
     * @param Score
     */
    void addScore(int Score);

    /**
     * Notifies to the observer of a change
     */
    void addBall();

    /**
     * Gives the number of brick that has not been destroyed in the current level
     * @return the number of brick left in a level
     */
    int getNumberOfBricksLeft();

    /**
     * Gives the score that the level has
     * @return the current score
     */
    int getCurrentPoints();
}

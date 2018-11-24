package logic.brick;

import logic.level.Level;

/**
 * Interface that represents a brick object.
 * All bricks should implement this interface.
 *
 * @author Fabiola Rivera
 */

public interface Brick {

    /**
     * Defines that a brick has been hit.
     * Notifies to the observers that a brick has been hit
     */
    void hit();

    /**
     * Gets whether the brick object is destroyed or not.
     *
     * @return true if the brick is destroyed, false otherwise
     */
    boolean isDestroyed();

    /**
     * Gets the points corresponding to the destroying of a brick object.
     *
     * @return the associated points of a brick object
     */
    int getScore();

    /**
     * Gets the remaining hits the brick has to receive before being destroyed.
     *
     * @return the remaining hits to destroy de brick
     */
    int remainingHits();

    //todo javadoc
    void effect(Level level);
}

package logic.brick;

import logic.level.Level;
import logic.level.Levels;

import java.util.Observable;

public abstract class Bricks extends Observable implements Brick {

    int brickScore;
    int totalHits;

    Bricks(Level level) {
        this.addObserver((Levels) level);
    }

    public void hit() {
        if (!isDestroyed()) {
            this.totalHits -= 1;

            if (this.isDestroyed()) {
                this.setChanged();
                this.notifyObservers();
            }
        }
    }

    public boolean isDestroyed() {
        return (this.totalHits == 0);
    }

    public int getScore() {
        return this.brickScore;
    }

    public int remainingHits() {
        return totalHits;
    }

    public void effect(Level level) {
        level.addScore(this.brickScore);
    }
}


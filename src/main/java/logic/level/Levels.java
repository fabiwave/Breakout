package logic.level;

import logic.brick.Brick;
import logic.brick.GlassBrick;
import logic.brick.WoodenBrick;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.Random;

public class Levels extends Observable implements Level, Observer {

    // TODO Cosas de Observable

    private String levelName;
    private int numberOfBricks;
    private ArrayList<Brick> brickList;
    private Level nextLevel = null;
    private int maxPoints = 0;
    private int currentPoints = 0;
    private boolean isPlayable;

    public Levels(String name, int numberOfBricks, double probOfGlass, double probOfMetal, int seed) {
        this.levelName = name;
        Random random = new Random(seed);
        this.brickList = new ArrayList<>();

        for (int i = 0; i < numberOfBricks; i++) {
            double randomGenerator = random.nextDouble();
            Brick aBrick;

            if (randomGenerator > probOfGlass) {
                aBrick = new WoodenBrick(this);
                brickList.add(aBrick);
            } else {
                aBrick = new GlassBrick(this);
                brickList.add(aBrick);
            }

            this.maxPoints += aBrick.getScore();
        }
        // TODO Crear los MetalBricks

        this.numberOfBricks = this.brickList.size();
        this.isPlayable = (this.numberOfBricks > 0);
    }


    @Override
    public void update(Observable o, Object arg) {
        // TODO Implementar
    }

    @Override
    public String getName() {
        return this.levelName;
    }

    @Override
    public int getNumberOfBricks() {
        return this.numberOfBricks;
    }

    @Override
    public List<Brick> getBricks() {
        return this.brickList;
    }

    @Override
    public Level getNextLevel() {
        return this.nextLevel;
    }

    @Override
    public boolean isPlayableLevel() {
        return this.isPlayable;
    }

    @Override
    public boolean hasNextLevel() {
        if (this.nextLevel == null) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public int getPoints() {
        return this.maxPoints;
    }

    @Override
    public Level addPlayingLevel(Level level) {
        if (this.hasNextLevel()) {
            this.nextLevel.addPlayingLevel(level);
        } else {
            this.setNextLevel(level);
        }

        return level;
    }

    @Override
    public void setNextLevel(Level level) {
        this.nextLevel = level;
    }
}

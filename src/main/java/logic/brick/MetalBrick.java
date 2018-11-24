package logic.brick;

import logic.level.Level;

public class MetalBrick extends Bricks{

    public MetalBrick(Level level){
        super(level);
        this.totalHits = 10;
        this.brickScore = 0;
    }

    @Override
    public void effect(Level level) {
        level.addBall();
    }
}

package logic.brick;

import logic.level.Level;

public class WoodenBrick extends Bricks{

    public WoodenBrick(Level level){
        super(level);
        this.totalHits = 3;
        this.brickScore = 200;
    }
}

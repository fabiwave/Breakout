package logic.brick;

import logic.level.Level;

public class GlassBrick extends Bricks {

    public GlassBrick(Level level){
        super(level);
        this.totalHits = 1;
        this.brickScore = 50;
    }
}

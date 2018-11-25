package logic.brick;

import logic.level.Level;
import logic.level.Levels;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class GlassBrickTest {

    private GlassBrick glass;
    private Level level;

    @Before
    public void setUp(){
        glass = new GlassBrick();
        level = new Levels("test",20,0.5,0.5,0);
    }

    @Test
    public void hit() {
    }

    @Test
    public void isDestroyed() {
        assertFalse(glass.isDestroyed());
    }


    @Test
    public void remainingHits() {
        assertEquals(glass.totalHits, 1);
    }
    
}
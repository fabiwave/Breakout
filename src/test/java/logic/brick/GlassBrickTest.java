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
        glass.addObserver(((Levels) level));
        glass.hit();
        assertEquals(0, glass.remainingHits());
        assertTrue(glass.isDestroyed());
        assertEquals(50, level.getCurrentPoints());
        glass.hit();
        assertEquals(0, glass.remainingHits());
        assertEquals(50, level.getCurrentPoints());
    }

    @Test
    public void isDestroyed() {
        assertFalse(glass.isDestroyed());
    }

    @Test
    public void getScore() {
        assertEquals(50, glass.getScore());
    }

    @Test
    public void remainingHits() {
        assertEquals(1, glass.totalHits);
    }

    @Test
    public void effect() {
        glass.effect(level);
        assertEquals(50 ,level.getCurrentPoints());
    }
}
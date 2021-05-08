import hu.elte.madtycoon.core.Resources;
import hu.elte.madtycoon.core.World;
import hu.elte.madtycoon.objects.buildings.decoration.Bush;
import hu.elte.madtycoon.objects.buildings.decoration.FirePit;
import hu.elte.madtycoon.objects.buildings.decoration.Flower;
import hu.elte.madtycoon.objects.buildings.decoration.Stick;
import hu.elte.madtycoon.render.AnimationResource;
import hu.elte.madtycoon.utils.Vector2F;
import hu.elte.madtycoon.utils.Vector2I;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class DecorationsTest {

    public World world;

    @Before
    public void createWorld() {
        try {
            Resources.Instance.load();
            AnimationResource.Instance.load();
        } catch (Exception exception) {

        }
        world = new World();
    }

    @Test
    public void createBush() {
        Bush bush = Bush.Create(world,new Vector2F(3,3));

        assertEquals(bush.getName(), "Bush");
        assertEquals(0.15F,bush.getDecorationValue(),0.0);
    }

    @Test
    public void createFirePit() {
        FirePit firePit = FirePit.Create(world,new Vector2F(10,34));

        assertEquals(0.5F, firePit.getDecorationValue(), 0.0);
        assertFalse(firePit.getName() == "Bush");
    }

    @Test
    public void createFlower() {
        Flower flower = Flower.Create(world, new Vector2F(23,12));

        assertEquals(flower.getName(), "Flower");
        assertEquals(0.25, flower.getDecorationValue(), 0.0);
        assertEquals(flower.getSize(), new Vector2I(1,1));
        assertEquals(flower.getPosition(), new Vector2F(23,12));
    }

    @Test
    public void createStick() {
        Stick stick = Stick.Create(world, new Vector2F(53,3));

        assertEquals(stick.getName(), "Stick");
        assertEquals(stick.getPosition(), new Vector2F(53,3));
    }
}

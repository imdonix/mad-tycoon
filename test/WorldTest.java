import hu.elte.madtycoon.core.Resources;
import hu.elte.madtycoon.core.World;
import hu.elte.madtycoon.objects.Building;
import hu.elte.madtycoon.objects.buildings.games.GhostCastle;
import hu.elte.madtycoon.objects.buildings.games.RoundAbout;
import hu.elte.madtycoon.objects.entities.Cleaner;
import hu.elte.madtycoon.objects.entities.ShopAssistant;
import hu.elte.madtycoon.objects.entities.Visitor;
import hu.elte.madtycoon.render.AnimationResource;
import hu.elte.madtycoon.utils.Vector2F;
import hu.elte.madtycoon.utils.Vector2I;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class WorldTest {

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
    public void earnMoney() {
        world.earn(2000);

        assertEquals(world.getMoney(), 7000);
    }

    @Test
    public void payMoney() {
        world.pay(2500);

        assertEquals(world.getMoney(), 2500);
    }

    @Test
    public void instantiateGameObjects() {
        Cleaner cleaner = Cleaner.Create(world, new Vector2F(4,5));
        Visitor visitor = Visitor.Create(world, new Vector2F(6,7));
        ShopAssistant shopAssistant = ShopAssistant.Create(world, new Vector2F(0,0));

        world.instantiate(cleaner);
        world.instantiate(shopAssistant);
        world.instantiate(visitor);

        GhostCastle ghostCastle = GhostCastle.Create(world, new Vector2F(20,3));
        RoundAbout roundAbout = RoundAbout.Create(world, new Vector2F(56,24));

        world.instantiate(ghostCastle);
        world.instantiate(roundAbout);

        assertEquals(world.getBuildings().size(), 3);
        assertEquals(world.getGames().size(),2);
        assertEquals(world.getStatistics().getAllVisitorCount(),1);
        assertEquals(world.getWorkers().size(),2);
    }

    @Test
    public void checkHappines() {
        Cleaner cleaner = Cleaner.Create(world, new Vector2F(4,5));
        Visitor visitor = Visitor.Create(world, new Vector2F(6,7));
        ShopAssistant shopAssistant = ShopAssistant.Create(world, new Vector2F(0,0));

        world.instantiate(cleaner);
        world.instantiate(shopAssistant);
        world.instantiate(visitor);

        float happines = world.getHappiness();

        assertEquals(1F, happines, 0.2);
    }

    @Test
    public void collisionCheck() {
        GhostCastle ghostCastle = GhostCastle.Create(world, new Vector2F(20,3));
        RoundAbout roundAbout = RoundAbout.Create(world, new Vector2F(56,24));

        world.instantiate(ghostCastle);
        world.instantiate(roundAbout);

        Building building1 = world.collisionCheck(new Vector2I(10,23),new Vector2I(4,5));
        Building building2 = world.collisionCheck(new Vector2I(20,3), new Vector2I(3,4));
        Building building3 = world.collisionCheck(new Vector2I(56,12), new Vector2I(2,23));

        assertEquals(building1, null);
        assertEquals(building2, ghostCastle);
        assertEquals(building3, roundAbout);
    }

    @Test
    public void collisionWithMultipleBuildings() {
        GhostCastle ghostCastle = GhostCastle.Create(world, new Vector2F(20,25));
        RoundAbout roundAbout = RoundAbout.Create(world, new Vector2F(56,24));

        world.instantiate(ghostCastle);
        world.instantiate(roundAbout);

        List<Building> buildings1 = world.collisionCheckMultiple(new Vector2I(10,23),new Vector2I(4,5));
        List<Building> buildings2 = world.collisionCheckMultiple(new Vector2I(56,24), new Vector2I(4,4));
        List<Building> buildings3 = world.collisionCheckMultiple(new Vector2I(20, 24), new Vector2I(50,50));

        assertEquals(buildings1.size(), 0);
        assertEquals(buildings2.size(), 1);
        assertEquals(buildings3.size(), 2);
    }
}

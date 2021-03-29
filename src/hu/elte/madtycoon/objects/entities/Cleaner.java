package hu.elte.madtycoon.objects.entities;

import hu.elte.madtycoon.core.World;
import hu.elte.madtycoon.objects.Worker;
import hu.elte.madtycoon.objects.buildings.Road;
import hu.elte.madtycoon.render.AnimatedSprite;
import hu.elte.madtycoon.task.Task;
import hu.elte.madtycoon.task.employee.FindRoad;
import hu.elte.madtycoon.utils.Random;
import hu.elte.madtycoon.utils.Vector2F;

import java.util.LinkedList;
import java.util.List;

public class Cleaner extends Worker {

    public static int START_MONEY = 100;
    public static float START_FOOD = 1f;
    public static float START_INT = 1f;
    public static float MIN_MS_SPEED = 1.5F;
    public static float MAX_MS_SPEED = 3F;
    public static int SALARY = 75;

    private final float movementSpeed;

    private Cleaner(World world, AnimatedSprite sprite, Vector2F position) {
        super(world, sprite, position, SALARY);
        this.money = START_MONEY;
        this.food = START_FOOD;
        this.interest = START_INT;
        this.movementSpeed = Random.getRandomFloat(MIN_MS_SPEED, MAX_MS_SPEED);
    }

    @Override
    protected void start() {}

    @Override
    public float getMovementSpeed()
    {
        return movementSpeed;
    }

    @Override
    protected Task getNewTask() {
        List<Road> roads = getRoadsWithLowHealth();

        System.out.println(roads.size());

        if(roads.size() > 0) {
            return new FindRoad(this, findNearestRoad(roads));
        } else {
            System.out.println(String.format("%s can't be employed!", this));
            return super.getNewTask();
        }
    }

    @Override
    public void onDestroy() { }

    private List<Road> getRoadsWithLowHealth()
    {
        List<Road> tmp = new LinkedList<>();
        for(Road road : world.getRoads()) {
            if(road.getHealth() < 0.5F) {
                tmp.add(road);
            }
        }
        return tmp;
    }

    protected Road findNearestRoad(List<Road> roads)
    {
        Road min = roads.get(0);
        for(Road road : roads)
            if(min.getPosition().distance(getPosition()) > road.getPosition().distance(getPosition()))
                min = road;
        return min;
    }
}

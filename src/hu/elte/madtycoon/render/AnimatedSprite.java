package hu.elte.madtycoon.render;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.util.HashMap;

public class AnimatedSprite
{
    public final static String IDLE = "idle";
    public final static String WALK = "walk";
    public final static String GAME_PLAY = "gameplay";
    public final static String GAME_STOP = "gamestop";
    public final static String GAME_UNDER_CONSTRUCTION = "construction";


    public final static String PARK_EARN = "pearn";

    public final static String VISITOR_EARN = "vearn";
    public final static String VISITOR_HAPPY = "vhappy";
    public final static String VISITOR_SAD = "vsad";
    public final static String VISITOR_HUNGRY = "vhungry";
    public final static String VISITOR_FOOD = "vfood";

    public final static String REPAIR = "repair";
    public final static String NEED_REPAIR = "nrepair";

    public final static String ROAD_DIRTY = "dirty";
    public static final String CLEAN = "clean";

    public final static String NOTIFICATION = "notification";


    private final HashMap<String, BufferedImage[]> sprites;
    private final float frameLength;
    private String state;
    private float time;
    private int animFrame;
    private boolean rotation;

    public AnimatedSprite(String startState, BufferedImage[] startAnimation, float frameLength)
    {
        this.sprites = new HashMap<String, BufferedImage[]>();
        this.sprites.put(startState, startAnimation);
        this.state = startState;
        this.frameLength = frameLength;
        this.time = 0;
        this.animFrame = 0;
    }

    public void addState(String state, BufferedImage[] animation)
    {
        sprites.put(state, animation);
    }

    public void setRotation(boolean lookToRight)
    {
        rotation = lookToRight;
    }

    public boolean getRotation(){ return rotation; }

    public void setState(String state)
    {
        if(!sprites.containsKey(state))
            throw new IllegalArgumentException("This animated sprite doesn't have this state");

        this.state = state;
    }

    public void update(float dt)
    {
        time+=dt;
        if(time > frameLength)
        {
            animFrame++;
            time = time - frameLength;
        }
    }
    
    public BufferedImage getSprite()
    {
        BufferedImage[] images = sprites.get(state);
        return applyRotation(images[animFrame % images.length], rotation);
    }


    private static BufferedImage applyRotation(BufferedImage image, boolean rotation)
    {
        if(!rotation) return image;

        BufferedImage mirrored = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_INT_ARGB);

        Graphics2D graphics = (Graphics2D)mirrored.getGraphics();
        AffineTransform transform = new AffineTransform();
        transform.setToScale(-1, 1);
        transform.translate(-image.getWidth(), 0);
        graphics.setTransform(transform);
        graphics.drawImage(image, 0, 0, null);

        return mirrored;
    }
}

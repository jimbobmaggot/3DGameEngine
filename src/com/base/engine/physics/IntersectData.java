package com.base.engine.physics;

/**
 *
 * @author Stephen Rumpel
 */
public class IntersectData
{

    private final boolean doesIntersect;
    private final float distance;

    public IntersectData(boolean doesIntersect, float distance)
    {
        this.doesIntersect = doesIntersect;
        this.distance = distance;
    }

    public float getDistance()
    {
        return distance;
    }

    public boolean getDoesIntersect()
    {
        return doesIntersect;
    }
}

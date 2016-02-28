package com.base.engine.physics;

import com.base.engine.core.Vector3f;

/**
 *
 * @author Stephen Rumpel
 */
public class IntersectData
{

    private final boolean doesIntersect;
    public final Vector3f direction;
    
    public IntersectData()
    {
        this.doesIntersect = false;
        this.direction = new Vector3f();
    }

    public IntersectData(boolean doesIntersect, Vector3f direction)
    {
        this.doesIntersect = doesIntersect;
        this.direction = direction;
    }

    public float getDistance()
    {
        return getDirection().length();
    }

    public boolean getDoesIntersect()
    {
        return doesIntersect;
    }

    public Vector3f getDirection()
    {
        return direction;
    }
}

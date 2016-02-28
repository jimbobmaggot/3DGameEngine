package com.base.engine.physics;

import com.base.engine.core.Vector3f;

/**
 *
 * @author Stephen Rumpel
 */
public class BoundingSphere
{

    private final Vector3f center;
    private final float radius;
    
    public BoundingSphere()
    {
        this.center = new Vector3f();
        this.radius = 1.0f;
    }
    
    public BoundingSphere(float x, float y, float z)
    {
        this.center = new Vector3f(x, y, z);
        this.radius = 1.0f;
    }
    
    public BoundingSphere(float x, float y, float z, float r)
    {
        this.center = new Vector3f(x, y, z);
        this.radius = r;
    }
    
    public BoundingSphere(Vector3f center)
    {
        this.center = center;
        this.radius = 1.0f;
    }

    public BoundingSphere(Vector3f center, float radius)
    {
        this.center = center;
        this.radius = radius;
    }

    public IntersectData intersectBoundingSphere(BoundingSphere other)
    {
        float radiusDistance = radius + other.getRadius();
        float centerDistance = other.getCenter().sub(center).length();
        float distance = centerDistance - radiusDistance;

        return new IntersectData(centerDistance < radiusDistance, distance);
    }

    public Vector3f getCenter()
    {
        return center;
    }

    public float getRadius()
    {
        return radius;
    }

}

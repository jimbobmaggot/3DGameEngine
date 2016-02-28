package com.base.engine.physics;

import com.base.engine.core.Vector3f;

/**
 *
 * @author Stephen Rumpel
 */
public class BoundingSphere extends Collider
{

    private Vector3f center;
    private final float radius;
    
    public BoundingSphere()
    {
        super(Type.Sphere);
        this.center = new Vector3f();
        this.radius = 1.0f;
    }
    
    public BoundingSphere(float x, float y, float z)
    {
        super(Type.Sphere);
        this.center = new Vector3f(x, y, z);
        this.radius = 1.0f;
    }
    
    public BoundingSphere(float x, float y, float z, float r)
    {
        super(Type.Sphere);
        this.center = new Vector3f(x, y, z);
        this.radius = r;
    }
    
    public BoundingSphere(Vector3f center)
    {
        super(Type.Sphere);
        this.center = center;
        this.radius = 1.0f;
    }

    public BoundingSphere(Vector3f center, float radius)
    {
        super(Type.Sphere);
        this.center = center;
        this.radius = radius;
    }

    public IntersectData intersectBoundingSphere(BoundingSphere other)
    {
        float radiusDistance = radius + other.getRadius();
        Vector3f direction = other.getCenter().sub(center);
        float centerDistance = direction.length();
        direction = direction.div(centerDistance);
        
        float distance = centerDistance - radiusDistance;

        return new IntersectData(distance < 0, direction.mul(distance));
    }
    
    @Override
    public void transform(Vector3f translation)
    {
        center = center.add(translation);
    }

    @Override
    public Vector3f getCenter()
    {
        return center;
    }

    public float getRadius()
    {
        return radius;
    }

}

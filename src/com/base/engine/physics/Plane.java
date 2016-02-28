package com.base.engine.physics;

import com.base.engine.core.Vector3f;

/**
 *
 * @author Stephen Rumpel
 */
public class Plane
{

    public final Vector3f normal;
    public final float distance;
    
    public Plane()
    {
        this.normal = new Vector3f(0.0f, 1.0f, 0.0f);
        this.distance = 0.0f;
    }
    
    public Plane(Vector3f normal)
    {
        this.normal = normal;
        this.distance = 0.0f;
    }
    
    public Plane(float distance)
    {
        this.normal = new Vector3f(0.0f, 1.0f, 0.0f);
        this.distance = distance;
    }

    public Plane(Vector3f normal, float distance)
    {
        this.normal = normal;
        this.distance = distance;
    }
    
    public Plane normalized()
    {
        float magnitude = normal.length();
        return new Plane(normal.normalized(magnitude), distance/magnitude);
    }
    
    public IntersectData intersectSphere(BoundingSphere other)
    {
        float distanceFromSphereCenter = Math.abs(normal.dot(other.getCenter()) + distance);
        float distanceFromSphere = distanceFromSphereCenter - other.getRadius();
        
        return new IntersectData(distanceFromSphere < 0 , distanceFromSphere);
    }

    public float getDistance()
    {
        return distance;
    }

    public Vector3f getNormal()
    {
        return normal;
    }
}

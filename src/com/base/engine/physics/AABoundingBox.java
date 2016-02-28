package com.base.engine.physics;

import com.base.engine.core.Vector3f;

/**
 *
 * @author Stephen Rumpel
 */
public class AABoundingBox
{

    private final Vector3f minExtents;
    private final Vector3f maxExtents;
    
    public AABoundingBox()
    {
        this.minExtents = new Vector3f();
        this.maxExtents = new Vector3f(1.0f, 1.0f, 1.0f);
    }

    public AABoundingBox(Vector3f minExtents, Vector3f maxExtents)
    {
        this.minExtents = minExtents;
        this.maxExtents = maxExtents;
    }

    public IntersectData IntersectAABoundingBox(AABoundingBox other)
    {
        Vector3f distances1 = other.getMinExtents().sub(maxExtents);
        Vector3f distances2 = minExtents.sub(other.getMaxExtents());
        Vector3f distances = distances1.max(distances2);

        float maxDistance = distances.max();

        return new IntersectData(maxDistance < 0, maxDistance);
    }

    public Vector3f getMaxExtents()
    {
        return maxExtents;
    }

    public Vector3f getMinExtents()
    {
        return minExtents;
    }
}

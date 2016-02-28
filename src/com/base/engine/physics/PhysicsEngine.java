package com.base.engine.physics;

import com.base.engine.core.Vector3f;
import java.util.ArrayList;

/**
 *
 * @author Stephen Rumpel
 */
public class PhysicsEngine
{

    private final ArrayList<PhysicsObject> objects;

    public PhysicsEngine()
    {
        this.objects = new ArrayList<>();
    }

    public void addObject(PhysicsObject object)
    {
        objects.add(object);
    }

    public void simulate(float delta)
    {
        for (int i = 0; i < getObjects().size(); i++)
        {
            objects.get(i).integrate(delta);
        }
    }

    public void handleCollisions()
    {
        for (int i = 0; i < getObjects().size(); i++)
        {
            for (int j = i + 1; j < getObjects().size(); j++)
            {
                IntersectData intersectData
                        = objects.get(i).getCollider().intersect(
                        objects.get(j).getCollider());

                if (intersectData.getDoesIntersect())
                {
                    Vector3f direction = intersectData.getDirection().normalized();
                    Vector3f otherDirection = direction.reflect(objects.get(i).getVelocity().normalized());
                    
                    objects.get(i).setVelocity(objects.get(i).getVelocity().reflect(otherDirection));
                    objects.get(j).setVelocity(objects.get(j).getVelocity().reflect(direction));
                }
            }
        }
    }

    public ArrayList<PhysicsObject> getObjects()
    {
        return objects;
    }

    public PhysicsObject getObject(int index)
    {
        return objects.get(index);
    }

    public int getSize()
    {
        return objects.size();
    }
}

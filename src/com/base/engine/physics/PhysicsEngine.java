package com.base.engine.physics;

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
                        = objects.get(i).getBoundingSphere().intersectBoundingSphere(
                        objects.get(j).getBoundingSphere());

                if (intersectData.getDoesIntersect())
                {
                    objects.get(i).setVelocity(objects.get(i).getVelocity().mul(-1));
                    objects.get(j).setVelocity(objects.get(j).getVelocity().mul(-1));
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

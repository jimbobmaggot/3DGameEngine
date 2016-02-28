package com.base.game;

import com.base.engine.core.Vector3f;
import com.base.engine.physics.AABoundingBox;
import com.base.engine.physics.BoundingSphere;
import com.base.engine.physics.IntersectData;
import com.base.engine.physics.PhysicsObject;
import com.base.engine.physics.Plane;

/**
 *
 * @author Stephen Rumpel
 */
public class PhysicsTest
{

    public PhysicsTest()
    {

    }

    public void run()
    {
        System.out.println("Sphere Test");
        BoundingSphere sphere1 = new BoundingSphere();
        BoundingSphere sphere2 = new BoundingSphere(0.0f, 3.0f, 0.0f);
        BoundingSphere sphere3 = new BoundingSphere(0.0f, 0.0f, 2.0f);
        BoundingSphere sphere4 = new BoundingSphere(1.0f, 0.0f, 0.0f);

        IntersectData sphereTest1 = testSphere(sphere1, sphere2);
        IntersectData sphereTest2 = testSphere(sphere1, sphere3);
        IntersectData sphereTest3 = testSphere(sphere1, sphere4);

        print(sphereTest1);
        print(sphereTest2);
        print(sphereTest3);

        System.out.println("Box Test");
        AABoundingBox box1 = new AABoundingBox();
        AABoundingBox box2 = new AABoundingBox(new Vector3f(1.0f, 1.0f, 1.0f), new Vector3f(2.0f, 2.0f, 2.0f));
        AABoundingBox box3 = new AABoundingBox(new Vector3f(1.0f, 0.0f, 0.0f), new Vector3f(2.0f, 1.0f, 1.0f));
        AABoundingBox box4 = new AABoundingBox(new Vector3f(0.0f, 0.0f, -2.0f), new Vector3f(1.0f, 1.0f, -1.0f));
        AABoundingBox box5 = new AABoundingBox(new Vector3f(0.0f, 0.5f, 0.0f), new Vector3f(1.0f, 1.5f, 1.0f));

        IntersectData boxTest1 = testAABox(box1, box2);
        IntersectData boxTest2 = testAABox(box1, box3);
        IntersectData boxTest3 = testAABox(box1, box4);
        IntersectData boxTest4 = testAABox(box1, box5);

        print(boxTest1);
        print(boxTest2);
        print(boxTest3);
        print(boxTest4);

        System.out.println("Plane Test");
        Plane plane1 = new Plane();

        IntersectData planeTest1 = testPlane(plane1, sphere1);
        IntersectData planeTest2 = testPlane(plane1, sphere2);
        IntersectData planeTest3 = testPlane(plane1, sphere3);
        IntersectData planeTest4 = testPlane(plane1, sphere4);

        print(planeTest1);
        print(planeTest2);
        print(planeTest3);
        print(planeTest4);
        
        System.out.println("PhysicsObject Test");
        PhysicsObject pO = new PhysicsObject(new Vector3f(0.0f, 1.0f, 0.0f), new Vector3f(1.0f, 2.0f, 3.0f), 1.0f);
        pO.integrate(20.0f);
        
        Vector3f pOPos = pO.getPosition();
        Vector3f pOVel = pO.getVelocity();
        
        System.out.println("(" + pOPos.getX() + ", " + pOPos.getY() + ", " + pOPos.getZ() + ")");
        System.out.println("(" + pOVel.getX() + ", " + pOVel.getY() + ", " + pOVel.getZ() + ")");
    }

    public IntersectData testSphere(BoundingSphere sphere1, BoundingSphere sphere2)
    {
        return sphere1.intersectBoundingSphere(sphere2);
    }

    public IntersectData testAABox(AABoundingBox box1, AABoundingBox box2)
    {
        return box1.IntersectAABoundingBox(box2);
    }

    public IntersectData testPlane(Plane plane1, BoundingSphere sphere1)
    {
        return plane1.intersectSphere(sphere1);
    }

    public void print(IntersectData result)
    {
        System.out.println("Object 1 intersect Object 2: " + result.getDoesIntersect()
                + ", Distance: " + result.getDistance());
    }

}

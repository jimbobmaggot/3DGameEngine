package com.base.engine.physics;

import com.base.engine.core.Vector3f;

/**
 *
 * @author Stephen Rumpel
 */
public class PhysicsObject
{

    private Vector3f position;
    private Vector3f oldPosition;
    private Vector3f velocity;
    private Collider collider;

    public PhysicsObject()
    {
        this.position = new Vector3f();
        this.oldPosition = position;
        this.velocity = new Vector3f();
        this.collider = new Collider();
    }
    
    public PhysicsObject(Collider collider)
    {
        this.position = collider.getCenter();
        this.oldPosition = position;
        this.velocity = new Vector3f();
        this.collider = collider;
    }

    public PhysicsObject(Collider collider, Vector3f velocity)
    {
        this.position = collider.getCenter();
        this.oldPosition = position;
        this.velocity = velocity;
        this.collider = collider;
    }

    public void integrate(float delta)
    {
        setPosition(position.add(velocity.mul(delta)));
    }

    public Vector3f getPosition()
    {
        return position;
    }

    public Vector3f getVelocity()
    {
        return velocity;
    }

    public Collider getCollider()
    {
        Vector3f translation = position.sub(oldPosition);
        oldPosition = position;
        collider.transform(translation);

        return collider;
    }

    public void setPosition(Vector3f position)
    {
        this.position = position;
    }

    public void setVelocity(Vector3f velocity)
    {
        this.velocity = velocity;
    }

}

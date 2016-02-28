package com.base.engine.physics;

import com.base.engine.core.Vector3f;

/**
 *
 * @author Stephen Rumpel
 */
public class PhysicsObject
{

    public Vector3f position;
    public Vector3f velocity;
    public float radius;

    public PhysicsObject()
    {
        this.position = new Vector3f();
        this.velocity = new Vector3f();
        this.radius = 1.0f;
    }

    public PhysicsObject(Vector3f position, Vector3f velocity, float radius)
    {
        this.position = position;
        this.velocity = velocity;
        this.radius = radius;
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

    public float getRadius()
    {
        return radius;
    }
    
    public BoundingSphere getBoundingSphere()
    {
        return new BoundingSphere(position, radius);
    }

    public void setPosition(Vector3f position)
    {
        this.position = position;
    }

    public void setVelocity(Vector3f velocity)
    {
        this.velocity = velocity;
    }

    public void setRadius(float radius)
    {
        this.radius = radius;
    }
    
}

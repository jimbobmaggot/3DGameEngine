package com.base.engine.components;

import com.base.engine.physics.PhysicsObject;

/**
 *
 * @author Stephen Rumpel
 */
public class PhysicsObjectComponent extends GameComponent
{

    private final PhysicsObject object;

    public PhysicsObjectComponent(PhysicsObject object)
    {
        this.object = object;
    }

    @Override
    public void update(float delta)
    {
        getTransform().setPos(object.getPosition());
    }
}

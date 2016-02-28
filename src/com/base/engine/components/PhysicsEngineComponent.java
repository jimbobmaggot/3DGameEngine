package com.base.engine.components;

import com.base.engine.physics.PhysicsEngine;

/**
 *
 * @author Stephen Rumpel
 */
public class PhysicsEngineComponent extends GameComponent
{

    public PhysicsEngine engine;

    public PhysicsEngineComponent(PhysicsEngine engine)
    {
        this.engine = engine;
    }

    @Override
    public void update(float delta)
    {
        getEngine().simulate(delta);
        getEngine().handleCollisions();
    }

    public PhysicsEngine getEngine()
    {
        return engine;
    }
}

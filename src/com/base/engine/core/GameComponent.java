package com.base.engine.core;

/**
 *
 * @author Stephen Rumpel
 */
public interface GameComponent
{

    public void input(Transform transform);

    public void update(Transform transform);

    public void render(Transform transform);
}

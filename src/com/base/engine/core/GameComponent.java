package com.base.engine.core;

import com.base.engine.rendering.Shader;

/**
 *
 * @author Stephen Rumpel
 */
public interface GameComponent
{

    public void input(Transform transform);

    public void update(Transform transform);

    public void render(Transform transform, Shader shader);
}

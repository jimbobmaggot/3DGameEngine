package com.base.engine.components;

import com.base.engine.core.RenderingEngine;
import com.base.engine.core.Vector3f;

/**
 *
 * @author Stephen Rumpel
 */
public class DirectionalLight extends GameComponent
{
    private BaseLight base;
    private Vector3f direction;
    
    public DirectionalLight(BaseLight base, Vector3f direction)
    {
        this.base = base;
        this.direction = direction.normalized();
    }
    
    @Override
    public void addToRenderingEngine(RenderingEngine renderingEngine)
    {
        renderingEngine.addDirectionalLight(this);
    }
    
    // Getters

    public BaseLight getBase()
    {
        return base;
    }

    public Vector3f getDirection()
    {
        return direction;
    }
    
    // Setters

    public void setBase(BaseLight base)
    {
        this.base = base;
    }

    public void setDirection(Vector3f direction)
    {
        this.direction = direction.normalized();
    }
}

package com.base.engine.components;

import com.base.engine.core.RenderingEngine;
import com.base.engine.core.Vector3f;
import com.base.engine.rendering.Attenuation;

/**
 *
 * @author Stephen Rumpel
 */
public class PointLight extends GameComponent
{
    private BaseLight baseLight;
    private Attenuation atten;
    private Vector3f position;
    private float range;
    
    public PointLight(BaseLight baseLight, Attenuation atten, Vector3f position, float range)
    {
        this.baseLight = baseLight;
        this.atten = atten;
        this.position = position;
        this.range = range;
    }
    
    @Override
    public void addToRenderingEngine(RenderingEngine renderingEngine)
    {
        renderingEngine.addPointLight(this);
    }

    public BaseLight getBaseLight()
    {
        return baseLight;
    }
    
    // Getters

    public Attenuation getAtten()
    {
        return atten;
    }

    public Vector3f getPosition()
    {
        return position;
    }
    
    public float getRange()
    {
        return range;
    }

    // Setters
    
    public void setBaseLight(BaseLight baseLight)
    {
        this.baseLight = baseLight;
    }

    public void setAtten(Attenuation atten)
    {
        this.atten = atten;
    }

    public void setPosition(Vector3f position)
    {
        this.position = position;
    }
    
    public void setRange(float range)
    {
        this.range = range;
    }
}

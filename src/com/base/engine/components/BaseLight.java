package com.base.engine.components;

import com.base.engine.rendering.RenderingEngine;
import com.base.engine.core.Vector3f;
import com.base.engine.rendering.Shader;

/**
 *
 * @author Stephen Rumpel
 */
public class BaseLight extends GameComponent
{
    private Vector3f color;
    private float intensity;
    private Shader shader;
    
    public BaseLight(Vector3f color, float intensity)
    {
        this.color = color;
        this.intensity = intensity;
    }
    
    @Override
    public void addToRenderingEngine(RenderingEngine renderingEngine)
    {
        renderingEngine.addLight(this);
    }
    
    // Getters
    
    public Vector3f getColor()
    {
        return color;
    }

    public float getIntensity()
    {
        return intensity;
    }
    
    public Shader getShader()
    {
        return shader;
    }
    
    // Setters
    
    public void setColor(Vector3f color)
    {
        this.color = color;
    }

    public void setIntensity(float intensity)
    {
        this.intensity = intensity;
    }
    
    public void setShader(Shader shader)
    {
        this.shader = shader;
    }
}
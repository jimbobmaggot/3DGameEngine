package com.base.engine.components;

import com.base.engine.core.Vector3f;
import com.base.engine.rendering.ForwardSpot;

/**
 *
 * @author Stephen Rumpel
 */
public class SpotLight extends PointLight
{
    public Vector3f direction;
    public float cutoff;

    public SpotLight(Vector3f color, float intensity, Vector3f attenuation, Vector3f direction, float cutoff)
    {
        super(color, intensity, attenuation);
        this.direction = direction.normalized();
        this.cutoff = cutoff;
        
        setShader(ForwardSpot.getInstance());
    }
    
    // Getters

    public Vector3f getDirection()
    {
        return direction;
    }

    public float getCutoff()
    {
        return cutoff;
    }

    // Setters

    public void setDirection(Vector3f direction)
    {
        this.direction = direction.normalized();
    }

    public void setCutoff(float cutoff)
    {
        this.cutoff = cutoff;
    }
}

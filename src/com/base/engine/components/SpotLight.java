package com.base.engine.components;

import com.base.engine.core.Vector3f;
import com.base.engine.rendering.ForwardSpot;

/**
 *
 * @author Stephen Rumpel
 */
public class SpotLight extends PointLight
{

    public float cutoff;

    public SpotLight(Vector3f color, float intensity, Vector3f attenuation, float cutoff)
    {
        super(color, intensity, attenuation);
        this.cutoff = cutoff;

        setShader(ForwardSpot.getInstance());
    }

    // Getters
    public Vector3f getDirection()
    {
        return getTransform().getRot().getForward();
    }

    public float getCutoff()
    {
        return cutoff;
    }

    // Setters
    public void setCutoff(float cutoff)
    {
        this.cutoff = cutoff;
    }
}

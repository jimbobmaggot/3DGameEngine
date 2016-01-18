package com.base.engine.components;

import com.base.engine.core.Vector3f;
import com.base.engine.rendering.ForwardPoint;

/**
 *
 * @author Stephen Rumpel
 */
public class PointLight extends BaseLight
{

    private static final int COLOR_DEPTH = 256;
    
    private Vector3f attenuation;
    private float range;

    public PointLight(Vector3f color, float intensity, Vector3f attenuation)
    {
        super(color, intensity);
        this.attenuation = attenuation;
        
        float constant = attenuation.getX() - COLOR_DEPTH * getIntensity() * getColor().max();
        float linear = attenuation.getY();
        float exponent = attenuation.getZ();
        //quadratic equation
        this.range = (float)(-linear + Math.sqrt(linear * linear - 4 * exponent * constant))/(2 * exponent);

        setShader(ForwardPoint.getInstance());
    }

    // Getters
    public float getRange()
    {
        return range;
    }

    public float getConstant()
    {
        return attenuation.getX();
    }

    public float getExponent()
    {
        return attenuation.getY();
    }

    public float getLinear()
    {
        return attenuation.getZ();
    }

    // Setters
    public void setRange(float range)
    {
        this.range = range;
    }

    public void setConstant(float constant)
    {
        this.attenuation.setX(constant);
    }

    public void setExponent(float exponent)
    {
        this.attenuation.setX(exponent);
    }

    public void setLinear(float linear)
    {
        this.attenuation.setX(linear);
    }
}

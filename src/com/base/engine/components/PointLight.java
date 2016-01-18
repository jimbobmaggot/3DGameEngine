package com.base.engine.components;

import com.base.engine.core.Vector3f;
import com.base.engine.rendering.ForwardPoint;

/**
 *
 * @author Stephen Rumpel
 */
public class PointLight extends BaseLight
{
    private BaseLight baseLight;
    private Vector3f position;
    public float constant;
    public float linear;
    public float exponent;
    private float range;
    
    public PointLight(Vector3f color, float intensity, float constant, float linear, float exponent, Vector3f position, float range)
    {
        super(color, intensity);
        this.constant = constant;
        this.linear = linear;
        this.exponent = exponent;
        this.position = position;
        this.range = range;
        
        setShader(ForwardPoint.getInstance());
    }

    public BaseLight getBaseLight()
    {
        return baseLight;
    }
    
    // Getters

    public Vector3f getPosition()
    {
        return position;
    }
    
    public float getRange()
    {
        return range;
    }

    public float getConstant()
    {
        return constant;
    }

    public float getExponent()
    {
        return exponent;
    }

    public float getLinear()
    {
        return linear;
    }

    // Setters
    
    public void setBaseLight(BaseLight baseLight)
    {
        this.baseLight = baseLight;
    }

    public void setPosition(Vector3f position)
    {
        this.position = position;
    }
    
    public void setRange(float range)
    {
        this.range = range;
    }

    public void setConstant(float constant)
    {
        this.constant = constant;
    }

    public void setExponent(float exponent)
    {
        this.exponent = exponent;
    }

    public void setLinear(float linear)
    {
        this.linear = linear;
    }
}

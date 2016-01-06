package com.base.engine;

/**
 *
 * @author Stephen Rumpel
 */
public class PointLight 
{
    public BaseLight baseLight;
    public Attenuation atten;
    public Vector3f position;
    
    public PointLight(BaseLight baseLight, Attenuation atten, Vector3f position)
    {
        this.baseLight = baseLight;
        this.atten = atten;
        this.position = position;
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
}

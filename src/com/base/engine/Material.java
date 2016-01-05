package com.base.engine;

/**
 *
 * @author Stephen Rumpel
 */
public class Material 
{
    public Texture texture;
    public Vector3f color;
    
    public Material(Texture texture, Vector3f color)
    {
        this.texture = texture;
        this.color = color;
    }

    public Texture getTexture()
    {
        return texture;
    }

    public Vector3f getColor()
    {
        return color;
    }

    public void setTexture(Texture texture)
    {
        this.texture = texture;
    }

    public void setColor(Vector3f color)
    {
        this.color = color;
    }
}

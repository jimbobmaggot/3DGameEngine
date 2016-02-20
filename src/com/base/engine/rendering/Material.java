package com.base.engine.rendering;

import com.base.engine.core.Vector3f;
import java.util.HashMap;

/**
 *
 * @author Stephen Rumpel
 */
public class Material
{

    private final HashMap<String, Texture> textureHashMap;
    private final HashMap<String, Vector3f> vector3fHashMap;
    private final HashMap<String, Float> floatHashMap;

    public Material()
    {
        textureHashMap = new HashMap<>();
        vector3fHashMap = new HashMap<>();
        floatHashMap = new HashMap<>();
    }
    
    public void addTexture(String name, Texture texture)
    {
        textureHashMap.put(name, texture);
    }
    
    public void addVector3f(String name, Vector3f vector)
    {
        vector3fHashMap.put(name, vector);
    }
    
    public void addFloat(String name, Float floatValue)
    {
        floatHashMap.put(name, floatValue);
    }
    
    // Getters
    
    public Texture getTexture(String name)
    {
        Texture result = textureHashMap.get(name);
        if(result != null)
        {
            return result;
        }
        return new Texture("test.png");
    }
    
    public Vector3f getVector3f(String name)
    {
        Vector3f result = vector3fHashMap.get(name);
        if(result != null)
        {
            return result;
        }
        return new Vector3f(0, 0, 0);
    }
    
    public float getFloat(String name)
    {
        Float result = floatHashMap.get(name);
        if(result != null)
        {
            return result;
        }
        return 0;
    }
}

package com.base.engine.rendering;

import com.base.engine.rendering.resourceManagement.MappedValues;

import java.util.HashMap;

public class Material extends MappedValues
{

    private final HashMap<String, Texture> textureHashMap;

    public Material()
    {
        super();
        textureHashMap = new HashMap<>();
    }

    public void addTexture(String name, Texture texture)
    {
        textureHashMap.put(name, texture);
    }

    public Texture getTexture(String name)
    {
        Texture result = textureHashMap.get(name);
        if (result != null)
        {
            return result;
        }

        return new Texture("test.png");
    }
}

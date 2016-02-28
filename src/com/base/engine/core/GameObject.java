package com.base.engine.core;

import com.base.engine.components.GameComponent;
import com.base.engine.rendering.RenderingEngine;
import com.base.engine.rendering.Shader;

import java.util.ArrayList;

public class GameObject
{

    private final ArrayList<GameObject> children;
    private final ArrayList<GameComponent> components;
    private final Transform transform;
    private CoreEngine engine;

    public GameObject()
    {
        children = new ArrayList<>();
        components = new ArrayList<>();
        transform = new Transform();
        engine = null;
    }

    public GameObject(Vector3f pos, Quaternion rot, Vector3f scale)
    {
        children = new ArrayList<>();
        components = new ArrayList<>();
        transform = new Transform(pos, rot, scale);
        engine = null;
    }

    public GameObject(GameComponent component)
    {
        children = new ArrayList<>();
        components = new ArrayList<>();
        transform = new Transform();
        engine = null;

        addComponent(component);
    }

    public void addChild(GameObject child)
    {
        children.add(child);
        child.setEngine(engine);
        child.getTransform().setParent(transform);
    }

    public GameObject addComponent(GameComponent component)
    {
        components.add(component);
        component.setParent(this);

        return this;
    }

    public void inputAll(float delta)
    {
        input(delta);

        for (GameObject child : children)
        {
            child.inputAll(delta);
        }
    }

    public void updateAll(float delta)
    {
        update(delta);

        for (GameObject child : children)
        {
            child.updateAll(delta);
        }
    }

    public void renderAll(Shader shader, RenderingEngine renderingEngine)
    {
        render(shader, renderingEngine);

        for (GameObject child : children)
        {
            child.renderAll(shader, renderingEngine);
        }
    }

    public void input(float delta)
    {
        transform.update();

        for (GameComponent component : components)
        {
            component.input(delta);
        }
    }

    public void update(float delta)
    {
        for (GameComponent component : components)
        {
            component.update(delta);
        }
    }

    public void render(Shader shader, RenderingEngine renderingEngine)
    {
        for (GameComponent component : components)
        {
            component.render(shader, renderingEngine);
        }
    }

    public ArrayList<GameObject> getAllAttached()
    {
        ArrayList<GameObject> result = new ArrayList<>();

        for (GameObject child : children)
        {
            result.addAll(child.getAllAttached());
        }

        result.add(this);
        return result;
    }

    public Transform getTransform()
    {
        return transform;
    }

    public void setEngine(CoreEngine engine)
    {
        if (this.engine != engine)
        {
            this.engine = engine;

            for (GameComponent component : components)
            {
                component.addToEngine(engine);
            }

            for (GameObject child : children)
            {
                child.setEngine(engine);
            }
        }
    }
}

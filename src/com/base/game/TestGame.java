package com.base.game;

import com.base.engine.components.*;
import com.base.engine.core.*;
import com.base.engine.rendering.*;

public class TestGame extends Game
{

    @Override
    public void init()
    {
        float fieldDepth = 10.0f;
        float fieldWidth = 10.0f;

        Vertex[] vertices = new Vertex[]
        {
            new Vertex(new Vector3f(-fieldWidth, 0.0f, -fieldDepth), new Vector2f(0.0f, 0.0f)),
            new Vertex(new Vector3f(-fieldWidth, 0.0f, fieldDepth * 3), new Vector2f(0.0f, 1.0f)),
            new Vertex(new Vector3f(fieldWidth * 3, 0.0f, -fieldDepth), new Vector2f(1.0f, 0.0f)),
            new Vertex(new Vector3f(fieldWidth * 3, 0.0f, fieldDepth * 3), new Vector2f(1.0f, 1.0f))
        };

        int indices[] =
        {
            0, 1, 2,
            2, 1, 3
        };

        // create materials
        Material testMaterial = new Material();
        testMaterial.addTexture("diffuse", new Texture("test.png"));
        testMaterial.addFloat("specularIntensity", 1f);
        testMaterial.addFloat("specularPower", 8f);
        
        Material woodMaterial = new Material();
        woodMaterial.addTexture("diffuse", new Texture("wood.png"));
        woodMaterial.addFloat("specularIntensity", 0.5f);
        woodMaterial.addFloat("specularPower", 10f);

        // create meshes
        Mesh floorMesh = new Mesh(vertices, indices, true);
        Mesh monkeyMesh = new Mesh("monkey3.obj");
        Mesh chairMesh = new Mesh("chair.obj");

        // create camera
        Camera camera = new Camera((float) Math.toRadians(70.0f), (float) Window.getWidth() / (float) Window.getHeight(), 0.01f, 1000.0f);

        // create lights
        DirectionalLight directionalLight = new DirectionalLight(new Vector3f(0, 0, 1), 0.4f);
        PointLight pointLight = new PointLight(new Vector3f(0, 1, 0), 0.4f, new Vector3f(0, 0, 1));
        SpotLight spotLight = new SpotLight(new Vector3f(0, 1, 1), 0.4f, new Vector3f(0, 0, 0.1f), 0.7f);

        // create objects
        GameObject floorObject = new GameObject().addComponent(new MeshRenderer(floorMesh, woodMaterial));
        GameObject monkeyObject = new GameObject().addComponent(new MeshRenderer(monkeyMesh, testMaterial));
        GameObject chairObject = new GameObject().addComponent(new MeshRenderer(chairMesh, woodMaterial));

        GameObject cameraObject = new GameObject().addComponent(camera);

        GameObject directionalLightObject = new GameObject().addComponent(directionalLight);
        GameObject pointLightObject = new GameObject().addComponent(pointLight);
        GameObject spotLightObject = new GameObject().addComponent(spotLight);

        // add Objects
        addObject(floorObject);
        addObject(monkeyObject);
        addObject(chairObject);

        addObject(cameraObject);

        addObject(directionalLightObject);
        addObject(pointLightObject);
        addObject(spotLightObject);

        // Transform objects
        monkeyObject.getTransform().setPos(5, 3, 5);
        monkeyObject.getTransform().rotY(270.0f);
        chairObject.getTransform().setPos(-2, 0, 2);
        chairObject.getTransform().rotY(50.0f);
        chairObject.getTransform().setScale(0.5f);

        cameraObject.getTransform().setPos(-3, 1, 10);
        cameraObject.getTransform().rotY(140.0f);

        directionalLightObject.getTransform().rotX(-45.0f);
        pointLightObject.getTransform().setPos(2, 2, 2);
        spotLightObject.getTransform().setPos(5, 0, 5);
        spotLightObject.getTransform().rotY(90.0f);
    }
}

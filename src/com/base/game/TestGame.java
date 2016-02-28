package com.base.game;

import com.base.engine.components.*;
import com.base.engine.core.*;
import com.base.engine.physics.PhysicsEngine;
import com.base.engine.physics.PhysicsObject;
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
        
        Material brickMaterial = new Material();
        brickMaterial.addTexture("diffuse", new Texture("bricks.png"));
        brickMaterial.addFloat("specularIntensity", 0.5f);
        brickMaterial.addFloat("specularPower", 10f);

        // create meshes
        Mesh floorMesh = new Mesh(vertices, indices, true);
        //Mesh monkeyMesh = new Mesh("monkey3.obj");
        //Mesh chairMesh = new Mesh("chair.obj");
        Mesh cubeMesh = new Mesh("cube.obj");

        // create camera
        Camera camera = new Camera((float) Math.toRadians(70.0f), (float) Window.getWidth() / (float) Window.getHeight(), 0.01f, 1000.0f);
        
        // create lights
        DirectionalLight directionalLight = new DirectionalLight(new Vector3f(1, 1, 1), 0.4f);
        //PointLight pointLight = new PointLight(new Vector3f(0, 1, 0), 0.4f, new Attenuation(0, 0, 1));
        //SpotLight spotLight = new SpotLight(new Vector3f(0, 1, 1), 0.4f, new Attenuation(0, 0, 0.1f), 0.7f);

        // create objects
        GameObject floorObject = new GameObject(new MeshRenderer(floorMesh, woodMaterial));
        //GameObject monkeyObject = new GameObject(new MeshRenderer(monkeyMesh, testMaterial));
        //GameObject chairObject = new GameObject(new MeshRenderer(chairMesh, woodMaterial));

        GameObject cameraObject = new GameObject(camera).addComponent(new FreeLook(0.5f)).addComponent(new FreeMove(10.0f));

        GameObject directionalLightObject = new GameObject(directionalLight);
        //GameObject pointLightObject = new GameObject(pointLight);
        //GameObject spotLightObject = new GameObject(spotLight);

        // add Objects
        addObject(floorObject);
        //addObject(monkeyObject);
        //addObject(chairObject);

        addObject(cameraObject);

        addObject(directionalLightObject);
        //addObject(pointLightObject);
        //addObject(spotLightObject);

        // Transform objects
        //monkeyObject.getTransform().setPos(5, 3, 5);
        //monkeyObject.getTransform().rotY(270.0f);
        //chairObject.getTransform().setPos(-2, 0, 2);
        //chairObject.getTransform().rotY(50.0f);
        //chairObject.getTransform().setScale(0.5f);
        floorObject.getTransform().setPos(0, -3, 0);
        cameraObject.getTransform().setPos(-10, 1, 8);
        cameraObject.getTransform().rotY(90.0f);

        directionalLightObject.getTransform().rotX(-70.0f);
        //pointLightObject.getTransform().setPos(2, 2, 2);
        //spotLightObject.getTransform().setPos(5, 0, 5);
        //spotLightObject.getTransform().rotY(90.0f);

        //Physics 
        PhysicsEngine physicsEngine = new PhysicsEngine();

        PhysicsObject physicsObject1 = new PhysicsObject(new Vector3f(0.0f, 0.0f, 0.0f), new Vector3f(0.0f, 0.0f, 1.0f), 1.0f);
        PhysicsObject physicsObject2 = new PhysicsObject(new Vector3f(0.0f, 0.0f, 10.0f), new Vector3f(0.0f, 0.0f, -1.0f), 2.0f);

        physicsEngine.addObject(physicsObject1);
        physicsEngine.addObject(physicsObject2);

        PhysicsEngineComponent physicsEngineComponent = new PhysicsEngineComponent(physicsEngine);
        PhysicsObjectComponent pOC;
        GameObject pO;

        for (int i = 0; i < physicsEngineComponent.getEngine().getSize(); i++)
        {
            pOC = new PhysicsObjectComponent(physicsEngineComponent.getEngine().getObject(i));
            pO = new GameObject(new Vector3f(), new Quaternion(), new Vector3f(physicsEngineComponent.getEngine().getObject(i).getRadius()));
            pO.addComponent(pOC);
            pO.addComponent(new MeshRenderer(cubeMesh, brickMaterial));
            addObject(pO);
        }

        addObject((new GameObject()).addComponent(physicsEngineComponent));
    }
}

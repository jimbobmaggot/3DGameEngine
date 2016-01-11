package com.base.engine.core;

import com.base.engine.rendering.*;
import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL32.GL_DEPTH_CLAMP;

/**
 *
 * @author Stephen Rumpel
 */
public class RenderingEngine
{

    private Camera mainCamera;

    public RenderingEngine()
    {
        glClearColor(0.0f, 0.0f, 0.0f, 0.0f);

        // Tell gl which face is front and which is back
        glFrontFace(GL_CW);
        glCullFace(GL_BACK);
        // Tell gl to only render front faces
        glEnable(GL_CULL_FACE);
        // Render closer objects on top
        glEnable(GL_DEPTH_TEST);
        // Prevents Camera from clipping through mesh
        glEnable(GL_DEPTH_CLAMP);

        glEnable(GL_TEXTURE_2D);

        mainCamera = new Camera((float) Math.toRadians(70.0f), (float) (Window.getWidth() / Window.getHeight()), 0.01f, 1000.0f);
    }
    
    public void input()
    {
        mainCamera.input();
    }

    public void render(GameObject object)
    {
        clearScreen();
        
        Shader shader = BasicShader.getInstance();
        shader.setRenderingEngine(this);
        
        object.render(BasicShader.getInstance());
    }

    private static void clearScreen()
    {
        // TODO: Stencil Buffer
        glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
    }

    private static void setTextures(boolean enabled)
    {
        if (enabled)
        {
            glEnable(GL_TEXTURE_2D);
        }
        else
        {
            glDisable(GL_TEXTURE_2D);
        }
    }

    private static void unbindTextures()
    {
        glBindTexture(GL_TEXTURE_2D, 0);
    }

    private static void setClearColor(Vector3f color)
    {
        glClearColor(color.getX(), color.getY(), color.getZ(), 1.0f);
    }

    public static String getOpenGLVersion()
    {
        return glGetString(GL_VERSION);
    }

    public Camera getMainCamera()
    {
        return mainCamera;
    }

    public void setMainCamera(Camera mainCamera)
    {
        this.mainCamera = mainCamera;
    }

}

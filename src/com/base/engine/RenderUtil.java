package com.base.engine;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL30.*;

public class RenderUtil
{

    public static void clearScrean()
    {
        // TODO: Stencil Buffer
        glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
    }

    public static void initGraphics()
    {
        glClearColor(0.0f, 0.0f, 0.0f, 0.0f);

        // Tell gl which face is front and which is back
        glFrontFace(GL_CW);
        glCullFace(GL_BACK);
        // Tell gl to only render front faces
        glEnable(GL_CULL_FACE);
        // Render closer objects on top
        glEnable(GL_DEPTH_TEST);

        // TODO: Depth clamp for later
        // gamma correction (GL30 feature)
        glEnable(GL_FRAMEBUFFER_SRGB);
    }

    public static String getOpenGLVersion()
    {
        return glGetString(GL_VERSION);
    }
}

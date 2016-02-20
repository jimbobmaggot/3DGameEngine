package com.base.engine.rendering.resourceManagement;

import static org.lwjgl.opengl.GL15.*;

/**
 *
 * @author Stephen Rumpel
 */
public class MeshResource 
{
    private final int vbo;	// pointer/handle
    private final int ibo;      // index buffer object
    private int size;           // size/amounts of data
    private int refCount;
    
    public MeshResource(int size)
    {
        vbo = glGenBuffers();
        ibo = glGenBuffers();
        this.size = size;
        this.refCount = 1;
    }
    
    @Override
    protected void finalize()
    {
        glDeleteBuffers(vbo);
        glDeleteBuffers(ibo);
    }
    
    public void addReference()
    {
        refCount++;
    }
    
    public boolean removeReference()
    {
        refCount--;
        return refCount == 0;
    }

    public int getIbo()
    {
        return ibo;
    }

    public int getVbo()
    {
        return vbo;
    }

    public int getSize()
    {
        return size;
    }

    public void setSize(int size)
    {
        this.size = size;
    }
}

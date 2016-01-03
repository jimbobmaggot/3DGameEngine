package com.base.engine;

public class Vertex
{

    public static final int SIZE = 3;

    private Vector3f pos;

    public Vertex(Vector3f pos)
    {
        this.pos = pos;
    }

    /**
     * @return the pos
     */
    public Vector3f getPos()
    {
        return pos;
    }

    /**
     * @param pos
     */
    public void setPos(Vector3f pos)
    {
        this.pos = pos;
    }

}

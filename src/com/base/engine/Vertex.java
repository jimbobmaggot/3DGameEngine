package com.base.engine;

public class Vertex
{

    public static final int SIZE = 5;

    private Vector3f pos;
    public Vector2f textCoord;

    public Vertex(Vector3f pos)
    {
        this(pos, new Vector2f(0,0));
    }
    
    public Vertex(Vector3f pos, Vector2f textCoord)
    {
        this.pos = pos;
        this.textCoord = textCoord;
    }

    public Vector3f getPos()
    {
        return pos;
    }

    public Vector2f getTexCoord()
    {
        return textCoord;
    }

    public void setPos(Vector3f pos)
    {
        this.pos = pos;
    }

    public void setTextCoord(Vector2f textCoord)
    {
        this.textCoord = textCoord;
    }
}

package com.base.engine.rendering.meshLoading;

import com.base.engine.core.Vector2f;
import com.base.engine.core.Vector3f;
import java.util.ArrayList;

/**
 *
 * @author Stephen Rumpel
 */
public class IndexedModel 
{
    public ArrayList<Vector3f> positions;
    public ArrayList<Vector2f> textCoords;
    public ArrayList<Vector3f> normals;
    public ArrayList<Integer> indices;

    
    public IndexedModel()
    {
        positions = new ArrayList<>();
        textCoords = new ArrayList<>();
        normals = new ArrayList<>();
        indices = new ArrayList<>();
    }
    
    public ArrayList<Integer> getIndices()
    {
        return indices;
    }

    public ArrayList<Vector3f> getNormals()
    {
        return normals;
    }

    public ArrayList<Vector3f> getPositions()
    {
        return positions;
    }

    public ArrayList<Vector2f> getTextCoords()
    {
        return textCoords;
    }
    
}

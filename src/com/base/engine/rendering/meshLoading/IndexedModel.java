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
    
    public void calcNormals()
    {
        int i;

        for (i = 0; i < indices.size(); i += 3)
        {
            int i0 = indices.get(i);
            int i1 = indices.get(i + 1);
            int i2 = indices.get(i + 2);

            Vector3f v1 = positions.get(i1).sub(positions.get(i0));
            Vector3f v2 = positions.get(i2).sub(positions.get(i0));

            Vector3f normal = v1.cross(v2).normalized();

            normals.get(i0).set(normals.get(i0).add(normal));
            normals.get(i1).set(normals.get(i1).add(normal));
            normals.get(i2).set(normals.get(i2).add(normal));
        }

        for (i = 0; i < normals.size(); i++)
        {
            normals.get(i).set(normals.get(i).normalized());
        }
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

    public ArrayList<Vector2f> getTexCoords()
    {
        return textCoords;
    }
    
}

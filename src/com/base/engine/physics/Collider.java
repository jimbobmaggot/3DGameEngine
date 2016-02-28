package com.base.engine.physics;

import com.base.engine.core.Vector3f;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Stephen Rumpel
 */
public class Collider
{

    private final Type type;

    enum Type
    {
        Sphere,
        AABox,
        Size
    }
    
    public Collider()
    {
        this.type = Type.Sphere;
    }

    public Collider(Type type)
    {
        this.type = type;
    }

    public IntersectData intersect(Collider other)
    {
        try
        {
            if (type == Type.Sphere && other.getType() == Type.Sphere)
            {
                BoundingSphere self = (BoundingSphere) this;
                return self.intersectBoundingSphere((BoundingSphere) other);
            }
        }
        catch (Exception ex)
        {
            Logger.getLogger(Collider.class.getName()).log(Level.SEVERE, null, ex);
            System.exit(1);
        }

        return new IntersectData();
    }
    
    public void transform(Vector3f translation)
    {
        
    }
    
    public Vector3f getCenter()
    {
        return new Vector3f(0.0f, 0.0f, 0.0f);
    }

    public Type getType()
    {
        return type;
    }
}

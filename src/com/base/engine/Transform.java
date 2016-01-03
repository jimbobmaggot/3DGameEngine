package com.base.engine;

/**
 *
 * @author Stephen Rumpel
 */
public class Transform
{

    public Vector3f translation;

    public Transform()
    {
        translation = new Vector3f(0, 0, 0);
    }
    
    public Matrix4f getTransformation(){
        Matrix4f translationMatrix = new Matrix4f().initTranslation(translation.getX(), translation.getY(), translation.getZ());
        
        return translationMatrix;
    }

    /**
     * @return the translation
     */
    public Vector3f getTranslation()
    {
        return translation;
    }

    /**
     * @param translation
     */
    public void setTranslation(Vector3f translation)
    {
        this.translation = translation;
    }

    public void setTranslation(float x, float y, float z)
    {
        this.translation = new Vector3f(x, y, z);
    }
}

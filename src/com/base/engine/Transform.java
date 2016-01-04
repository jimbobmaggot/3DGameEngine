package com.base.engine;

/**
 *
 * @author Stephen Rumpel
 */
public class Transform
{
    // Render Clipping
    private static float zNear;         
    private static float zFar;
    // Render aspectRatio fix
    private static float width;
    private static float height;
    // Set up perspective 
    private static float fov;
    
    private Vector3f translation;
    private Vector3f rotation;
    private Vector3f scale;

    public Transform()
    {
        translation = new Vector3f(0, 0, 0);
        rotation = new Vector3f(0, 0, 0);
        scale = new Vector3f(1, 1, 1);
    }

    public Matrix4f getTransformation()
    {
        Matrix4f translationMatrix = new Matrix4f().initTranslation(translation.getX(),
                                                                    translation.getY(),
                                                                    translation.getZ());
        
        Matrix4f rotationMatrix = new Matrix4f().initRotation(rotation.getX(), 
                                                              rotation.getY(), 
                                                              rotation.getZ());
        
        Matrix4f scaleMatrix = new Matrix4f().initScale(scale.getX(), 
                                                        scale.getY(), 
                                                        scale.getZ());

        return translationMatrix.mul(rotationMatrix.mul(scaleMatrix));
    }
    
    public Matrix4f getProjectedTransformation()
    {
        Matrix4f transformationMatrix = getTransformation();
        Matrix4f projectionMatrix = new Matrix4f().initProjection(fov, width, height, zNear, zFar);
        
        return projectionMatrix.mul(transformationMatrix);
    }

    // Getters

    /**
     * @return the translation
     */
    public Vector3f getTranslation()
    {
        return translation;
    }

    /**
     * @return the rotation
     */
    public Vector3f getRotation()
    {
        return rotation;
    }

    /**
     * @return the scale
     */
    public Vector3f getScale()
    {
        return scale;
    }
    
    // Setters

    public static void setProjection(float fov, float width, float height, float zNear, float zFar)
    {
        Transform.fov = fov;
        Transform.width = width;
        Transform.height = height;
        Transform.zNear = zNear;
        Transform.zFar = zFar;
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

    /**
     * @param rotation
     */
    public void setRotation(Vector3f rotation)
    {
        this.rotation = rotation;
    }
    
    public void setRotation(float x, float y, float z)
    {
        this.rotation = new Vector3f(x, y, z);
    }
    
    /**
     * @param scale
     */
    public void setScale(Vector3f scale)
    {
        this.scale = scale;
    }
    
    public void setScale(float x, float y, float z)
    {
        this.scale = new Vector3f(x, y, z);
    }
}

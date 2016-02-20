package com.base.engine.core;

public class Transform
{

    private Transform parent;
    private Matrix4f parentMatrix;

    private Vector3f pos;
    private Quaternion rot;
    private Vector3f scale;

    private Vector3f oldPos;
    private Quaternion oldRot;
    private Vector3f oldScale;

    public Transform()
    {
        pos = new Vector3f(0, 0, 0);
        rot = new Quaternion(0, 0, 0, 1);
        scale = new Vector3f(1, 1, 1);

        parentMatrix = new Matrix4f().initIdentity();
    }

    public void update()
    {
        if (oldPos != null)
        {
            oldPos.set(pos);
            oldRot.set(rot);
            oldScale.set(scale);
        }
        else
        {
            oldPos = new Vector3f(0, 0, 0).set(pos).add(1.0f);
            oldRot = new Quaternion(0, 0, 0, 0).set(rot).mul(0.5f);
            oldScale = new Vector3f(0, 0, 0).set(scale).add(1.0f);
        }
    }
    
    public void rotate(Vector3f axis, float angle)
    {
        rot = new Quaternion(axis, angle).mul(rot).normalized();
    }

    public boolean hasChanged()
    {

        if (parent != null && parent.hasChanged())
        {
            return true;
        }
        else if (!pos.equals(oldPos))
        {
            return true;
        }
        else if (!rot.equals(oldRot))
        {
            return true;
        }
        else if (!scale.equals(oldScale))
        {
            return true;
        }

        return false;
    }

    public Matrix4f getTransformation()
    {
        Matrix4f translationMatrix = new Matrix4f().initTranslation(
                pos.getX(),
                pos.getY(),
                pos.getZ());

        Matrix4f rotationMatrix = rot.toRotationMatrix();

        Matrix4f scaleMatrix = new Matrix4f().initScale(
                scale.getX(),
                scale.getY(),
                scale.getZ());

        return getParentMatrix().mul(translationMatrix.mul(rotationMatrix.mul(scaleMatrix)));
    }

    private Matrix4f getParentMatrix()
    {
        if (parent != null && parent.hasChanged())
        {
            parentMatrix = parent.getTransformation();
        }

        return parentMatrix;
    }

    public Vector3f getTransformedPos()
    {
        return getParentMatrix().transform(pos);
    }

    public Quaternion getTransformedRot()
    {
        Quaternion parentRotation = new Quaternion(0, 0, 0, 1);

        if (parent != null)
        {
            parentRotation = parent.getTransformedRot();
        }

        return parentRotation.mul(rot);
    }
    
    public void rotX(float angle)
    {
        setRot(new Quaternion(new Vector3f(1, 0, 0), (float) Math.toRadians(angle)));
    }
    
    public void rotY(float angle)
    {
        setRot(new Quaternion(new Vector3f(0, 1, 0), (float) Math.toRadians(angle)));
    }
    
    public void rotZ(float angle)
    {
        setRot(new Quaternion(new Vector3f(0, 0, 1), (float) Math.toRadians(angle)));
    }
    
    public void setPos(float x, float y, float z)
    {
        setPos(new Vector3f(x, y, z));
    }
    
    public void setScale(float amt)
    {
        setScale(new Vector3f(amt, amt, amt));
    }

    // Getters
    public Vector3f getPos()
    {
        return pos;
    }

    public Quaternion getRot()
    {
        return rot;
    }

    public Vector3f getScale()
    {
        return scale;
    }

    // Setters
    public void setPos(Vector3f pos)
    {
        this.pos = pos;
    }

    public void setRot(Quaternion rot)
    {
        this.rot = rot;
    }

    public void setScale(Vector3f scale)
    {
        this.scale = scale;
    }

    public void setParent(Transform parent)
    {
        this.parent = parent;
    }
}

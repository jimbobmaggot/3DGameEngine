package com.base.engine.components;

import com.base.engine.rendering.*;

/**
 *
 * @author Stephen Rumpel
 */
public class MeshRenderer extends GameComponent
{

    private Mesh mesh;
    private Material material;

    public MeshRenderer(Mesh mesh, Material material)
    {
        this.mesh = mesh;
        this.material = material;
    }

    @Override
    public void render(Shader shader)
    {
        shader.bind();
        shader.updateUniforms(getTransform(), material);
        mesh.draw();
    }
}

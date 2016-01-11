package com.base.game;

import com.base.engine.core.GameComponent;
import com.base.engine.core.Transform;
import com.base.engine.rendering.*;

/**
 *
 * @author Stephen Rumpel
 */
public class MeshRenderer implements GameComponent
{

    private Mesh mesh;
    private Material material;

    public MeshRenderer(Mesh mesh, Material material)
    {
        this.mesh = mesh;
        this.material = material;
    }

    @Override
    public void input(Transform transform, float delta)
    {
    }

    @Override
    public void update(Transform transform, float delta)
    {
    }

    @Override
    public void render(Transform transform, Shader shader)
    {
        shader.bind();
        shader.updateUniforms(transform, material);
        mesh.draw();
    }
}

package com.base.engine;

public class Game
{

    private final Mesh mesh;
    private final Shader shader;
    private Transform transform;

    public Game()
    {

        mesh = new Mesh();
        shader = new Shader();

        Vertex[] data = new Vertex[]
        {
            new Vertex(new Vector3f(-1, -1, 0)),
            new Vertex(new Vector3f(0, 1, 0)),
            new Vertex(new Vector3f(1, -1, 0)),
        };

        mesh.addVertices(data);
        
        transform = new Transform();

        shader.addVertexShader(ResourceLoader.loadShader("basicVertex.vs"));
        shader.addFragmentShader(ResourceLoader.loadShader("basicFragment.fs"));
        shader.compileShader();

        shader.addUniform("transform");

    }

    public void input()
    {

    }

    float temp = 0.0f;

    public void update()
    {
        temp += Time.getDelta();

        transform.setTranslation((float) Math.sin(temp), 0, 0);
        transform.setRotation(0, 0, (float) Math.sin(temp) * 180);
    }

    public void render()
    {

        shader.bind();
        shader.setUniformi("transform", transform.getTransformation());
        mesh.draw();

    }
}

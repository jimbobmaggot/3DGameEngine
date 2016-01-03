package com.base.engine;

public class Game
{

    private final Mesh mesh;
    private final Shader shader;
    private final Transform transform;

    public Game()
    {

        mesh = ResourceLoader.loadMesh("cube.obj"); //new Mesh();
        shader = new Shader();

//        Vertex[] vertices = new Vertex[]
//        {
//            new Vertex(new Vector3f(-1, -1, 0)),
//            new Vertex(new Vector3f(0, 1, 0)),
//            new Vertex(new Vector3f(1, -1, 0)),
//            new Vertex(new Vector3f(0, -1, 1))
//        };
//
//        int[] indices = new int[]
//        {
//            0, 1, 3,
//            3, 1, 2,
//            2, 1, 0,
//            0, 2, 3
//
//        };
//
//      mesh.addVertices(vertices, indices);

        transform = new Transform();

        shader.addVertexShader(ResourceLoader.loadShader("basicVertex.vs"));
        shader.addFragmentShader(ResourceLoader.loadShader("basicFragment.fs"));
        shader.compileShader();

        shader.addUniform(
                "transform");

    }

    public void input()
    {

    }

    float temp = 0.0f;

    public void update()
    {
        temp += Time.getDelta();

        float sinTemp = (float) Math.sin(temp);

        transform.setTranslation(sinTemp, 0, 0);
        transform.setRotation(0, sinTemp * 180, 0);
        transform.setScale(0.7f * sinTemp, 0.7f * sinTemp, 0.7f * sinTemp);
    }

    public void render()
    {

        shader.bind();
        shader.setUniformi("transform", transform.getTransformation());
        mesh.draw();

    }
}

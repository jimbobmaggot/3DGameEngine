package com.base.engine;

public class Game
{

    private final Mesh mesh;
    private final Shader shader;
    private final Transform transform;
    private final Material material;
    private final Camera camera;

    public Game()
    {
        // mesh = ResourceLoader.loadMesh("monkey.obj");
        mesh = ResourceLoader.loadMesh("cube.obj");
        material = new Material(ResourceLoader.loadTexture("test.png"), new Vector3f(0, 1, 1));
        // mesh = new Mesh();
        shader = new BasicShader();
        camera = new Camera();

//        Vertex[] vertices = new Vertex[]
//        {
//            new Vertex(new Vector3f(-1, -1, 0), new Vector2f(0,0)),
//            new Vertex(new Vector3f(0, 1, 0), new Vector2f(0.5f,0)),
//            new Vertex(new Vector3f(1, -1, 0), new Vector2f(1.0f,0)),
//            new Vertex(new Vector3f(0, -1, 1), new Vector2f(0,0.5f))
//        };
//
//        int[] indices = new int[]
//        {
//            3, 1, 0,
//            2, 1, 3,
//            0, 1, 2,
//            0, 2, 3
//
//        };
//
//        mesh.addVertices(vertices, indices);

        Transform.setProjection(70f, Window.getWidth(), Window.getHeight(), 0.1f, 1000);
        Transform.setCamera(camera);
        transform = new Transform();
    }

    public void input()
    {
        camera.input();
    }

    float temp = 0.0f;

    public void update()
    {
        temp += Time.getDelta();

        float sinTemp = (float) Math.sin(temp);

        transform.setTranslation(sinTemp, 0, 5);
        transform.setRotation(0, temp * 90, 0);
        //transform.setScale(0.7f * sinTemp, 0.7f * sinTemp, 0.7f * sinTemp);
        //transform.setScale(0.5f, 0.5f, 0.5f);
    }

    public void render()
    {
        RenderUtil.setClearColor(Transform.getCamera().getPos().div(2048f).abs());
        shader.bind();
        shader.updateuniforms(transform.getTransformation(), transform.getProjectedTransformation(), material);
        mesh.draw();
    }
}

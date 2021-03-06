package CanftIn.base.engine;

public class Game {
	
	private Mesh mesh;
	private Shader shader;
	private Transform transform;
	private Texture texture;
	private Camera camera;
	
	float temp = 0.0f;
	
	public Game() {
		mesh = new Mesh(); //ResourceLoader.loadMesh("box.obj");
		texture = ResourceLoader.loadTexture("test.png");
		shader = new Shader();
		camera = new Camera();
		
//		Vertex[] vertices = new Vertex[] {new Vertex(new Vector3f(-1,-1,0), new Vector2f(0,0)),
//										new Vertex(new Vector3f(0,1,0), new Vector2f(0.5f,0)),
//										new Vertex(new Vector3f(1,-1,0), new Vector2f(1.0f,0)),
//										new Vertex(new Vector3f(0,-1,1), new Vector2f(0.5f,1.0f))};
//						
//		int[] indices = new int[] {3,1,0,
//									2,1,3,
//									0,1,2,
//									0,2,3};
		
		Vertex[] vertices = new Vertex[] {new Vertex(new Vector3f(1,-1,-1), new Vector2f(0,0)),
											new Vertex(new Vector3f(1,-1,1), new Vector2f(0.5f,0)),
											new Vertex(new Vector3f(-1,-1,1), new Vector2f(1.0f,0)),
											new Vertex(new Vector3f(-1,-1,-1), new Vector2f(0.5f,1.0f)),
											new Vertex(new Vector3f(1,1,-1), new Vector2f(1.0f,0)),
											new Vertex(new Vector3f(1,1,1), new Vector2f(0,1.0f)),
											new Vertex(new Vector3f(-1,1,1), new Vector2f(0.5f,1.0f)),
											new Vertex(new Vector3f(-1,1,-1), new Vector2f(0.5f,0))};

		int[] indices = new int[] {1,2,3,
									1,3,4,
									5,8,7,
									5,7,6,
									1,5,6,
									1,6,2,
									2,6,7,
									2,7,3,
									3,7,8,
									3,8,4,
									5,1,4,
									5,4,8};
		mesh.addVertices(vertices, indices);
		
		Transform.setProjection(70f, Window.getWidth(), Window.getHeight(), 0.1f, 1000);
		Transform.setCamera(camera);
		transform = new Transform();
		
		shader.addVertexShader(ResourceLoader.loadShader("basicVertex.vs"));
		shader.addFragmentShader(ResourceLoader.loadShader("basicFragment.fs"));
		shader.compileShader();
		
		shader.addUniform("transform");
	}
	
	public void render() {
		shader.bind();
		shader.setUniform("transform", transform.getProjectedTransformation());
		texture.bind();
		mesh.draw();
	}
	
	public void update() {
		temp += Time.getDelta();

		float sinTemp = (float)Math.sin(temp);
		
		transform.setTranslation(sinTemp, 0, 5);
		transform.setRotation(0, sinTemp * 180, 0);
		//transform.setScale(0.7f * sinTemp, 0.7f * sinTemp, 0.7f * sinTemp);
	}

	public void input() {
		camera.input();
	}
}


package CanftIn.base.engine;

import org.lwjgl.input.Keyboard;

public class Game {
	
	private Mesh mesh;
	private Shader shader;
	private Transform transform;
	private Camera camera;
	
	float temp = 0.0f;
	
	public Game() {
		mesh = ResourceLoader.loadMesh("box.obj");//new Mesh();
		shader = new Shader();
		camera = new Camera();
		
//		Vertex[] vertices = new Vertex[] { new Vertex(new Vector3f(-1,-1,0)),
//				  					   new Vertex(new Vector3f(0, 1, 0)),
//				  					   new Vertex(new Vector3f(1, -1, 0)),
//				  					   new Vertex(new Vector3f(0, -1, 1))};
//		
//		int[] indices = new int[] {0, 1, 3,
//								   3, 1, 2,
//								   2, 1, 0,
//								   0, 2, 3};
//		
//		mesh.addVertices(vertices, indices);
		
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


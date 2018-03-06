package CanftIn.base.engine;

import org.lwjgl.input.Keyboard;

public class Game {
	
	private Mesh mesh;
	private Shader shader;
	private Transform transform;
	
	float temp = 0.0f;
	
	public Game() {
		mesh = new Mesh();
		shader = new Shader();
		
		Vertex[] data = new Vertex[] { new Vertex(new Vector3f(-1,-1,0)),
				  					   new Vertex(new Vector3f(0, 1, 0)),
				  					   new Vertex(new Vector3f(1, -1, 0))};
		mesh.addVertices(data);
		
		transform = new Transform();
		
		shader.addVertexShader(ResourceLoader.loadShader("basicVertex.vs"));
		shader.addFragmentShader(ResourceLoader.loadShader("basicFragment.fs"));
		shader.compileShader();
		
		shader.addUniform("transform");
	}
	
	public void render() {
		shader.bind();
		shader.setUniform("transform", transform.getTransformation());
		mesh.draw();
	}
	
	public void update() {
		temp += Time.getDelta();

		transform.setTranslation((float)Math.sin(temp), 0, 0);
		transform.setRotation(0, 0, (float)Math.sin(temp) * 180);
	}

	public void input() {
		if(Input.getKeyDown(Keyboard.KEY_UP))
			System.out.println("pressed up!");
		if(Input.getKeyUp(Keyboard.KEY_UP))
			System.out.println("released up!");
		
		if(Input.getMouseDown(1))
			System.out.println("right clicked at " + Input.getMousePosition().toString());
		if(Input.getMouseUp(1))
			System.out.println("released right mouse button!");
	}
}


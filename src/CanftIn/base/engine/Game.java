package CanftIn.base.engine;

import org.lwjgl.input.Keyboard;

public class Game {
	
	private Mesh mesh;
	
	public Game() {
		mesh = new Mesh();
		
		Vertex[] data = new Vertex[] { new Vertex(new Vector3f(-1,-1,0)),
				  					   new Vertex(new Vector3f(0, 1, 0)),
				  					   new Vertex(new Vector3f(1, -1, 0))};
		mesh.addVertices(data);
	}
	
	public void render() {
		mesh.draw();
	}
	
	public void update() {
		
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


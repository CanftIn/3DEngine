package CanftIn.base.engine;

import org.lwjgl.input.Keyboard;

public class Game {
	public Game() {
		
	}
	
	public void render() {
		
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


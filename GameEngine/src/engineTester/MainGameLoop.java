package engineTester;

import org.lwjgl.opengl.Display;

import renderEngine.DisplayManager;
import renderEngine.Loader;
import renderEngine.RawModel;
import renderEngine.Renderer;

/**
 * This class contains the main method and is used to test the engine.
 * 
 * @author Karl
 *
 */
public class MainGameLoop {

	/**
	 * Creates a display and then continuously updates the display until the user tries to close it. 
	 * @param args
	 */
	public static void main(String[] args) {
		DisplayManager.createDisplay();

		// add loader, renderer, verts, model...
		Loader loader = new Loader();
		Renderer renderer = new Renderer();
		
//		float[] vertices = {
//				// Left bottom triangle
//				-0.5f, 0.5f, 0f,
//				-0.5f, -0.5f, 0f,
//				0.5f, -0.5f, 0f,
//				// Right top triangle
//				0.5f, -0.5f, 0f,
//				0.5f, 0.5f, 0f,
//				-0.5f, 0.5f, 0f
//		};
		
		float[] vertices = {
				-0.5f, 0.5f, 0f,//v0
				-0.5f, -0.5f, 0f,//v1
				0.5f, -0.5f, 0f,//v2
				0.5f, 0.5f, 0f,//v3
		};
		
		int[] indices = {
				0,1,3,//top left triangle (v0, v1, v3)
				3,1,2//bottom right triangle (v3, v1, v2)
		};
		
		RawModel model = loader.loadToVAO(vertices, indices);
		
		while (!Display.isCloseRequested()) {

			// game logic
			// game logic...
						renderer.prepare();
						renderer.render(model);
						
			// render geometry
			DisplayManager.updateDisplay();
		}

		// cleanup...
		loader.cleanUp();
		DisplayManager.closeDisplay();
	}

}

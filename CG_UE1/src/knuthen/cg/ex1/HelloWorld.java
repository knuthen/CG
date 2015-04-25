package knuthen.cg.ex1;



import org.lwjgl.LWJGLException;
import org.lwjgl.Sys;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;

public class HelloWorld {

	public static void main(String[] args) {
		setup();

		while(update()) {
			//draw();
			drawRect(50, 150, 200, 250);
			
		}

	}
	private static void setup() {
		try {
			Display.setDisplayMode(new DisplayMode (800, 600)); 
			Display.create();
		} catch (LWJGLException e) {
			e.printStackTrace();
			System.exit(0);
		}
		// set OpelGL ortho
		
		GL11.glMatrixMode(GL11.GL_PROJECTION);
		GL11.glLoadIdentity();
		GL11.glOrtho(0, 800, 0, 600, 1, -1);
		GL11.glMatrixMode(GL11.GL_MODELVIEW);
	}

	private static void draw() {
		GL11.glClear(GL11.GL_COLOR_BUFFER_BIT);
		GL11.glPointSize(100);
		GL11.glBegin(GL11.GL_POINTS);
		GL11.glVertex2f(0, 0);
		GL11.glEnd();
		Display.update();
		Display.sync(20);
	}

	private static void drawRect(int xs, int xe, int ys, int ye){
		GL11.glClearColor(0.3f, 0.3f, 0.3f, 1);
		GL11.glClear(GL11.GL_COLOR_BUFFER_BIT);
		GL11.glPointSize(10);
		GL11.glColor3f(1, 0, 0);
		GL11.glBegin(GL11.GL_QUADS);
		GL11.glVertex2f(xs, ys);
		GL11.glVertex2f(xs, ye);
		GL11.glVertex2f(xe, ye);
		GL11.glVertex2f(xe, ys);
		GL11.glEnd();
		Display.update();
		Display.sync(1);
		}
		

	private static boolean update() {
		return !Display.isCloseRequested();
	}

	private long getTime(){
		return (Sys.getTime() * 1000) / Sys.getTimerResolution();
	}

}
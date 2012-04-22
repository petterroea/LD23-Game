package me.petterroea.LD23;

import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;

public class Game extends Applet implements Runnable{
	boolean running = true;
	Image backBuffer;
	Thread gameThread;
	Screen current;
	static int WIDTH = 800/2;
	static int HEIGHT = 640/2;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		JFrame frame = new JFrame("LD23");
		frame.setSize(WIDTH*2, HEIGHT*2);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		Game game = new Game();
		frame.add(game);
		frame.setVisible(true);
		game.init();
	}
	@Override
	public void init()
	{
		MediaManager.loadMedia();
		current = new GameScreen();
		gameThread = new Thread(this);
		Input input = new Input(this);
		this.addMouseListener(input);
		this.addMouseMotionListener(input);
		this.addKeyListener(input);
		this.addFocusListener(input);
		gameThread.start();
	}
	@Override
	public void stop()
	{
		running = false;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		int fps = 0;
		int frames = 0;
		long lastFpsCount = System.currentTimeMillis();
		long lastUpdate = System.currentTimeMillis();
		while(running)
		{
			//Time stuff(z)
			if(System.currentTimeMillis() - lastFpsCount > 1000)
			{
				fps = frames;
				frames = 0;
				lastFpsCount = System.currentTimeMillis();
				System.out.println("Fps: " + fps);
			}
			frames++;
			int delta = (int)(System.currentTimeMillis() - lastUpdate);
			lastUpdate = System.currentTimeMillis();
			if(backBuffer == null || backBuffer.getWidth(null) != this.getWidth()/2 || backBuffer.getHeight(null) != this.getHeight()/2)
			{
				backBuffer = this.createImage(this.getWidth()/2, this.getHeight()/2);
				System.out.println("Generating backBuffer");
			}
			Graphics g = backBuffer.getGraphics();
			//Do stuff here
			current.tick(g, delta);
			
			this.getGraphics().drawImage(scale(backBuffer), 0, 0, null);
			g.dispose();
		}
	}
	public BufferedImage scale(Image original)
	{
		BufferedImage returnable = new BufferedImage(WIDTH*2, HEIGHT*2, BufferedImage.TYPE_INT_RGB);
		returnable.getGraphics().drawImage(original, 0, 0, WIDTH*2, HEIGHT*2, null);
		return returnable;
	}

}

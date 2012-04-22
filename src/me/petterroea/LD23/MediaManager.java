package me.petterroea.LD23;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class MediaManager {
	public static BufferedImage[][] tiles;
	public static BufferedImage[][] font;
	public static BufferedImage[][] gui;
	public static BufferedImage[][] smallfont;
	public static Map outside;
	public static void loadMedia()
	{
		try {
			smallfont = loadAndSplit("smallfont.png", 4, 6);
			gui = loadAndSplit("gui.png", 64, 64);
			outside = new Map("OUTSIDE");
			tiles = loadAndSplit("tiles.png", 16, 24);
			font = loadAndSplit("font.png", 8, 12);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static BufferedImage[][] loadAndSplit(String name, int w, int h)
	{
		BufferedImage original = null;
		try {
			original = ImageIO.read(MediaManager.class.getResourceAsStream(name));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(original.getWidth()%w!=0 || original.getHeight()%h!=0)
		{
			System.out.println("ERROR: THE SPECIFIED DIMENSIONS DO NOT WORK.");
			System.exit(0);
		}
		BufferedImage[][] toReturn = new BufferedImage[original.getWidth()/w][original.getHeight()/h];
		for(int x = 0; x < original.getWidth()/w; x++)
		{
			for(int y = 0; y < original.getHeight()/h; y++)
			{
				toReturn[x][y] = original.getSubimage(x*w, y*h, w, h);
			}
		}
		return toReturn;
	}
}

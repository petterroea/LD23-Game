package me.petterroea.LD23;

import java.awt.Graphics;
import java.awt.Graphics2D;

public class Tile {
	int tilex, tiley;
	int w, h;
	public Tile(int tilex, int tiley)
	{
		this.tilex = tilex;
		this.tiley = tiley;
		this.w = 16;
		this.h = 16;
	}
	public boolean activate()
	{
		return false;
	}
	public boolean collides()
	{
		return false;
	}
	public void extraDraw(Graphics g, int xoff, int yoff)
	{
		
	}
	public void draw(Graphics g, int xoff, int yoff, Map map)
	{
		if(isVisible(xoff, yoff))
		{
			g.drawImage(MediaManager.tiles[0][0].getSubimage(0, 8, 16, 16), (tilex*w)+xoff, (tiley*h)+yoff, null);
		}
	}
	public boolean isVisible(int xoff, int yoff)
	{
		if((tilex*w)+xoff > Game.WIDTH || (tiley*h)+yoff > Game.HEIGHT)
		{
			return false;
		}
		return true;
	}
	public boolean hasExtraDraw() {
		// TODO Auto-generated method stub
		return false;
	}
}

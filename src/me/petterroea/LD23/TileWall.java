package me.petterroea.LD23;

import java.awt.Graphics;
import java.awt.Graphics2D;

public class TileWall extends Tile {

	public TileWall(int tilex, int tiley) {
		super(tilex, tiley);
		// TODO Auto-generated constructor stub
	}
	public boolean collides()
	{
		return true;
	}
	public boolean hasExtraDraw() {
		// TODO Auto-generated method stub
		return true;
	}
	public void extraDraw(Graphics g, int xoff, int yoff)
	{
		if(isVisible(xoff, yoff))
		{
			g.drawImage(MediaManager.tiles[1][0].getSubimage(0, 0, 16, 8), (tilex*w)+xoff, (tiley*h)+yoff-8, null);
		}
	}
	public void draw(Graphics g, int xoff, int yoff, Map map)
	{
		if(isVisible(xoff, yoff))
		{
			g.drawImage(MediaManager.tiles[1][0].getSubimage(0, 8, 16, 16), (tilex*w)+xoff, (tiley*h)+yoff, null);
		}
	}
}

package me.petterroea.LD23;

import java.awt.Graphics;

public class TileMapEnd extends Tile {
	char name;
	public TileMapEnd(int tilex, int tiley, char name) {
		super(tilex, tiley);
		this.name = name;
		// TODO Auto-generated constructor stub
	}
	public boolean collides()
	{
		return true;
	}
	public void draw(Graphics g, int xoff, int yoff, Map map)
	{
		if(isVisible(xoff, yoff))
		{
			if(name == 'l')
			{
				g.drawImage(MediaManager.tiles[4][0].getSubimage(0, 8, 16, 16), (tilex*w)+xoff, (tiley*h)+yoff, null);
			}
			else if(name == 't')
			{
				g.drawImage(MediaManager.tiles[5][1].getSubimage(0, 8, 16, 16), (tilex*w)+xoff, (tiley*h)+yoff, null);
			}
			else if(name == 'b')
			{
				g.drawImage(MediaManager.tiles[5][2].getSubimage(0, 8, 16, 16), (tilex*w)+xoff, (tiley*h)+yoff, null);
			}
			else if(name == 'T')
			{
				g.drawImage(MediaManager.tiles[5][0].getSubimage(0, 8, 16, 16), (tilex*w)+xoff, (tiley*h)+yoff, null);
			}
			else if(name == 'B')
			{
				g.drawImage(MediaManager.tiles[6][0].getSubimage(0, 8, 16, 16), (tilex*w)+xoff, (tiley*h)+yoff, null);
			}
			else if(name == 'r')
			{
				g.drawImage(MediaManager.tiles[6][1].getSubimage(0, 8, 16, 16), (tilex*w)+xoff, (tiley*h)+yoff, null);
			}
			else if(name == 'R')
			{
				g.drawImage(MediaManager.tiles[3][0].getSubimage(0, 8, 16, 16), (tilex*w)+xoff, (tiley*h)+yoff, null);
			}
			else if(name == 'c')
			{
				g.drawImage(MediaManager.tiles[6][2].getSubimage(0, 8, 16, 16), (tilex*w)+xoff, (tiley*h)+yoff, null);
			}
		}
	}

}

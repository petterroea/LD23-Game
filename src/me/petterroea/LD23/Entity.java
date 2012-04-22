package me.petterroea.LD23;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Entity {
	double x, y;
	double xspeed = 0.0, yspeed = 0.0;
	public Entity(double x, double y)
	{
		this.x = x;
		this.y = y;
	}
	public void update(int delta, Map map)
	{
		double oldx = x;
		double oldy = y;
		int thisTilex = (int) (x/16);
		int thisTiley = (int) (y/16);
		x = x + (xspeed*delta);
		Rectangle colbox = new Rectangle((int)x, (int)y, 16, 16);
		for(int ix = thisTilex-1; ix < thisTilex+2; ix++)
		{
			for(int iy = thisTiley-1; iy < thisTiley+2; iy++)
			{
				if(map.tilemap[ix][iy].collides() && colbox.intersects(new Rectangle(ix*16, iy*16, 16, 16)))
				{
					x = oldx;
					xspeed = 0.0;
				}
			}
		}
		y = y + (yspeed*delta);
		colbox = new Rectangle((int)x, (int)y, 16, 16);
		for(int ix = thisTilex-1; ix < thisTilex+2; ix++)
		{
			for(int iy = thisTiley-1; iy < thisTiley+2; iy++)
			{
				if(map.tilemap[ix][iy].collides() && colbox.intersects(new Rectangle(ix*16, iy*16, 16, 16)))
				{
					y = oldy;
					yspeed = 0.0;
				}
			}
		}
	}
	public void draw(Graphics g, int xoff, int yoff)
	{
		g.drawImage(MediaManager.tiles[2][0], (int)x+xoff, (int)y+yoff-8, null);
	}
}

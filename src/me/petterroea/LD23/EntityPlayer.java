package me.petterroea.LD23;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;

public class EntityPlayer extends Entity {

	public EntityPlayer(double x, double y) {
		super(x, y);
		// TODO Auto-generated constructor stub
	}
	int direction = 1;
	double speed = 0.05;
	int targetX = 0;
	int targetY = 0;
	boolean targeted = false;
	public int getPos(int raw)
	{
		if(raw==0)
		{
			return 0;
		}
		if(raw==1)
		{
			return 1;
		}
		if(raw==2)
		{
			return 0;
		}
		if(raw==3)
		{
			return 4;
		}
		if(raw==4)
		{
			return 2;
		}
		if(raw==5)
		{
			return 3;
		}
		if(raw==6)
		{
			return 2;
		}
		return 4;
	}
	public void draw(Graphics g, int xoff, int yoff)
	{
		if(Input.keys[KeyEvent.VK_S])
		{
			direction = 1;
		}
		if(Input.keys[KeyEvent.VK_W])
		{
			direction = 2;
		}
		if(Input.keys[KeyEvent.VK_D])
		{
			direction = 3;
		}
		if(Input.keys[KeyEvent.VK_A])
		{
			direction = 4;
		}
		if(xspeed==0.0&&yspeed==0.0)
		{
			g.drawImage(MediaManager.tiles[4][direction], (int)x+xoff, (int)y+yoff-8, null);
		}
		else
		{
			int walkscore = (int)((x+y)/5);
			g.drawImage(MediaManager.tiles[getPos(walkscore%7)][direction], (int)x+xoff, (int)y+yoff-8, null);
			
		}
	}
	@Override
	public void update(int delta, Map map)
	{
		int currTilex = (int)x/16;
		int currTiley = (int)y/16;
		if(Input.keys[KeyEvent.VK_E])
		{
			if(direction==1)
			{
				Tile active = map.tilemap[currTilex][currTiley+1];
				active.activate();
				if(active.activate())
				{
					GameScreen.currentQuest = GameScreen.currentQuest.complete(map, active);
				}
			}
			else if(direction==2)
			{
				Tile active = map.tilemap[currTilex][currTiley-1];
				active.activate();
				if(active.activate())
				{
					GameScreen.currentQuest = GameScreen.currentQuest.complete(map, active);
				}
			}
			else if(direction==3)
			{
				Tile active = map.tilemap[currTilex+1][currTiley];
				active.activate();
				if(active.activate())
				{
					GameScreen.currentQuest = GameScreen.currentQuest.complete(map, active);
				}
			}
			else if(direction==4)
			{
				Tile active = map.tilemap[currTilex-1][currTiley];
				active.activate();
				if(active.activate())
				{
					GameScreen.currentQuest = GameScreen.currentQuest.complete(map, active);
				}
			}
			else
			{
				System.out.println("INVALID DIRECTION");
			}
			
		}		
		if(!targeted)
		{
			targetX = (int)x;
			targetY = (int)y;
			targeted = true;
		}
		
		if(Input.keys[KeyEvent.VK_A])
		{
			targetX = (currTilex - 1)*16;
		}
		else if(Input.keys[KeyEvent.VK_D])
		{
			targetX = (currTilex + 1)*16;
		}
		
		if(Input.keys[KeyEvent.VK_W])
		{
			targetY = (currTiley - 1)*16;
		}
		else if(Input.keys[KeyEvent.VK_S])
		{
			targetY = (currTiley + 1)*16;
		}
		
		if(targetX < x&&!closeTo(targetX, x))
		{
			xspeed = -speed;
		}
		else if(targetX > x&&!closeTo(targetX, x))
		{
			xspeed = speed;
		}
		else
		{
			xspeed = 0;
			x=targetX;
		}
		
		if(targetY < y&&!closeTo(targetY, y))
		{
			yspeed = -speed;
		}
		else if(targetY > y&&!closeTo(targetY, y))
		{
			yspeed = speed;
		}
		else
		{
			yspeed = 0;
			y=targetY;
		}
		super.update(delta, map);
		if(y < -map.yoff + 100)
		{
		map.yoff = map.yoff + 2;
		}
		if(y > -map.yoff - 100 + Game.HEIGHT)
		{
		map.yoff = map.yoff - 2;
		}
		if(x < -map.xoff + 100)
		{
			map.xoff = map.xoff + 2;
		}
		if(x > -map.xoff - 100 + Game.WIDTH)
		{
			map.xoff = map.xoff - 2;
		}
	}
	public boolean closeTo(double en, double to)
	{
		if(en+2>to&&en-2<to)
		{
			return true;
		}
		return false;
	}
}

package me.petterroea.LD23;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.LinkedList;

public class Map
{
  Tile[][] tilemap;
  int xoff = 0;
  int yoff = 0;
  int tilemapw;
  int tilemaph;
  LinkedList<Entity> entities;
  public Map(String[] src)
  {
    this.entities = new LinkedList();
    this.tilemap = new Tile[src[0].length()][src.length];
    this.tilemapw = src[0].length();
    this.tilemaph = src.length;
    for (int x = 0; x < src[0].length(); x++)
    {
      for (int y = 0; y < src.length; y++)
      {
        char at = src[y].charAt(x);
        if (at == 'W')
        {
          this.tilemap[x][y] = new TileWall(x, y);
        }
        else if (at == 'P')
        {
          this.tilemap[x][y] = new Tile(x, y);
          this.entities.add(new EntityPlayer(x * 16, y * 16));
        }
        else
        {
          this.tilemap[x][y] = new Tile(x, y);
        }
      }
    }
    
  }

  public Map(String path)
  {
    this.entities = new LinkedList();
    BufferedReader reader = null;
    StringBuffer buffer = new StringBuffer();
    int height = 0;
    try {
      InputStreamReader temp = new InputStreamReader(Map.class.getResourceAsStream(path));
      reader = new BufferedReader(temp);
      String text = null;

      while ((text = reader.readLine()) != null)
      {
        buffer.append(text).append("\n");
      }
    } catch (Exception e) {
      System.out.println("Could not read map: " + e);
    }
    String[] src = buffer.toString().split("\n");
    this.tilemap = new Tile[src[0].length()][src.length];
    this.tilemapw = src[0].length();
    this.tilemaph = src.length;
    for (int x = 0; x < src[0].length(); x++)
    {
      for (int y = 0; y < src.length; y++)
      {
        char at = src[y].charAt(x);
        if (at == 'W')
        {
          this.tilemap[x][y] = new TileWall(x, y);
        }
        else if (at == 'P')
        {
          this.tilemap[x][y] = new Tile(x, y);
          this.entities.add(new EntityPlayer(x * 16, y * 16));
        }
        else if(at== 'l')
        {
        	this.tilemap[x][y] = new TileMapEnd(x, y, at);
        }
        else if(at== 't')
        {
        	this.tilemap[x][y] = new TileMapEnd(x, y, at);
        }
        else if(at== 'b')
        {
        	this.tilemap[x][y] = new TileMapEnd(x, y, at);
        }
        else if(at== 'T')
        {
        	this.tilemap[x][y] = new TileMapEnd(x, y, at);
        }
        else if(at== 'B')
        {
        	this.tilemap[x][y] = new TileMapEnd(x, y, at);
        }
        else if(at== 'r')
        {
        	this.tilemap[x][y] = new TileMapEnd(x, y, at);
        }
        else if(at== 'R')
        {
        	this.tilemap[x][y] = new TileMapEnd(x, y, at);
        }
        else if(at== 'c')
        {
        	this.tilemap[x][y] = new TileMapEnd(x, y, at);
        }
        else if(at== 'F')
        {
        	this.tilemap[x][y] = new TileFurnace(x, y);
        }
        else
        {
          this.tilemap[x][y] = new Tile(x, y);
        }
      }
    }
  }

  public void update(int delta)
  {
    for (int i = 0; i < this.entities.size(); i++)
    {
      ((Entity)this.entities.get(i)).update(delta, this);
    }
  }

  public void draw(Graphics g) {
    long start = System.currentTimeMillis();
    LinkedList<Coordinate> extraDraw = new LinkedList<Coordinate>();
    for (int x = fixminus(-(this.xoff / 16)); x < overflow(this.tilemapw, -this.xoff / 16 + Game.WIDTH / 16 + 1); x++)
    {
      for (int y = fixminus(-(this.yoff / 16)); y < overflow(this.tilemaph, -this.yoff / 16 + Game.HEIGHT / 16 + 1); y++)
      {
        this.tilemap[x][y].draw(g, this.xoff, this.yoff, this);
        if (!this.tilemap[x][y].hasExtraDraw())
          continue;
        extraDraw.add(new Coordinate(x, y));
      }

    }

    for (int i = 0; i < this.entities.size(); i++)
    {
      ((Entity)this.entities.get(i)).draw(g, this.xoff, this.yoff);
    }

    start = System.currentTimeMillis();
    for (int i = 0; i < extraDraw.size(); i++)
    {
      this.tilemap[((Coordinate)extraDraw.get(i)).x][((Coordinate)extraDraw.get(i)).y].extraDraw(g, this.xoff, this.yoff);
    }
  }

  public int overflow(int trigger, int one)
  {
    if (one > trigger)
    {
      return trigger;
    }
    return one;
  }

  public int fixminus(int one) {
    if (one < 0)
    {
      return 0;
    }
    return one;
  }
}
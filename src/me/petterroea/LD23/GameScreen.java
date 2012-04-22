package me.petterroea.LD23;

import java.awt.Color;
import java.awt.Graphics;

import me.petterroea.LD23.quest.QuestCook;

public class GameScreen extends Screen {
	static Item[] slots;
	static Quest currentQuest;
	static int currentslot = 0;
	static int health = 5;
	static int maxhealth = 10;
	public GameScreen()
	{
		currentQuest = new QuestCook();
		slots = new Item[4];
		for(int i = 0; i < slots.length; i++)
		{
			slots[i] = new Item();
		}
	}
	@Override
	public void tick(Graphics g, int delta)
	{
		long start = System.currentTimeMillis();
		if(Input.focus)
		{
			g.setColor(Color.black);
			g.fillRect(0, 0, Game.WIDTH, Game.HEIGHT);
			MediaManager.outside.update(delta);
		}
		//System.out.println("Update: " + (System.currentTimeMillis() - start));
		start = System.currentTimeMillis();
		MediaManager.outside.draw(g);
		//System.out.println("Draw: " + (System.currentTimeMillis() - start));
		for(int x = 0; x < (Game.WIDTH/64)-1; x++)
		{
			if(x==(Game.WIDTH/64)-2)
			{
				g.drawImage(MediaManager.gui[2][1], x*64, Game.HEIGHT-70, null);
			}
			else
			{
				g.drawImage(MediaManager.gui[1][1], x*64, Game.HEIGHT-70, null);
			}
		}
		SmallFont.draw(g, 0, Game.HEIGHT-60, "Quest: " + currentQuest.getName());
		SmallFont.draw(g, 20, Game.HEIGHT-50, currentQuest.getDesc());
		for(int i = 0; i < health; i++)
		{
			g.drawImage(MediaManager.gui[2][0], (i)*11, Game.HEIGHT-80, null);
		}
		for(int i = 0; i < (maxhealth - health); i++)
		{
			g.drawImage(MediaManager.gui[3][0], (i+health)*11, Game.HEIGHT-80, null);
		}
		if(!Input.focus)
		{
			Color tran = new Color(10, 10, 10, 100);
			g.setColor(tran);
			g.fillRect(0, 0, Game.WIDTH, Game.HEIGHT);
			Font.draw(g, (Game.WIDTH/2)-(((15*Font.getWidth())+15)/2), Game.HEIGHT/2, "Click to focus!");
		}
	}
}

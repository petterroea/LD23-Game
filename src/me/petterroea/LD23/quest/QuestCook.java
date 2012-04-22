package me.petterroea.LD23.quest;

import me.petterroea.LD23.*;

public class QuestCook implements Quest{
	public String getName()
	{
		return "Cook a meal";
	}
	public Quest complete(Map map, Tile activated)
	{
		if(activated instanceof TileFurnace)
		{
			return new QuestEat();
		}
		return this;
	}
	public String getDesc()
	{
		return "Cook the piece of meat you have in your inventory";
	}
	@Override
	public Quest itemUsed(Map map, Item item) {
		// TODO Auto-generated method stub
		return this;
	}
}

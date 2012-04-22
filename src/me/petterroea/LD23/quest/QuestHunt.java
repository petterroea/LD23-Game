package me.petterroea.LD23.quest;

import me.petterroea.LD23.Item;
import me.petterroea.LD23.Map;
import me.petterroea.LD23.Quest;
import me.petterroea.LD23.Tile;

public class QuestHunt implements Quest {

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "Hunt!";
	}

	@Override
	public Quest complete(Map map, Tile activated) {
		// TODO Auto-generated method stub
		return this;
	}

	@Override
	public String getDesc() {
		// TODO Auto-generated method stub
		return "Kill a monster to get some meat";
	}

	@Override
	public Quest itemUsed(Map map, Item item) {
		// TODO Auto-generated method stub
		return null;
	}

}

package me.petterroea.LD23.quest;

import java.awt.event.KeyEvent;

import me.petterroea.LD23.GameScreen;
import me.petterroea.LD23.Input;
import me.petterroea.LD23.Item;
import me.petterroea.LD23.Map;
import me.petterroea.LD23.Quest;
import me.petterroea.LD23.Tile;

public class QuestEat implements Quest {

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "Eat your meat!";
	}

	@Override
	public Quest complete(Map map, Tile activated) {
		// TODO Auto-generated method stub
		return this;
	}

	@Override
	public String getDesc() {
		// TODO Auto-generated method stub
		return "Press Q to use your item";
	}

	@Override
	public Quest itemUsed(Map map, Item item) {
		// TODO Auto-generated method stub
		return null;
	}

}

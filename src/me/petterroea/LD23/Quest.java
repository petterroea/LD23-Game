package me.petterroea.LD23;

public interface Quest {
	public String getName();
	public Quest complete(Map map, Tile activated);
	public String getDesc();
	public Quest itemUsed(Map map, Item item);
}

package me.petterroea.LD23;

import java.awt.Graphics;

public class Font {
	static String[] chars={"ABCDEFGHIJ",
			"KLMNOPQRST",
			"UVWXYZ!:.,",
			"1234567890",
			" "};
	public static void draw(Graphics g, int x, int y, String text)
	{
		text = text.toUpperCase();
		for(int i = 0; i < text.length(); i++)
		{
			for(int a = 0; a < chars.length; a++)
			{
				if(chars[a].indexOf(text.charAt(i)) >-1)
				{
					int index = chars[a].indexOf(text.charAt(i));
					g.drawImage(MediaManager.font[index][a], (getWidth()*i)+(i)+x, y, null);
				}
			}
		}
	}
	public static int getWidth()
	{
		return MediaManager.font[0][0].getWidth();
	}
}

package me.petterroea.LD23;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class Input implements MouseListener, KeyListener, FocusListener, MouseMotionListener{
	public static boolean keys[];
	public static boolean noticed[];
	public static boolean left = false;
	public static boolean right = false;
	public static boolean middle = false;
	public static boolean focus = true;
	Game game;
	public Input(Game game)
	{
		this.game = game;
		keys = new boolean[600];
		noticed = new boolean[600];
	}
	@Override
	public void focusGained(FocusEvent arg0) {
		focus = true;
		game.current.focusGained(arg0);
	}
	@Override
	public void focusLost(FocusEvent arg0) {
		focus = false;
		game.current.focusLost(arg0);
	}
	@Override
	public void keyPressed(KeyEvent arg0) {
		if(arg0.getKeyCode() < 600)
		{
			keys[arg0.getKeyCode()] = true;
			if(!noticed[arg0.getKeyCode()])
			{
				noticed[arg0.getKeyCode()] = true;
				game.current.keyTyped(arg0);
			}
		}
		game.current.keyPressed(arg0);
	}
	@Override
	public void keyReleased(KeyEvent arg0) {
		if(arg0.getKeyCode() < 600)
		{
			keys[arg0.getKeyCode()] = false;
			noticed[arg0.getKeyCode()] = false;
		}
		game.current.keyReleased(arg0);
	}
	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		//game.current.keyTyped(arg0);
	}
	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		game.current.mouseClicked(arg0);
	}
	@Override
	public void mousePressed(MouseEvent arg0) {
		switch(arg0.getButton())
		{
		case 1:
			left = true;
			break;
		case 2:
			middle = true;
			break;
		case 3:
			right = true;
			break;
		default:
				
			break;
		}
		game.current.mousePressed(arg0);
	}
	@Override
	public void mouseReleased(MouseEvent arg0) {
		switch(arg0.getButton())
		{
		case 1:
			left = false;
			break;
		case 2:
			middle = false;
			break;
		case 3:
			right = false;
			break;
		default:
				
			break;
		}
		game.current.mouseReleased(arg0);
		
	}
	@Override
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}

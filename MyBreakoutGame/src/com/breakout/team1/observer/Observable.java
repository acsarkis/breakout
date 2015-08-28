package com.breakout.team1.observer;
import java.awt.event.KeyEvent;

public interface Observable {
	public void NotifyObservers(KeyEvent keyEvent);
}

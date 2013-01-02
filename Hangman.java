/*
 * File: Hangman.java
 * ------------------
 * This program will eventually play the Hangman game from
 * Assignment #4.
 */

import acm.graphics.*;
import acm.program.*;
import acm.util.*;

import java.awt.*;

public class Hangman extends ConsoleProgram {
	public void init() {
		canvas = new HangmanCanvas();
		add(canvas);
	}
	
	public void run() {
		println ("Hello");
    	/* You fill this in */
	}
private HangmanCanvas canvas;
    
}

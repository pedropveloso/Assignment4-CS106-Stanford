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
/*	public void init() {
		canvas = new HangmanCanvas();
		add(canvas);
	}*/
	
	public void run() {
		println ("Welcome to Hangman!");
		chooseWord();
/*		while (!gameOver) {
			showWord();
			gess();
		}*/
	}
	
	private void chooseWord() {
		int index = rgen.nextInt(0,HangmanLexicon.getWordCount()-1);
		word = HangmanLexicon.getWord(index);
		println (word);
	}
	
	
//private HangmanCanvas canvas;
private String word; //the secret word of the game	
private RandomGenerator rgen = RandomGenerator.getInstance();    
}

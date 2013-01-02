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

private static final int GUESSES = 8;	
	
	/*	public void init() {
		canvas = new HangmanCanvas();
		add(canvas);
	}*/
	
	public void run() {
		println ("Welcome to Hangman!");
		setup();
		while (!gameOver()) {
			showWord();
			newGuess();
		}
	}
	
	private boolean gameOver() {
		return (win) || (loose);
	}
	
	private void setup() {
		guess = GUESSES;
		int index = rgen.nextInt(0,HangmanLexicon.getWordCount()-1);
		word = HangmanLexicon.getWord(index);
		len = word.length();
		result = "";
		for (int i=0; i<len; i++) {
			result = result + "-";
		}
	}
	
	private void showWord() {
		println ("The word now looks like this: " + result);
		switch (guess) {
		case 1: println("You have only one guess left");
		default: println("You have " + guess + " guesses left.");
		}
	}
	
	private void newGuess(){
		String str = readLine("Please enter a new guess:");
		if (str.length() == 1) {
			char ch = Character.toUpperCase(str.charAt(0));
			for (int i=0; i<len; i++) {
				if (word.charAt(i) == ch) {
					result = result.substring(0,i) + ch + result.substring(i+1);
				}
			}
		} else {
			println ("Please insert only one character");
		}
	}
	
//private HangmanCanvas canvas;
private String word; //the secret word of the game	
private int len; // the length of the secret word
private int guess; //the number of guesses the user has
private String result; //the current state of the guesses word
private boolean win; //true when user guesses all the letters of the word
private boolean loose; //true when the player makes 8 wrong guesses
private RandomGenerator rgen = RandomGenerator.getInstance();    
}

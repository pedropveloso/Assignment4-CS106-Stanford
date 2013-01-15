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

/*Constant*/
private static final int GUESSES = 8;	

/*Instance variables*/
private HangmanCanvas canvas;
private HangmanLexicon lexicon;
private String word; //the secret word of the game	
private int len; // the length of the secret word
private int guess; //the number of guesses the user has
private String result; //the current state of the guesses word
private boolean win; //true when user guesses all the letters of the word
private boolean lose; //true when the player makes 8 wrong guesses
private RandomGenerator rgen = RandomGenerator.getInstance();    

	public void init() {
		canvas = new HangmanCanvas();
		add(canvas);
		lexicon = new HangmanLexicon();
	}
	
	public void run() {
		println ("Welcome to Hangman!");
		setup();
		play();
	}
	
	private void play() {
		while (!gameOver()) {
			showWord();
			newGuess();
		}
		showResult();
	}
	
	private boolean gameOver() {
		return (win) || (lose);
	}
	
	private void setup() {
		canvas.reset();
		guess = GUESSES;
		int index = rgen.nextInt(0, lexicon.getWordCount()-1);
		word = lexicon.getWord(index);
		len = word.length();
		result = "";
		for (int i=0; i<len; i++) {
			result = result + "-";
		}
	}
	
	private void showWord() {
		println ("The word now looks like this: " + result);
		canvas.displayWord(result);
		switch (guess) {
		case 1: println("You have only one guess left"); break;
		default: println("You have " + guess + " guesses left."); break;
		}
	}
	
	private void newGuess(){
		String str = readLine("Please enter a new guess:");
		if (str.length() == 1) {
			char ch = Character.toUpperCase(str.charAt(0));
			if (word.indexOf(ch) == -1) {
				println("There are no " + ch +"'s in the word");
				canvas.noteIncorrectGuess(ch);
				guess--;
			} else {
				for (int i=0; i<len; i++) {
					if (word.charAt(i) == ch) {
						result = result.substring(0,i) + ch + result.substring(i+1);
					}
				}
				println("That guess is correct.");
			}
		} else {
			println ("Please insert only one character");
		}
		if (guess ==0) lose=true;
		if (result.equalsIgnoreCase(word)) win=true;
	}
	
	private void showResult() {
		if (win) {
			canvas.displayWord(result);
			println("You guessed the word: " + word);
			println("Congratulations. You won!");
		}else if (lose) {
			println("You're completely hung.");
			println("The word was: " + word);
			println("Sorry, you lost. Try again.");
		}
	}
	

}

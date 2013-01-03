/*
 * File: HangmanCanvas.java
 * ------------------------
 * This file keeps track of the Hangman display.
 */

import acm.graphics.*;

public class HangmanCanvas extends GCanvas {

/* Instance variables*/
private double xCenter;
private double xScaffold;
private double yScaffoldTop;
private double yScaffoldBottom;
private double yRope;
private double ySecretWord;
private double xSecretWord;
private double yBadGuesses;
private double xBadGuesses;
private GLabel secretWord = new GLabel ("");
private GLabel badGuesses = new GLabel ("");
	
/** Resets the display so that only the scaffold appears */
	public void reset() {
		removeAll();
		drawScaffold();
	}

	private void drawScaffold() {
		xCenter = getWidth()/2;
		xScaffold = xCenter - BEAM_LENGTH;
		yScaffoldTop = getHeight()/2 - ROPE_LENGTH - 2 * HEAD_RADIUS - BODY_LENGTH;
		yScaffoldBottom = yScaffoldTop + SCAFFOLD_HEIGHT;
		yRope = yScaffoldTop + ROPE_LENGTH;
		ySecretWord = (getHeight() + yScaffoldBottom)/2; 
		xSecretWord = getWidth()/2;
		GLine scaffold = new GLine (xScaffold, yScaffoldTop, xScaffold, yScaffoldBottom);
		GLine beam = new GLine(xScaffold, yScaffoldTop, xCenter, yScaffoldTop);
		GLine rope = new GLine (xCenter, yScaffoldTop, xCenter, yRope);
		add (scaffold);
		add (beam);
		add (rope);
		add (secretWord, xSecretWord, ySecretWord);
	}

/**
 * Updates the word on the screen to correspond to the current
 * state of the game.  The argument string shows what letters have
 * been guessed so far; unguessed letters are indicated by hyphens.
 */
	public void displayWord(String word) {
		secretWord.setLabel(word);
		secretWord.setFont("Helvetica, font.BOLD, 40");
		double x = (getWidth()- secretWord.getWidth())/2;
		secretWord.move(x, ySecretWord);
	}

/**
 * Updates the display to correspond to an incorrect guess by the
 * user.  Calling this method causes the next body part to appear
 * on the scaffold and adds the letter to the list of incorrect
 * guesses that appears at the bottom of the window.
 */
	public void noteIncorrectGuess(char letter) {
		
	}

/* Constants for the simple version of the picture (in pixels) */
	private static final int SCAFFOLD_HEIGHT = 360;
	private static final int BEAM_LENGTH = 144;
	private static final int ROPE_LENGTH = 18;
	private static final int HEAD_RADIUS = 36;
	private static final int BODY_LENGTH = 144;
	private static final int ARM_OFFSET_FROM_HEAD = 28;
	private static final int UPPER_ARM_LENGTH = 72;
	private static final int LOWER_ARM_LENGTH = 44;
	private static final int HIP_WIDTH = 36;
	private static final int LEG_LENGTH = 108;
	private static final int FOOT_LENGTH = 28;

}

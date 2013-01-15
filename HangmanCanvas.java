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
private double xHead;
private double yBodyTop;
private double yBodyBottom;
private double yUpperArm;
private double yLowerArm;
private GOval head;
private GLine body;
private GLine leftUpperArm;
private GLine leftLowerArm;
private GLine rightUpperArm;
private GLine rightLowerArm;
private GLine leftHip;
private GLine leftLeg;
private GLine rightHip;
private GLine rightLeg;
private GLine leftFoot;
private GLine rightFoot;
private double ySecretWord;
private double xSecretWord;
private double yBadGuesses;
private double xBadGuesses;
private GLabel secretWord = new GLabel ("");
private String str = "";
private GLabel badGuesses = new GLabel ("");
	
/** Resets the display so that only the scaffold appears */
	public void reset() {
		badGuesses.setLabel("");
		str = "";
		removeAll();
		drawScaffold();
	}

	private void drawScaffold() {
		xCenter = getWidth()/2;
		xScaffold = xCenter - BEAM_LENGTH;
		yScaffoldTop = getHeight()/2 - ROPE_LENGTH - 2 * HEAD_RADIUS - BODY_LENGTH;
		yScaffoldBottom = yScaffoldTop + SCAFFOLD_HEIGHT;
		yRope = yScaffoldTop + ROPE_LENGTH;
		xHead = xCenter - HEAD_RADIUS;
		yBodyTop = yRope + 2 * HEAD_RADIUS;
		yBodyBottom = yBodyTop + BODY_LENGTH;
		yUpperArm = yBodyTop + ARM_OFFSET_FROM_HEAD;
		yLowerArm = yUpperArm + LOWER_ARM_LENGTH;
		ySecretWord = (getHeight() + yScaffoldBottom)/2; 
		xSecretWord = getWidth()/2;
		xBadGuesses = getWidth()/2;
		yBadGuesses = (getHeight() - BOTTOM_OFFSET);
		GLine scaffold = new GLine (xScaffold, yScaffoldTop, xScaffold, yScaffoldBottom);
		GLine beam = new GLine(xScaffold, yScaffoldTop, xCenter, yScaffoldTop);
		GLine rope = new GLine (xCenter, yScaffoldTop, xCenter, yRope);
		head = new GOval (xHead, yRope, 2*HEAD_RADIUS, 2*HEAD_RADIUS);
		body = new GLine (xCenter, yBodyTop, xCenter, yBodyBottom);
		leftUpperArm = new GLine (xCenter, yUpperArm, xCenter - UPPER_ARM_LENGTH, yUpperArm);
		leftLowerArm = new GLine (xCenter - UPPER_ARM_LENGTH, yUpperArm, xCenter - UPPER_ARM_LENGTH, yLowerArm);
		rightUpperArm = new GLine (xCenter, yUpperArm, xCenter + UPPER_ARM_LENGTH, yUpperArm);
		rightLowerArm = new GLine (xCenter + UPPER_ARM_LENGTH, yUpperArm, xCenter + UPPER_ARM_LENGTH, yLowerArm);
		leftHip = new GLine (xCenter, yBodyBottom, xCenter - HIP_WIDTH, yBodyBottom);
		leftLeg = new GLine (xCenter - HIP_WIDTH, yBodyBottom, xCenter - HIP_WIDTH, yBodyBottom + LEG_LENGTH);
		rightHip = new GLine (xCenter, yBodyBottom, xCenter + HIP_WIDTH, yBodyBottom);
		rightLeg = new GLine (xCenter + HIP_WIDTH, yBodyBottom, xCenter + HIP_WIDTH, yBodyBottom + LEG_LENGTH);
		leftFoot = new GLine (xCenter - HIP_WIDTH, yBodyBottom + LEG_LENGTH, xCenter - HIP_WIDTH - FOOT_LENGTH, yBodyBottom + LEG_LENGTH);
		rightFoot = new GLine (xCenter + HIP_WIDTH, yBodyBottom + LEG_LENGTH, xCenter + HIP_WIDTH + FOOT_LENGTH, yBodyBottom + LEG_LENGTH);
		add (scaffold);
		add (beam);
		add (rope);
		add (secretWord, xSecretWord, ySecretWord);
		add (badGuesses);
	}

/**
 * Updates the word on the screen to correspond to the current
 * state of the game.  The argument string shows what letters have
 * been guessed so far; unguessed letters are indicated by hyphens.
 */
	public void displayWord(String word) {
		secretWord.setLabel(word);
		secretWord.setFont("Helvetica-28");
		double x = (getWidth()- secretWord.getWidth())/2;
		secretWord.setLocation(x, ySecretWord);
	}

/**
 * Updates the display to correspond to an incorrect guess by the
 * user.  Calling this method causes the next body part to appear
 * on the scaffold and adds the letter to the list of incorrect
 * guesses that appears at the bottom of the window.
 */
	public void noteIncorrectGuess(char letter) {
		str = str + letter;
		badGuesses.setLabel(str);
		double x = (getWidth()- badGuesses.getWidth())/2;
		badGuesses.setLocation(x, yBadGuesses);
		int i = str.length();
		switch (i) {
		case 1: add (head); break;
		case 2: add (body); break;
		case 3: add (leftUpperArm);add (leftLowerArm);break;
		case 4: add (rightUpperArm); add (rightLowerArm);break;
		case 5: add (leftHip);add (leftLeg); break;
		case 6: add (rightHip);add (rightLeg); break;
		case 7: add (leftFoot); break;
		case 8: add (rightFoot); break;
		}
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
	private static final int BOTTOM_OFFSET = 10;

}

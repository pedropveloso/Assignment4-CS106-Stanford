/*
 * File: HangmanLexicon.java
 * -------------------------
 * This file contains a stub implementation of the HangmanLexicon
 * class that you will reimplement for Part III of the assignment.
 */

import acm.util.*;
import java.io.*;
import java.util.*;

public class HangmanLexicon {

/* ArrayList of with the words */
private ArrayList<String> lineList;
	
	public HangmanLexicon() {
		try {
			BufferedReader rd = new BufferedReader (new FileReader ("HangmanLexicon.txt"));
			lineList = new ArrayList<String>();
			while (true) {
				String line = rd.readLine();
				if (line==null) break;
				lineList.add(line);
			}
			rd.close();
		} catch (IOException ex) {
			throw new ErrorException(ex);
		}
	}
	
	/** Returns the number of words in the lexicon. */
	public int getWordCount() {
		int size = lineList.size();
		return size;
	}

/** Returns the word at the specified index. */
	public String getWord(int index) {
		return lineList.get(index);
	};
}

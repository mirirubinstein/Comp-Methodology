package rubinstein.dictionary;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Dictionary {
	ArrayList<String> words;
	Alphabet[] alphabet;
	int[] num;
	double[] percentageUsed;

	public Dictionary() throws FileNotFoundException {
		words = new ArrayList<String>();
		alphabet = Alphabet.values();

		Scanner info = new Scanner(new File("OWL.txt"));
		while (info.hasNextLine()) {
			String[] delims = info.nextLine().split("\\s");
			String word = delims[0];
			words.add(word);
		}
		info.close();

	}

	public boolean exists(String word) {
		if (words.contains(word.toUpperCase()))
			return true;
		else
			return false;
	}

	public ArrayList<String> getWords() {
		return words;
	}

}

package rubinstein.dictionary;

import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Formatter;

public class StatisticsOfOWL {
	public static void main(String[] args) {

		Dictionary dict;
		try {
			dict = new Dictionary();

			Alphabet[] alph = Alphabet.values();

			ArrayList<String> words = dict.getWords();

			int[] numTimesInDictionary = new int[256];
			int[] charactersInWord = new int[256];

			for (String c : words) {
				boolean[] alreadyFoundInWord = new boolean[256];
				for (int i = 0; i < alreadyFoundInWord.length; i++) {
					// initialize all to false
					alreadyFoundInWord[i] = false;
				}
				for (int i = 0; i < c.length(); i++) {
					numTimesInDictionary[c.charAt(i)]++;
					// need to switch the upper case somewhere
					if (alreadyFoundInWord[c.charAt(i)] != true) {
						charactersInWord[c.charAt(i)]++;
						alreadyFoundInWord[c.charAt(i)] = true;
					}

				}

			}

			for (Alphabet c : alph) {// dont loop thru alphabet.. loop thru all
										// capital unicode characters... is
										// statistics in capital??
				double percentage = ((charactersInWord[c.getChar()] * 100.00) / words
						.size());
				DecimalFormat formatter = new DecimalFormat("#.##");
				System.out.println(c.getChar() + "\t"
						+ numTimesInDictionary[c.getChar()] + "\t"
						+ formatter.format(percentage) + "%");
			}
		} catch (FileNotFoundException e) {
			System.out.println("File Not Found");
		}

	}

}

package example03;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class WordCounts {
	public static void main(String[] args) throws FileNotFoundException {
		Set<String> words = new HashSet<String>();
		long startTime = System.currentTimeMillis();
		String[] files = { "bible", "gettysburg", "hamlet", "tomsawyer" };
		for (String filename : files) {
			readFile(filename, words);
		}
		long endTime = System.currentTimeMillis();
		long elapsed = endTime - startTime;
		System.out.println("There are " + words.size() + " unique words.");
		System.out.println("Took " + elapsed + " ms.");
	}

	public static void readFile(String file, Set<String> words) throws FileNotFoundException {
		System.out.println("Starting to read " + file + " ...");
		Scanner input = new Scanner(new File(file + ".txt"));
		while (input.hasNext()) {
			String word = input.next();
			words.add(word);
		}
		System.out.println("Done reading " + file + ".");
	}
}
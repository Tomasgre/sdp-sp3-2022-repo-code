package example04;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/*
 * @author Marty Stepp
 *
 * This program reads many files in parallel and counts the total
 * number of unique words across all files.
 *
 * It is an example of concurrently accessing a shared resource,
 * in this case, a Set of words.
*/

public class WordCounts {
	public static void main(String[] args) throws FileNotFoundException, InterruptedException {
		Set<String> words = new HashSet<String>();
		long startTime = System.currentTimeMillis();
		String[] files = { "bible", "gettysburg", "hamlet", "tomsawyer" };
		Thread[] threads = new Thread[files.length];
		for (int i = 0; i < files.length; i++) {
			// readFile(file, words);
			threads[i] = new Thread(new FileReader(files[i], words));
			threads[i].start();
		}

		for (int i = 0; i < threads.length; i++) {
			threads[i].join();
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

			// must "synchronize" this block so that no more than one thread is trying
			// to modify the collection at a time
			synchronized (words) {
				words.add(word);
			}
		}
		System.out.println("Done reading " + file + ".");
	}
}

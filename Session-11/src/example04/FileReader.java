package example04;

// Marty Stepp
// This is a Runnable class that can read one file in a thread.

import java.io.FileNotFoundException;
import java.util.Set;

public class FileReader implements Runnable {
	private String file;
	private Set<String> words;

	public FileReader(String file, Set<String> words) {
		this.file = file;
		this.words = words;
	}

	public void run() {
		try {
			WordCounts.readFile(this.file, words);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}

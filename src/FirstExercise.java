//import acm.program.*;
import java.io.*;
//import java.util.Scanner;

public class FirstExercise {
	public static void main(String[] args) {
		int lines = 0;
		int words = 0;
		int chars = 0;
		BufferedReader rd = openFileReader("C:\\Users\\Luis\\eclipse-workspace\\Files_Arrays_ArrayList\\src\\lear.text");
		try {
			while (true) {
				String line = rd.readLine();
				if (line == null)
					break;
				lines++;
				words += countWords(line);
				chars += line.length();
			}
			rd.close();
		} catch (IOException ex) {
			System.out.println("An I/O exception has occurred");
		}
		System.out.println("Lines = " + lines);
		System.out.println("Words = " + words);
		System.out.println("Chars = " + chars);
	}

	private static BufferedReader openFileReader(String prompt) {
		//Scanner sn = new Scanner(System.in);
		//prompt = sn.next(prompt);
		BufferedReader rd = null;
		while (rd == null) {
			String name = prompt;
			try {
				rd = new BufferedReader(new FileReader(name));
			} catch (IOException ex) {
				System.out.println("Can't open that file.");
			}
		}
		return rd;
	}

	private static int countWords(String line) {
		boolean inWord = false;
		int words = 0;
		for (int i = 0; i < line.length(); i++) {
			char ch = line.charAt(i);
			if (Character.isLetterOrDigit(ch)) {
				inWord = true;
			} else {
				if (inWord)
					words++;
				inWord = false;
			}
		}
		if (inWord)
			words++;
		return words;
	}
}

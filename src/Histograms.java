import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Histograms {

	/* Private instance variables */
	private static int[] histogramArray;
	/* Name of the data file */
	private static final String DATA_FILE = "C:\\\\Users\\\\Luis\\\\eclipse-workspace\\\\Files_Arrays_ArrayList\\\\src\\\\MidtermScores.text";

	public static void main(String[] args) throws Exception {
		initHistogram();
		readScoresIntoHistogram();
		printHistogram();
	}

	/* Initializes the histogram array */
	private static void initHistogram() {
		histogramArray = new int[11];
		for (int i = 0; i <= 10; i++) {
			histogramArray[i] = 0;
		}
	}

	/* Reads the exam scores, updating the histogram */
	private static void readScoresIntoHistogram() throws Exception {
		try {
			BufferedReader rd = new BufferedReader(new FileReader(DATA_FILE));
			while (true) {
				String line = rd.readLine();
				if (line == null)
					break;
				int score = Integer.parseInt(line);
				if (score < 0 || score > 100) {
					throw new Exception("That score is out of range");
				} else {
					int range = score / 10;
					histogramArray[range]++;
				}
			}
		} catch (IOException ex) {
			throw new Exception(ex);
		}
	}

	/* Displays the histogram */
	private static void printHistogram() {
		for (int range = 0; range <= 10; range++) {
			String label;
			switch (range) {
			case 0:
				label = "00-09";
				break;
			case 10:
				label = " 100";
				break;
			default:
				label = (10 * range) + "-" + (10 * range + 9);
				break;
			}
			String stars = createStars(histogramArray[range]);
			System.out.println(label + ": " + stars);
		}
	}

	/* Creates a string consisting of n stars */
	private static String createStars(int n) {
		String stars = "";
		for (int i = 0; i < n; i++) {
			stars += "*";
		}
		return stars;
	}

}

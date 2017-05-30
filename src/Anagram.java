import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Anagram {
	private static BufferedReader br;
	private static Scanner sc;
	static boolean isRun = true;

	public static void main(String[] args) {
		while (isRun) {
			sc = new Scanner(System.in);
			String searchString = sc.next();
			if (searchString.equals("Q")) {
				isRun = false;
				break;
			}
			try {
				File file = new File("src/words.txt");
				FileReader fileReader = new FileReader(file);
				br = new BufferedReader(fileReader);
				
				String word = br.readLine();
				while (word != null) {
					if (word.length() <= 2) {
						word = br.readLine();
						continue;
					}
					StringBuilder builder = new StringBuilder(searchString);
					for (int i = 0; i < word.length(); i++) {
						Integer index = builder.indexOf(String.valueOf(word.charAt(i)));
						if (index == -1) {
							word = br.readLine();
							break;
						} else {
							builder.deleteCharAt(index);
							if (i == word.length() - 1) {
								System.out.println(word);
								word = br.readLine();
							}
						}
					}
				}
				
				System.out.println("finish");
				
			} catch (FileNotFoundException e) {
				System.out.println(e);
			} catch (IOException e) {
				System.out.println(e);
			}
		}
	}
}

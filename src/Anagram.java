import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.file.attribute.AclEntry.Builder;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Anagram {
	private static BufferedReader br;
	private static Scanner sc = new Scanner(System.in);;
	static String[] points1 = {"a","b","d","e","g","i","n","o","r","s","t","u"};
	static String[] points2 = {"c","f","h","l","m","p","v","w","y"};
	static String[] points3 = {"j","k","q","x","z"};
	
	static String answerStr = "";
	static Integer maxPoint = 0;
	static String word;
	
	public static void main(String[] args) {
		while (true) {
			String searchString = sc.next().toLowerCase();
			if (searchString.equals("Q")) {
				break;
			}
			try {
				File file = new File("src/words.txt");
				FileReader fileReader = new FileReader(file);
				br = new BufferedReader(fileReader);
				
				word = br.readLine().toLowerCase();
				while (word != null) {
					if (word.length() <= 2) {
						word = br.readLine();
						continue;
					}
					
					StringBuilder builder = new StringBuilder(searchString);
					Integer point = 1;
					for (int i = 0; i < word.length(); i++) {
//						if (word.equals("atrocity")) {
//							System.out.println(word);
//							System.out.println("length is");
//							System.out.println(word.length());
//						}
						String searchChar = String.valueOf(word.charAt(i));
						Integer index = builder.indexOf(searchChar);
						if (index == -1) {
//							word = br.readLine();
							break;
						} else {
							if (Arrays.asList(points1).contains(searchChar)) {
								point += 1;
							} else if (Arrays.asList(points2).contains(searchChar)) {
								point += 2;
							} else if (Arrays.asList(points3).contains(searchChar)) {
								point += 3;
							}
							builder.deleteCharAt(index);
							if (i == (word.length() - 1)) {
								point *= point;
								if (point > maxPoint) {
									answerStr = word;
									maxPoint = point;
								}
							}
						}
					}
					word = br.readLine();
				}
				
				System.out.println(answerStr);
				System.out.println(maxPoint);
				System.out.println("finish");
				searchString = "";
				
			} catch (FileNotFoundException e) {
				System.out.println(e);
			} catch (IOException e) {
				System.out.println(e);
			}
		}
	}
}

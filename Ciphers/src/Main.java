import java.util.Scanner;
import java.util.ArrayList;

public class Main {

	public static int letterToInt(char car) throws Exception {
		String letter = "" + car;
		if (letter.length() != 1) {
			throw new Exception("Incorrect Length Entered");
		}
		return letter.charAt(0) - 'a' + 1;
	}

	public static char intToLetter(int num) throws Exception {
		char car;
		if (num > 52 || num < 1) {
			throw new Exception("Number must be Between 1 and 52 recived - " + num);
		}
		if (num > 26) {
			num -= 26;
		}
		num--;
		num += 'a';
		car = (char) num;
		return car;
	}

	public static String stringScanner(Scanner input) {
		String rString = "";
		System.out.println();
		while (rString == "") {
			System.out.println("Enter Below:");
			rString = input.nextLine();
		}
		return rString;
	}

	public static void main(String[] args) throws Exception {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter a Sentence with at least one word with a Length of 5 letters or More");
		String sentence = stringScanner(in).toLowerCase();
		in.close();
		String key = "";
		int lastIndex = 0;
		while (sentence.indexOf(' ') != -1) {
			if (key.equals("")) {
				if (sentence.indexOf(' ') - lastIndex >= 5) {
					key = sentence.substring(lastIndex, sentence.indexOf(' '));
				} else {
					lastIndex = sentence.indexOf(' ');
				}
			}
			sentence = sentence.substring(0, sentence.indexOf(' ')) + sentence.substring(sentence.indexOf(' ') + 1);
		}
		if (key.equals("")) {
			System.out.println("No word with 5 Letters or More");
		} else {
			char[] keyList = key.toCharArray();
			char[] charsBefore = sentence.toCharArray();
			ArrayList<Character> charsAfter = new ArrayList<Character>();
			int j = 0;
			for (int i = 0; i < charsBefore.length; i++) {
				charsAfter.add(intToLetter(letterToInt((char)(charsBefore[i] - 'a' + 1)) + keyList[j]));
				j++;
				if (j == keyList.length) {
					j = 0;
				}
			}
			System.out.println("Keyword - " + key);
			for (int i = 0; i < charsAfter.size(); i++) {
				System.out.print(charsAfter.get(i) + " ");
			}
		}
	}
}

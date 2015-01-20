package misc;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class PasswordVerifier {
	private String string;

	public String getString() {
		return string;
	}

	public void setString(String string) {
		this.string = string;
	}

	public PasswordVerifier(String s) {
		setString(s);
	}

	public static void main(String[] args) {
		Scanner scanner;
		PasswordVerifier passwordChecker;
		List<String> output = new ArrayList<String>();
		scanner = new Scanner(System.in);

		while (scanner.hasNextLine()) {
			String s = scanner.nextLine();
			if (s.equals("end"))
				break;
			passwordChecker = new PasswordVerifier(s);
			if (passwordChecker.verifyPassword()) {
				output.add("<" + s + ">" + " is acceptable");
			} else {
				output.add("<" + s + ">" + " is not acceptable");
			}
		}

		Iterator<String> outputIter = output.iterator();
		while (outputIter.hasNext()) {
			System.out.println(outputIter.next());
		}

		scanner.close();

	}

	private boolean verifyPassword() {
		String s = getString();
		if (!s.trim().equals("") && s.length() > 0 && s.length() <= 20)
			if (hasVowel() && !hasConsecutiveVowelsOrConsonants() && !consOccurences())
				return true;
		return false;
	}

	private boolean isVowel(char c) {
		return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
	}

	private boolean hasVowel() {
		String s = getString();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (isVowel(c)) {
				return true;
			}
		}
		return false;
	}

	private boolean hasConsecutiveVowelsOrConsonants() {
		String s = getString();
		boolean isConsecutive = true;
		int consVowels = 0, consConsononts = 0;

		for (char c : s.toCharArray()) {
			if (isVowel(c)) {
				if (isConsecutive)
					consVowels++;
				else {
					consVowels = 1;
					isConsecutive = true;
				}
			} else {
				if (isConsecutive) {
					consConsononts = 1;
					isConsecutive = false;
				} else
					consConsononts++;
			}

			if (consConsononts == 3 || consVowels == 3)
				return true;
		}
		return false;
	}

	private boolean consOccurences() {
		String s = getString();
		if (s.length() < 2)
			return false;
		char first, second;
		for (int i = 0; i < s.length() - 1; i++) {
			first = s.charAt(i);
			second = s.charAt(i + 1);
			if (first == second && !allowedOccurence(first, second))
				return true;
		}
		return false;
	}

	private boolean allowedOccurence(char first, char second) {
		StringBuffer s = new StringBuffer();
		s.append(first);
		s.append(second);
		if (s.toString().equals("ee") || s.toString().equals("oo"))
			return true;
		return false;
	}

}

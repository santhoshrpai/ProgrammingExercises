package misc;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReverseWords {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String input = reader.readLine();

		if (!input.trim().isEmpty()) {
			long startTime = System.nanoTime();
			System.out.println(withRecursion(input));
			long endTime = System.nanoTime();
			System.out.println("Took " + (endTime - startTime) + " ns");
		}
	}

	public static String withLoop(String input) {
		StringBuilder reversed = new StringBuilder();
		String s[] = input.split("[ ]");
		for (int i = s.length - 1; i >= 0; i--) {
			if (!s[i].trim().isEmpty())
				reversed.append(s[i]);
			if (i != 0) {
				reversed.append(" ");
			}
		}
		return reversed.toString();
	}

	public static String withRecursion(String s) {
		int k = s.indexOf(" ");
		if (k == -1) {
			return s;
		} else {
			return withRecursion(s.substring(k + 1)) + " " + s.substring(0, k);
		}
	}

}

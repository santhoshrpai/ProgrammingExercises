package misc;
import java.util.HashSet;
import java.util.Set;

public class PermutationsOfAString {
	
	public static Set<String> perms = new HashSet<String>();
	
	public static void main(String[] args) {
		String s = "abb";
		permutations("",s);
		for(String each:perms) {
			System.out.println(each);
		}
	}

	public static void permutations(String c, String s) {
		if (s.length() == 0) {
			perms.add(c);
		} else {
			for (int i = 0; i < s.length(); i++) {
				permutations(s.charAt(i)+"", s.substring(0, i) + s.substring(i + 1));
			}
		}
	}
}
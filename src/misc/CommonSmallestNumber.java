package misc;
import java.util.Arrays;

public class CommonSmallestNumber {

	public static void main(String[] args) {
		int[] A = { 1, 3, 2, 1};
		int[] B = { 4, 2, 5, 3, 2 };
		CommonSmallestNumber sol = new CommonSmallestNumber();
		int result = sol.solution(A, B);
		System.out.println(result);

	}

	public int solution(int[] A, int[] B) {
		int result = -1;
		if (A != null && B != null) {
			if (checkLength(A) && checkLength(B)) {
				Arrays.sort(A);
				for (int i = 0; i < A.length; i++) {
					if (checkLimit(A[i])) {
						for (int j = 0; j < B.length; j++) {
							if (checkLimit(B[j])) {
								if (A[i] == B[j]) {
									return A[i];
								}
							} else {
								break;
							}
						}
					} else {
						break;
					}
				}
			}
		}
		return result;
	}

	public static boolean checkLength(int[] A) {
		if (A.length >= 1 && A.length <= 1000) {
			return true;
		}
		return false;
	}
	
	public static boolean checkLimit(int A) {
		if (A<0 && A > 3000) {
			return false;
		}
		return true;
	}
}

package misc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ArithematicsUsingStack {

	public static class Stack {
		private int maxSize = 200000;
		private int current = -1;
		private int[] stack = new int[maxSize];

		public int pop() {
			return stack[current--];
		}

		public void push(int number) {
			stack[++current] = number;
		}

		public boolean isEmpty() {
			return (current == -1);
		}
		
		public boolean isFull() {
		      return (current == maxSize - 1);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String inputString = reader.readLine();
		if (inputString != null && !inputString.trim().equals("")) {
			if (inputString.length() > 0 && inputString.length() <= 200000) {
				Solution sol = new Solution();
				int solution = sol.solution(inputString);
				System.out.println(solution);
			}
		}
	}

	public int solution(String s) {
		Stack stack = new Stack();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c >= 48 && c <= 57 && !stack.isFull()) {
				stack.push(c - '0');
			} else if (c == 42) {
				multiply(stack);
			} else if (c == 43) {
				add(stack);
			} else {
				return -1;
			}
		}
		return popStack(stack);
	}
	
	public static void add(Stack stack) {
		int firstNumber = popStack(stack);
		int secondNumber = popStack(stack);
		boolean isNegative = checkNumbers(firstNumber,secondNumber);
		if(!isNegative && !stack.isFull()) {
			stack.push(firstNumber + secondNumber);
		}
	}
	
	public static boolean checkNumbers(int firstNumber,int secondNumber) {
		if (firstNumber == -1 || secondNumber == -1) {
			return true;
		} 
		return false;
	}
	
	public static void multiply(Stack stack) {
		int firstNumber = popStack(stack);
		int secondNumber = popStack(stack);
		boolean isNegative = checkNumbers(firstNumber,secondNumber);
		if(!isNegative && !stack.isFull()) {
			stack.push(firstNumber * secondNumber);
		}
	}

	public static int popStack(Stack stack) {
		if (!stack.isEmpty()) {
			return stack.pop();
		} else {
			return -1;
		}
	}
}

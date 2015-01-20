package misc;
import java.lang.StringBuilder;
import java.util.Scanner;

public class ConvertIt {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter a positive integer from 0 to 10000.");
        int number = input.nextInt();

        System.out.println("Enter the base to convert to.");
        int base = input.nextInt();

        input.close();

        convertIt(number, base);

    }

    public static void convertIt(int number, int base) {

        if ( base <= 1 || base > 16)
            return;

        char[] array = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A',
                'B', 'C', 'D', 'E', 'F' };
        String convertedNum = "";

        do {
            convertedNum += array[number % base];
            number = number / base;
        } while (number != 0);

        convertedNum = new StringBuilder(convertedNum).reverse().toString();
        System.out.println(convertedNum);
    }
}
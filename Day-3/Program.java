import java.io.*;
import java.util.*;

class Program {

    public static void main(String[] args) throws FileNotFoundException {
        String data = new String("");

        File file = new File("Data.txt");
        Scanner sc = new Scanner(file);

        while (sc.hasNextLine()) {
            data += sc.nextLine();
        }
        System.out.println(data);

        sc.close();

        System.out.println("" + FindMul(data));
    }

    public static int FindMul(String input) {
        int x, y;
        int output = 0;
        String number;
        String temp;
        for (int i = 0; i < input.length(); i++) {
            int reverseIndex = 1;
            if (input.charAt(i) == ')') {
                System.out.println(input.charAt(i));
                if (Character.isDigit(input.charAt(i - reverseIndex))) {
                    number = "";
                    while (Character.isDigit(input.charAt(i - reverseIndex))) {
                        temp = ("" + input.charAt(i - reverseIndex));
                        number = insertStringInFront(number, temp);
                        reverseIndex++;
                    }
                    y = Integer.parseInt(number);
                    number = "";
                    if (input.charAt(i - reverseIndex) == ',') {
                        reverseIndex++;
                        if (Character.isDigit(input.charAt(i - reverseIndex))) {
                            while (
                                Character.isDigit(
                                    input.charAt(i - reverseIndex)
                                )
                            ) {
                                temp = ("" + input.charAt(i - reverseIndex));
                                number = insertStringInFront(number, temp);
                                reverseIndex++;
                            }
                            x = Integer.parseInt(number);
                            if (
                                input.charAt(i - reverseIndex) == '(' &&
                                input.charAt(i - reverseIndex - 1) == 'l' &&
                                input.charAt(i - reverseIndex - 2) == 'u' &&
                                input.charAt(i - reverseIndex - 3) == 'm'
                            ) {
                                output += (x * y);
                            }
                        }
                    }
                }
            }
        }
        return output;
    }

    public static String insertStringInFront(String input, String x) {
        return x.concat(input);
    }
}

import java.util.Scanner;

public class Main {
    public static boolean isValidBracketSequence(String str) {
        int roundBrackets = 0;
        int squareBrackets = 0;
        int curlyBrackets = 0;

        for (char c : str.toCharArray()) {
            if (c == '(') {
                roundBrackets++;
            } else if (c == '[') {
                squareBrackets++;
            } else if (c == '{') {
                curlyBrackets++;
            } else if (c == ')') {
                roundBrackets--;
            } else if (c == ']') {
                squareBrackets--;
            } else if (c == '}') {
                curlyBrackets--;
            }

            // Если количество закрывающих скобок становится больше, чем открывающих, возвращаем false
            if (roundBrackets < 0 || squareBrackets < 0 || curlyBrackets < 0) {
                return false;
            }
        }

        // Проверяем, что все переменные равны 0
        return roundBrackets == 0 && squareBrackets == 0 && curlyBrackets == 0;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print(">> Enter string to check it for bracket equilibrium:_");
        String userInput = scanner.nextLine();

        System.out.println("Is there a bracket equilibrium? - " + isValidBracketSequence(userInput));
    }
}

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    private static final Map<Character, Character> bracketMap = new HashMap<>();

    static {
        // Словарь соответствия скобок
        bracketMap.put('(', ')');
        bracketMap.put('[', ']');
        bracketMap.put('{', '}');
    }

    public static boolean isMatching(char open, char close) {
        // Проверяем соответствие скобок по заданному словарю
        return bracketMap.containsKey(open) && bracketMap.get(open) == close;
    }

    public static boolean isPalindrome(String str) {
        // Проверяем, является ли строка палиндромом
        int left = 0;
        int right = str.length() - 1;
        while (left < right) {
            char leftChar = str.charAt(left);
            char rightChar = str.charAt(right);

            // Если скобка -- ключ словаря, и она соответствует значению ключа:
            if (!isMatching(leftChar, rightChar)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print(">> Enter string to check it for palindrome:_");
        String userInput = scanner.nextLine();

        System.out.println("Is \"" + userInput + "\" a palindrome? " + isPalindrome(userInput));
    }
}

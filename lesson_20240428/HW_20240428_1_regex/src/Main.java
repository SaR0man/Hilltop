import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(">>> Enter your full name in English, year of birth, and date of birth (e.g., John Doe 1990 01.01.2000):_");
        String input = scanner.nextLine();

        boolean isValid = validateInput(input);
        if (isValid) {
            System.out.println("The entered data is valid.");
        } else {
            System.out.println("The entered data is NOT valid!");
        }
    }

    // Метод для проверки введённых данных с использованием регулярных выражений
    public static boolean validateInput(String input) {
        // Регулярное выражение для проверки введённых данных
        String regex = "^[A-Z][a-z]*\\s" +  // Имя с прописной буквы
                "[A-Z][a-z]*\\s" +  // Фамилия с прописной буквы
                "(19\\d{2}|20[01]\\d|202[0-4])\\s" +  // год между 1900 и 2024
                // Дата рождения:
                "(0[1-9]|[12]\\d|3[01])\\." +  // число между 1 и 31
                "(0[1-9]|1[0-2])\\." +  // месяц между 1 и 12
                "(19\\d{2}|20[01]\\d|202[0-4])$";  // год между 1900 и 2024
        // Создаем объект Pattern
        Pattern pattern = Pattern.compile(regex);
        // Создаем объект Matcher
        Matcher matcher = pattern.matcher(input);
        // Проверяем соответствие введённых данных регулярному выражению и возвращаем результат
        return matcher.matches();
    }
}

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        System.out.print("Enter your birthday:_ ");
        Scanner scanner = new Scanner(System.in);
        String birthday = scanner.next();

        Pattern pattern = Pattern.compile(birthday);
        Matcher matcher = pattern.matcher();


        System.out.println("Hello world!");
    }
}
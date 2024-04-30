/*
Программа создает контекст, в котором можно динамически заменять стратегию (такую как сложение или вычитание),
и вызывать соответствующий алгоритм для выполнения операции, возвращая результат.
 */

// Интерфейс стратегии
interface Strategy {
    int doOperation(int num1, int num2);
}

//// Классы математических операций: конкретные стратегии, реализующие интерфейс Strategy
// Реализация конкретной стратегии: сложение
class AddOperation implements Strategy {
    public int doOperation(int num1, int num2) {
        return num1 + num2;
    }
}

// Реализация конкретной стратегии: вычитание
class SubtractOperation implements Strategy {
    public int doOperation(int num1, int num2) {
        return num1 - num2;
    }
}

// Класс контекста, который использует стратегию
class Context {
    private Strategy strategy;  // ссылка на текущую стратегию

    public Context(Strategy strategy) {
        this.strategy = strategy;
    }

    public int executeStrategy(int num1, int num2) {
        return strategy.doOperation(num1, num2);
    }
}

public class StrategyPatternExample {
    public static void main(String[] args) {
        Context context = new Context(new AddOperation());
        System.out.println("10 + 5 = " + context.executeStrategy(10, 5));

        context = new Context(new SubtractOperation());
        System.out.println("10 - 5 = " + context.executeStrategy(10, 5));
    }
}

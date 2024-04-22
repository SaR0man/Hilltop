// Интерфейс для базового кофе
/*
определяет методы, которые возвращают стоимость и описание напитка соответственно
 */
interface Coffee {
    double getCost();
    String getDescription();
}

// Реализация базового кофе
/*
реализует интерфейс Coffee, представляя собой базовый чёрный кофе с начальной ценой $1.0 и описанием "Black coffee".
 */
class SimpleCoffee implements Coffee {
    @Override
    public double getCost() {
        return 1.0;
    }

    @Override
    public String getDescription() {
        return "Black coffee";
    }
}

// Абстрактный декоратор
/*
Расширяет функциональность базового кофе.
Содержит ссылку на декорируемый объект decoratedCoffee и передаёт вызовы методов getCost() и getDescription() этому объекту
 */
abstract class CoffeeDecorator implements Coffee {
    protected Coffee decoratedCoffee;

    public CoffeeDecorator(Coffee decoratedCoffee) {
        this.decoratedCoffee = decoratedCoffee;
    }

    public double getCost() {
        return decoratedCoffee.getCost();
    }

    public String getDescription() {
        return decoratedCoffee.getDescription();
    }
}

// Конкретные декораторы
/*
добавляют функциональность молока и шоколада к кофе соответственно
 */
class Milk extends CoffeeDecorator {
    public Milk(Coffee decoratedCoffee) {
        super(decoratedCoffee);
    }

    public double getCost() {
        return super.getCost() + 0.5;
    }

    public String getDescription() {
        return super.getDescription() + ", Milk";
    }
}

class Chocolate extends CoffeeDecorator {
    public Chocolate(Coffee decoratedCoffee) {
        super(decoratedCoffee);
    }

    public double getCost() {
        return super.getCost() + 0.2;
    }

    public String getDescription() {
        return super.getDescription() + ", Chocolate";
    }
}

public class Main {
    public static void main(String[] args) {
        Coffee coffee = new SimpleCoffee();
        System.out.println("Description: " + coffee.getDescription() + ", Price: $" + coffee.getCost());

        // Добавляем молоко
        coffee = new Milk(coffee);
        System.out.println("Description: " + coffee.getDescription() + ", Price: $" + coffee.getCost());

        // Добавляем шоколад
        coffee = new Chocolate(coffee);
        System.out.println("Description: " + coffee.getDescription() + ", Price: $" + coffee.getCost());
    }
}
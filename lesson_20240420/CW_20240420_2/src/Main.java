interface CurrencyConverter{
    double convert(double amount);
}

class EuroToDollarConverter implements CurrencyConverter{
    @Override
    public double convert(double euros) {
        return euros * 1.2;
    }
}

class DollarToRoubleAdapter implements CurrencyConverter{
    CurrencyConverter euroToDollarConverter;

    //// конструктор
    public DollarToRoubleAdapter(CurrencyConverter euroToDollarConverter) {
        this.euroToDollarConverter = euroToDollarConverter;
    }

    @Override
    public double convert(double euro) {
        double dollar = euroToDollarConverter.convert(euro);
        return dollar * 92;
    }
}

public class Main {
    public static void main(String[] args) {
        CurrencyConverter euroTuDollar = new EuroToDollarConverter();
        CurrencyConverter euroToDollarToRoubleAdapter = new DollarToRoubleAdapter(euroTuDollar);

        double pocket = 2000;  // имеется в кармане денег
        double laptop = 160_000;  // стоимость ноутбука в рублях

        pocket = euroToDollarToRoubleAdapter.convert(pocket);

        if (pocket - laptop >= 0) {
            System.out.println("You bought a laptop for " + laptop + " rubles. You have " + (pocket - laptop) + " rubles left.");
        } else {
            System.out.println("You don't have enough money.");
        }

        //// Задачка на собесе

//        String text = "";
//
//        for (int i = 0; i <= 10; i++) {
//            text += i;
//        }
//
//        System.out.println(text);

        // ******

        String text = "";
        StringBuilder textBuilder = new StringBuilder(100);

        for (int i = 0; i <= 10; i++) {
            text += i;

            textBuilder.append(i);
        }

        System.out.println(textBuilder);

    }
}
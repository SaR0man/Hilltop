import java.util.ArrayList;
import java.util.List;

class Pizza {
    private String dough = "";
    private String souse = "";
    private String topping = "";

    @Override
    public String toString() {
        return "Picca s testom : " + dough + " , souse : " + souse + " , dobavka : " + topping;
    }

    public String getDough() {
        return dough;
    }

    public void setDough(String dough) {
        this.dough = dough;
    }

    public String getSouse() {
        return souse;
    }

    public void setSouse(String souse) {
        this.souse = souse;
    }

    public String getTopping() {
        return topping;
    }

    public void setTopping(String topping) {
        this.topping = topping;
    }
}

interface PizzaBuilder {
    void buildDough();

    void buildSauce();

    void buildTopping();

    Pizza getPizza();
}

class HawaianPizzaBuilder implements PizzaBuilder {

    private Pizza pizza = new Pizza();


    @Override
    public void buildDough() {
        pizza.setDough("Tonkoe");
    }

    @Override
    public void buildSauce() {
        pizza.setSouse("Tomatniy");
    }

    @Override
    public void buildTopping() {
        pizza.setTopping(" vkus ananasa i vetcini ");
    }

    @Override
    public Pizza getPizza() {
        return pizza;
    }
}

class MargheritaPizzaBuilder implements PizzaBuilder {

    private Pizza pizza = new Pizza();


    @Override
    public void buildDough() {
        pizza.setDough("Sredneye");
    }

    @Override
    public void buildSauce() {
        pizza.setSouse(" Bez sousa");
    }

    @Override
    public void buildTopping() {
        pizza.setTopping(" sir i kolbasa ");
    }

    @Override
    public Pizza getPizza() {
        return pizza;
    }
}

class Waiter {
    private List<PizzaBuilder> pizzaBuilders;
    public void setPizzaBuilder(List<PizzaBuilder> pizzaBuilder) {
        this.pizzaBuilders = pizzaBuilder;
    }
    public List<Pizza> getPizzas() {
       return  getPizzasDifferent();
    }

    public Waiter() {
        this.pizzaBuilders = pizzaBuilders;
    }

    public List<Pizza> getPizzasDifferent() {
        List<Pizza> pizzas = new ArrayList<>();
        for (int i = 0; i < pizzaBuilders.size(); i++) {
            pizzaBuilders.get(i).buildDough();
            pizzaBuilders.get(i).buildTopping();
            pizzaBuilders.get(i).buildSauce();
            pizzas.add(pizzaBuilders.get(i).getPizza());
        }
        return pizzas;
    }
}

public class Main {
    public static void main(String[] args) {
        Waiter waiter = new Waiter();

        PizzaBuilder pizzaBuilder = new HawaianPizzaBuilder();
        PizzaBuilder pizzaBuilder2 = new HawaianPizzaBuilder();
        PizzaBuilder pizzaBuilder3 = new MargheritaPizzaBuilder();
        PizzaBuilder pizzaBuilder4 = new HawaianPizzaBuilder();
        PizzaBuilder pizzaBuilder5 = new MargheritaPizzaBuilder();

        List<PizzaBuilder> list = new ArrayList<>();
        list.addAll(List.of(pizzaBuilder,pizzaBuilder2,pizzaBuilder3,pizzaBuilder4,pizzaBuilder5));

        waiter.setPizzaBuilder(list);

        List<Pizza> pizzas = waiter.getPizzas();

        for (int i = 0; i < pizzas.size(); i++) {
            System.out.println(pizzas.get(i));
        }
    }
}
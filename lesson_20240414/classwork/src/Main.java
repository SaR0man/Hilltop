class Pizza {
    private String dough = "";
    private String sauce = "";
    private String ingredient = "";

    public String getDough() {
        return dough;
    }

    public void setDough(String dough) {
        this.dough = dough;
    }

    public String getSauce() {
        return sauce;
    }

    public void setSauce(String sauce) {
        this.sauce = sauce;
    }

    public String getIngredient() {
        return ingredient;
    }

    public void setIngredient(String ingredient) {
        this.ingredient = ingredient;
    }

    @Override
    public String toString() {
        return "Пицца с тестом: " + dough + ", соус: " + sauce + " и начинкой: " + ingredient;
    }
}

interface PizzaBuilder {
    void buildDough();
    void buildSauce();
    void buildIngredient();
    Pizza getPizza();
}

//// класс для создания конкретной пиццы -- гавайской:
class HawaiianPizzaBuilder implements PizzaBuilder {

    private Pizza pizza = new Pizza();

    @Override
    public void buildDough() {
        pizza.setDough("Тонкое");
    }

    @Override
    public void buildSauce() {
        pizza.setSauce("Томатный");
    }

    @Override
    public void buildIngredient() {
        pizza.setIngredient("Ветчина");
    }

    @Override
    public Pizza getPizza() {
        return pizza;
    }
}

//// Класс "Директор"
class Director {
    private PizzaBuilder pizzaBuilder;

    public void setPizzaBuilder(PizzaBuilder pizzaBuilder) {
        this.pizzaBuilder = pizzaBuilder;
    }

    public Pizza getPizza() {
        createPizza();
        return pizzaBuilder.getPizza();
    }

    private void createPizza() {
        pizzaBuilder.buildDough();
        pizzaBuilder.buildSauce();
        pizzaBuilder.buildIngredient();
    }
}

public class Main {
    public static void main(String[] args) {
        Director director = new Director();
        PizzaBuilder pizzaBuilder = new HawaiianPizzaBuilder();
        director.setPizzaBuilder(pizzaBuilder);
        Pizza pizza = director.getPizza();
        System.out.println(pizza);
    }
}
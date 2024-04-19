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

    @Override
    public void buildDough() {

    }

    @Override
    public void buildSauce() {

    }

    @Override
    public void buildIngredient() {

    }

    @Override
    public Pizza getPizza() {
        return null;
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println("Проверяем кириллицу в консоли");
        System.out.println("Еще проверка"); // такой комментарий
    }
}
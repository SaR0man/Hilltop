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
        return "����� � ������: " + dough + ", ����: " + sauce + " � ��������: " + ingredient;
    }
}

interface PizzaBuilder {
    void buildDough();
    void buildSauce();
    void buildIngredient();
    Pizza getPizza();
}

//// ����� ��� �������� ���������� ����� -- ���������:
class HawaiianPizzaBuilder implements PizzaBuilder {

    private Pizza pizza = new Pizza();

    @Override
    public void buildDough() {
        pizza.setDough("������");
    }

    @Override
    public void buildSauce() {
        pizza.setSauce("��������");
    }

    @Override
    public void buildIngredient() {
        pizza.setIngredient("�������");
    }

    @Override
    public Pizza getPizza() {
        return pizza;
    }
}

//// ����� ��� �������� ���������� ����� -- ���������:
class MargheritaPizzaBuilder implements PizzaBuilder {

    private Pizza pizza = new Pizza();

    @Override
    public void buildDough() {
        pizza.setDough("�������");
    }

    @Override
    public void buildSauce() {
        pizza.setSauce("������");
    }

    @Override
    public void buildIngredient() {
        pizza.setIngredient("������");
    }

    @Override
    public Pizza getPizza() {
        return pizza;
    }
}

//// ����� "��������"
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

        PizzaBuilder pizzaBuilder = new HawaiianPizzaBuilder();  // ������ ��������� �����
//        PizzaBuilder pizzaBuilder = new MargheritaPizzaBuilder();  // ������ ����� ���������

        director.setPizzaBuilder(pizzaBuilder);

        Pizza pizza = director.getPizza();

        System.out.println(pizza);
    }
}
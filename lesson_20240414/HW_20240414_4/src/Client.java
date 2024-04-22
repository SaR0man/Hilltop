// Класс, представляющий фасад
class Facade {
    private Subsystem1 subsystem1;
    private Subsystem2 subsystem2;
    private Subsystem3 subsystem3;

    public Facade() {
        this.subsystem1 = new Subsystem1();
        this.subsystem2 = new Subsystem2();
        this.subsystem3 = new Subsystem3();
    }

    public void operation() {
        subsystem1.operation1();
        subsystem2.operation2();
        subsystem3.operation3();
    }
}

// Подсистема 1
class Subsystem1 {
    public void operation1() {
        System.out.println("Subsystem1 operation");
    }
}

// Подсистема 2
class Subsystem2 {
    public void operation2() {
        System.out.println("Subsystem2 operation");
    }
}

// Подсистема 3
class Subsystem3 {
    public void operation3() {
        System.out.println("Subsystem3 operation");
    }
}


public class Client {
    public static void main(String[] args) {
        Facade facade = new Facade();
        facade.operation(); // Клиентский код взаимодействует с фасадом, не зная о деталях реализации подсистем
    }
}

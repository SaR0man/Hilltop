/*
Программа позволяет объекту изменять свое поведение в зависимости от своего текущего состояния.
 */

// Интерфейс состояния
interface State {
    void doAction(Context context);  // действие, которое должен выполнить контекст в текущем состоянии
}

//// Классы ConcreteStateA и ConcreteStateB являются конкретными реализациями интерфейса State.
// Реализация конкретного состояния
class ConcreteStateA implements State {
    public void doAction(Context context) {
        System.out.println("State A is active.");
        context.setState(new ConcreteStateB());
    }
}

// Реализация конкретного состояния
class ConcreteStateB implements State {
    public void doAction(Context context) {
        System.out.println("State B is active.");
        context.setState(new ConcreteStateA());
    }
}

// Контекст, управляющий состояниями
/*
содержит ссылку на текущее состояние объекта и обеспечивает интерфейс для взаимодействия с этим состоянием.
 */
class Context {
    private State state;

    public Context() {
        state = new ConcreteStateA();
    }

    public void setState(State state) {
        this.state = state;
    }

    public void request() {
        state.doAction(this);
    }
}

public class StatePatternExample {
    public static void main(String[] args) {
        Context context = new Context();

        // Последовательно меняем состояния и вызываем действия
        context.request(); // State A is active.
        context.request(); // State B is active.
        context.request(); // State A is active.
    }
}

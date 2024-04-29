import java.util.ArrayList;
import java.util.List;

// Посредник, который координирует отправку сообщений между пользователями
interface ChatMediator {
    void sendMessage(String message, User user);
}

// Конкретный посредник
class ChatMediatorImpl implements ChatMediator {
    private List<User> users;

    public ChatMediatorImpl(List<User> users) {
        this.users = users;
    }

    @Override
    public void sendMessage(String message, User user) {
        for (User u : this.users) {
            // Посредник отправляет сообщение всем пользователям, кроме отправителя
            if (u != user) {
                u.receiveMessage(message);
            }
        }
    }
}

// Пользователь чата
class User {
    private String name;
    ChatMediator mediator;  // хранит ссылку на посредника чата, через который пользователь будет отправлять сообщения

    public User(String name, ChatMediator mediator) {
        this.name = name;
        this.mediator = mediator;
        /*
        При создании пользователя он привязывается к определенному посреднику, чтобы взаимодействовать с другими пользователями через него
         */
    }

    // посредник получает сообщение от пользователя и координирует его доставку остальным пользователям:
    public void sendMessage(String message) {
        System.out.println("\n>>> " + name + " sent a message: " + message);
        mediator.sendMessage(message, this);
    }

    // сообщение о получении сообщения:
    public void receiveMessage(String message) {
        System.out.println(name + " received the message: " + message);
    }
}

public class MediatorPatternExample {
    public static void main(String[] args) {

        //// Создание списка пользователей:
        List<User> users = new ArrayList<>();
        users.add(new User("User 1", null));
        users.add(new User("User 2", null));
        users.add(new User("User 3", null));

        //// Создание посредника:
        ChatMediator mediator = new ChatMediatorImpl(users);

        //// Привязка каждого пользователя к посреднику:
        for (User user : users) {
            user.mediator = mediator;
        }

        //// Отправка сообщений:
        // создаются объекты пользователей user1, user2 и user3, которые уже связаны с посредником
        User user1 = users.get(0);
        User user2 = users.get(1);
        User user3 = users.get(2);

        // собственно, отправка сообщений
        user1.sendMessage("Hi! Is there anyone here?");
        user2.sendMessage("Yes I'm here!");
        user3.sendMessage("And I'm here too.");
    }
}

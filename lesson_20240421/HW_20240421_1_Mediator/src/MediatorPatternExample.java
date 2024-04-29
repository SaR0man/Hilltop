/*
Имитация чата, где у нас есть пользователи, которые могут отправлять сообщения друг другу.
В этом случае, ПОСРЕДНИК будет отвечать за передачу сообщений между пользователями.
 */

import java.util.ArrayList;
import java.util.List;

// Посредник, который координирует отправку сообщений между пользователями
interface ChatMediator {
    void sendMessage(String message, User user);
    void addUser(User user);
}

// Конкретный посредник
class ChatMediatorImpl implements ChatMediator {
    private List<User> users;

    public ChatMediatorImpl() {
        this.users = new ArrayList<>();
    }

    public void addUser(User user) {
        this.users.add(user);
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
    private ChatMediator mediator;

    public User(String name, ChatMediator mediator) {
        this.name = name;
        this.mediator = mediator;
    }

    public void sendMessage(String message) {
        System.out.println("\n>>> " + name + " sent a message: " + message);
        mediator.sendMessage(message, this);
    }

    public void receiveMessage(String message) {
        System.out.println(name + " received the message: " + message);
    }
}

public class MediatorPatternExample {
    public static void main(String[] args) {
        ChatMediator mediator = new ChatMediatorImpl();

        User user1 = new User("User 1", mediator);
        User user2 = new User("User 2", mediator);
        User user3 = new User("User 3", mediator);

        mediator.addUser(user1);
        mediator.addUser(user2);
        mediator.addUser(user3);

        user1.sendMessage("Hi! Is there anyone here?");
        user2.sendMessage("Yes I'm here!");
        user3.sendMessage("And I'm here too.");
    }
}

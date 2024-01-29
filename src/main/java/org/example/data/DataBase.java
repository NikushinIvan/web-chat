package org.example.data;

import java.util.List;

import static org.example.data.UserType.ADMIN;
import static org.example.data.UserType.CLIENT;

public final class DataBase {

    private static final List<User> USERS = List.of(
            new User("user1", "pass1", "Ivan", ADMIN),
            new User("user2", "pass2", "Olga", CLIENT),
            new User("user3", "pass3", "Denis", CLIENT)
    );

    private DataBase() {
    }

    public static void init() {
        System.out.println("Установка соединения с Базой Данных");
    }

    public static User getUser(String login, String password) {
        for (User user : USERS) {
            if (user.getLogin().equals(login) && user.getPassword().equals(password)) {
                return user;
            }
        }
        return null;
    }

    public static void close() {
        System.out.println("Закрытие соединения с Базой Данных");
    }
}

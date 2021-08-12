package ru.job4j.max;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Home {

    public static class User {

        private String login;

        public User(String login) {
            this.login = login;
        }

        public String getLogin() {
            return login;
        }
    }

    public static class UserNotFoundException extends RuntimeException { }

    public static User orElseThrow(List<User> list, String login) {
        for (User u :list) {
            if (u.login.equals(login)) {
                return u;
            }

            }
        return null;
    }

    private static Optional<User> search(List<User> list, String login) {
        User user = orElseThrow(list, login);
        return Optional.of(user);
    }
}


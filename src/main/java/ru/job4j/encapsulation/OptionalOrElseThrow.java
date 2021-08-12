package ru.job4j.encapsulation;

import java.util.List;
import java.util.Optional;

public class OptionalOrElseThrow {

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
        User user = null;
        for (User u :list) {
            if (u.getLogin().equals(login)) {
                user = u;
            }
        }
        if (user == null) {
            throw new UserNotFoundException();
        }
        return user;
    }

    private static Optional<User> search(List<User> list, String login) {
        return Optional.ofNullable(orElseThrow(list, login));
    }
}

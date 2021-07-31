package ru.job4j.ex;

public class UserStore {

    public static User findUser(User[] users, String login) throws UserNotFoundException {
        User user = null;
        for (int i = 0; i < users.length; i++) {
            if (users[i].getUsername().equals(login)) {
                user = users[i];
            }
        }
        if (user == null) {
            throw new UserNotFoundException("Пользователь не найден.");
        }
        return user;
    }

    public static boolean validate(User user) throws UserInvalidException {
        boolean valid = false;
        if (user.getUsername().length() > 3 || user.isValid()) {
            valid = true;
        }
        if (!valid) {
            throw  new UserInvalidException("Пользователь не валидный.");
        }
        return false;
    }

    public static void main(String[] args) {
        User[] users = {
                new User("Petr Arsentev", true)
        };
        try {
            User user = findUser(users, "Petr Arsentev");
            if (validate(user)) {
                System.out.println("This user has an access");
            }
        } catch (UserInvalidException ei) {
            ei.printStackTrace();
        } catch (UserNotFoundException e) {
            e.printStackTrace();
        }
    }
}

package ru.job4j.ex;

public class UserStore {
    public static User findUser(User[] users, String login) throws UserNotFoundException {
        User result = null;
        for (User user : users) {
            if (user.getUsername().equals(login)) {
                result = user;
                break;
            }
        }
        if (result == null) {
            throw new UserNotFoundException("User \"" + login + "\" is not found.");
        }
        return result;
    }

    public static boolean validate(User user) throws UserInvalidException {
        if (!user.isValid() || user.getUsername().length() < 3) {
            throw new UserInvalidException("User \"" + user.getUsername() + "\" is not valid user.");
        }
        return true;
    }

    public static void main(String[] args) {
        User[] users = {
                new User("Alexander Blok", true),
                new User("Anna Akhmatova", true),
                new User("Ivan Krylov", false)
        };
        String login = "Anna Akhmatova";
        try {
            User user = findUser(users, login);
            if (validate(user)) {
                System.out.println("User \"" + user.getUsername() + "\" has an access");
            }
        } catch (UserInvalidException unv) {
            unv.printStackTrace();
        } catch (UserNotFoundException unf) {
            unf.printStackTrace();
        }
    }
}

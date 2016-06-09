package org.endeavour.example.services;

import org.endeavour.example.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserService {

    private static UserService instance;

    public static UserService getInstance() {
        if(instance == null) {
            instance = new UserService();
        }
        return instance;
    }

    private List<User> users;

    public UserService() {
        users = new ArrayList<User>();
        users.add(new User("alice@example.com", "Alice"));
        users.add(new User("bob@example.com", "Bob the Builder"));
    }

    public List<User> list() {
        return users;
    }

    public User get(int index) {
        return users.get(index);
    }

    public User add(User user) {
        users.add(user);
        return user;
    }

    public User set(int index, User user) {
        User toRemove = users.get(index);
        users.add(index, user);
        users.remove(toRemove);
        return users.get(index);
    }

    public void delete(int index) {
        users.remove(index);
    }
}

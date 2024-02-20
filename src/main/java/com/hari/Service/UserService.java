package com.hari.Service;

import org.springframework.stereotype.Service;

import com.hari.Model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class UserService {
    private List<User> users = new ArrayList<>();

    public UserService() {
        // users.add(new
        // User(UUID.randomUUID().toString(),"Hari","Harimungase@gmail.com","1234"));
        users.add(new User(UUID.randomUUID().toString(), "Hari", "Harimung@gmail.com"));
        users.add(new User(UUID.randomUUID().toString(), "Hari mungase", "Harimung0412@gmail.com"));
        users.add(new User(UUID.randomUUID().toString(), "mungase", "Harimung1234@gmail.com"));
        users.add(new User(UUID.randomUUID().toString(), "Hariprasad", "Hari1234@gmail.com"));

    }

    public List<User> getUsers() {
        return this.users;
    }
}

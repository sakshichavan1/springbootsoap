package com.example.service;




import org.springframework.stereotype.Service;

import com.example.soap_spring_boot.User;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Service
public class UserService {

    private static final Map<String, User> users = new HashMap<>();

    @PostConstruct
    public void initialize() {

        User sakshi = new User();
        sakshi.setName("Sakshi");
        sakshi.setEmpId(1111);
        sakshi.setSalary(15000);

        User sam = new User();
        sam.setName("Sam");
        sam.setEmpId(1112);
        sam.setSalary(32000);
        User ryan = new User();
        ryan.setName("Ryan");
        ryan.setEmpId(1113);
        ryan.setSalary(16000);

        users.put(sakshi.getName(), sakshi);
        users.put(sam.getName(), sam);
        users.put(ryan.getName(), ryan);
    }


    public User getUsers(String name) {
        return users.get(name);
    }
}

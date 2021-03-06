package com.swabber.api.service;

import com.google.common.collect.Lists;
import com.swabber.api.model.User;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
public class UserService {

    private List<User> userList;

    @PostConstruct
    public void setUp() {
        userList = Lists.newArrayList();
        userList.add(new User(1, "Chie", "Software engineer", "hehehehe"));
        userList.add(new User(2, "Gimyong", "Hair designer", "hehe"));
    }

    public List<User> getAllUserList() {
        return userList;
    }
}

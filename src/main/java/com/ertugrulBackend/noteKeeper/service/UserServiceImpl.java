package com.ertugrulBackend.noteKeeper.service;

import com.ertugrulBackend.noteKeeper.model.User;
import com.ertugrulBackend.noteKeeper.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

}

package com.ertugrulBackend.noteKeeper.service;

import com.ertugrulBackend.noteKeeper.model.User;
import org.springframework.stereotype.Service;

import java.util.List;


public interface UserService {

    List<User> getAllUsers();

    void saveUser(User user);

    User getUserById(long id);

    void deleteUserById(long id);

}

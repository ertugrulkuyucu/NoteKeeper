package com.ertugrulBackend.noteKeeper.service;

import com.ertugrulBackend.noteKeeper.model.User;
import com.ertugrulBackend.noteKeeper.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    /*
    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
     */

    @Cacheable(cacheNames = "users")
    @Override
    public List<User> getAllUsers() throws InterruptedException {
        Thread.sleep(3000);
        return userRepository.findAll();
    }

    @CacheEvict(cacheNames = "users", allEntries = true)
    public void clearCache() {
        System.out.println("Cache cleared");
    }



    @Override
    public void saveUser(User user) {
        this.userRepository.save(user);
    }

    @Override
    public User getUserById(long id) {
        Optional<User> optional = userRepository.findById(id);
        User user;
        if (optional.isPresent()) {
            user = optional.get();
        } else {
            throw new RuntimeException(" User not found for id :: " + id);
        }
        return user;
    }

    @Override
    public void deleteUserById(long id) {
        this.userRepository.deleteById(id);
    }

}

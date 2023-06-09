package com.beatdev.core.repo;

import com.beatdev.core.model.User;

import java.util.Optional;

public interface UserRepo {
    Optional<User> findUserById(long id);
    User createUser(User user);
    User updateUser(User user);
}

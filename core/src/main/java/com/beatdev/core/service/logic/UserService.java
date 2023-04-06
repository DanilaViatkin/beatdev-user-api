package com.beatdev.core.service.logic;

import com.beatdev.core.model.User;
import org.springframework.stereotype.Service;

public interface UserService {
    User findUserById(long id);
    long createUser(User user);
    User updateUserStatus(long id, String status);
}

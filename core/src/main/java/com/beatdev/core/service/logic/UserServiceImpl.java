package com.beatdev.core.service.logic;

import com.beatdev.core.model.Status;
import com.beatdev.core.service.exception.NotFoundEntityException;
import com.beatdev.core.model.User;
import com.beatdev.core.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
    private final UserRepo userRepo;

    @Autowired
    public UserServiceImpl(UserRepo userRepo){
        this.userRepo = userRepo;
    }
    @Override
    public User findUserById(long id) {
        return userRepo.findUserById(id).orElseThrow(() -> new NotFoundEntityException("user.not.found", id));
    }

    @Override
    public long createUser(User user) {
        validateUser(user);
        return userRepo.createUser(user);
    }

    private void validateUser(User user){

    }

    @Override
    public User updateUserStatus(long id, String status) {
        User user = userRepo.findUserById(id).
                orElseThrow(() -> new NotFoundEntityException("user.not.found", id));
        user.setStatus(Status.valueOf(status));
        return userRepo.updateUser(user);
    }
}

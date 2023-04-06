package com.beatdev.core.service.logic;

import com.beatdev.core.model.Status;
import com.beatdev.core.service.exception.InvalidStatusException;
import com.beatdev.core.service.exception.InvalidUserException;
import com.beatdev.core.service.exception.NotFoundEntityException;
import com.beatdev.core.model.User;
import com.beatdev.core.repo.UserRepo;
import com.beatdev.core.service.validator.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
    private final UserRepo userRepo;
    private final Validator<User> userValidator;

    @Autowired
    public UserServiceImpl(UserRepo userRepo,
                           Validator<User> userValidator){
        this.userRepo = userRepo;
        this.userValidator = userValidator;
    }
    @Override
    public User findUserById(long id) {
        return userRepo.findUserById(id).orElseThrow(() -> new NotFoundEntityException("user.not.found", id));
    }

    @Override
    public long createUser(User user) {
        validateUser(user);
        System.out.println(user.getPassword());
        user.setStatus(Status.ONLINE);
        return userRepo.createUser(user).getId();
    }

    private void validateUser(User user){
        if (!userValidator.isValid(user)){
            throw new InvalidUserException("user.invalid.data");
        }
    }

    @Override
    public User updateUserStatus(long id, String status) {
        User user = userRepo.findUserById(id).
                orElseThrow(() -> new NotFoundEntityException("user.not.found", id));
        validateStatus(status);
        user.setStatus(Status.valueOf(status.toUpperCase()));
        return userRepo.updateUser(user);
    }

    private void validateStatus(String status){
        if (!(status.equalsIgnoreCase(Status.ONLINE.toString()) ||
                status.equalsIgnoreCase(Status.OFFLINE.toString()))){
            throw new InvalidStatusException("status.invalid.data");
        }
    }
}

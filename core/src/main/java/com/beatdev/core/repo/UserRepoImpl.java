package com.beatdev.core.repo;

import com.beatdev.core.model.User;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Repository
public class UserRepoImpl implements UserRepo{

    private Map<Long, User> users = new HashMap<>();
    @Override
    public Optional<User> findUserById(long id) {
        if (users.size() <= id){
            return Optional.of(users.get(id));
        } else {
            return Optional.empty();
        }
    }

    @Override
    public long createUser(User user) {
        long currentAmountOfUsers = users.size();
        users.put(Long.valueOf(currentAmountOfUsers + 1), user);
        return currentAmountOfUsers + 1;
    }

    @Override
    public User updateUser(User user) {
        users.put(user.getId(), user);
        return users.get(user.getId());
    }
}

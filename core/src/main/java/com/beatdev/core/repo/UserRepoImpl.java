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
        if (users.size() >= id){
            return Optional.of(users.get(id));
        } else {
            return Optional.empty();
        }
    }

    @Override
    public User createUser(User user) {
        long id = users.size() + 1;
        user.setId(id);
        users.put(Long.valueOf(id), user);
        return users.get(id);
    }

    @Override
    public User updateUser(User user) {
        users.put(user.getId(), user);
        return users.get(user.getId());
    }
//    @PersistenceContext
//    protected final EntityManager entityManager;
//    @Autowired
//    public UserRepoImpl(EntityManager entityManager){
//        this.entityManager = entityManager;
//    }
//
//    //TODO написать методы которые будут обращаться к базе данных, используя hibernate и закомментировать их
//    @Override
//    public Optional<User> findUserById(long id){
//        CriteriaQuery<User> entityQuery = criteriaBuilder.createQuery(User.class);
//        Root<User> entity = entityQuery.from(User.class);
//        Predicate fieldPredicate = criteriaBuilder.equal(entity.get("id"), id);
//        entityQuery.where(fieldPredicate);
//        entityQuery.select(entity);
//        TypedQuery<User> query = entityManager.createQuery(entityQuery);
//        if (query.getResultList().size() == 0){
//            return Optional.empty();
//        }
//        return Optional.of(query.getSingleResult());
//    }
//
//    @Override
//    public User createUser(User user){
//        entityManager.persist(user);
//        return user;
//    }
//
//    @Override
//    public User updateUser(User user){
//        return entityManager.merge(user);
//    }
}

package com.redis.Sample.repositories;

import com.redis.Sample.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepositories extends CrudRepository<User,String> {
}

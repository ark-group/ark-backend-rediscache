package com.ark.arkbackendrediscache.repository;

import com.ark.arkbackendrediscache.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface UserRepository  {

    void save(User user);

    Map<String,User> findAll();

    User findById(String id);

    void update(User user);

    void delete(String id);
}

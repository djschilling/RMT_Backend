package com.ratemytree.rmt.user;

import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * David Schilling - davejs92@gmail.com
 */
public interface UserRepository extends MongoRepository<User, String> {

    User findByUsername(String username);
}

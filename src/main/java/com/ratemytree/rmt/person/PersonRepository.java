package com.ratemytree.rmt.person;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * David Schilling - davejs92@gmail.com
 */
public interface PersonRepository extends MongoRepository<Person, String> {
}
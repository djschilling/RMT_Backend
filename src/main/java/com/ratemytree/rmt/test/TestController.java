package com.ratemytree.rmt.test;

import com.ratemytree.rmt.person.Person;
import com.ratemytree.rmt.person.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * David Schilling - davejs92@gmail.com
 */
@Controller
@RequestMapping(value = "/test")
public class TestController {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Autowired
    private PersonRepository personRepository;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<String> test() {
        Person asd = new Person("asd", 2);
        mongoTemplate.insert(asd);
        asd = mongoTemplate.findById(asd.getId(), Person.class);
        personRepository.save(asd);
        mongoTemplate.save("{'name':'mkyong', 'age':30}", "myCollection");

        return new ResponseEntity<>(asd.getId(), HttpStatus.OK);
    }
}

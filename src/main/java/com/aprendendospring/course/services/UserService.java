package com.aprendendospring.course.services;

import java.util.Optional;
import java.util.List;
import com.aprendendospring.course.entities.User;
import com.aprendendospring.course.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserService {
    
    @Autowired
    private UserRepository repository; 
    

    public List<User> findAll() {
        return repository.findAll();
    }

    public User findById(Long id) {
        Optional<User> obj = repository.findById(id);;
        return obj.get();
    }  
}

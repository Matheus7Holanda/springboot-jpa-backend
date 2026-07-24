package com.aprendendospring.course.services;

import java.util.Optional;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.aprendendospring.course.entities.Category;
import com.aprendendospring.course.repositories.CategoryRepository;


@Service
public class CategoryService {
    
    @Autowired
    private CategoryRepository repository; 
    

    public List<Category> findAll() {
        return repository.findAll();
    }

    public Category findById(Long id) {
        Optional<Category> obj = repository.findById(id);;
        return obj.get();
    }  
}

package com.aprendendospring.course.services;

import java.util.Optional;
import java.util.List;
import com.aprendendospring.course.entities.User;
import com.aprendendospring.course.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import com.aprendendospring.course.services.exceptions.ResourceNotFoundException;
import com.aprendendospring.course.services.exceptions.DatabaseException;


@Service
public class UserService {
    
    @Autowired
    private UserRepository repository; 
    

    public List<User> findAll() {
        return repository.findAll();
    }

    public User findById(Long id) {
        Optional<User> obj = repository.findById(id);;
        return obj.orElseThrow(() -> new ResourceNotFoundException(id)); // orElseThrow é para lançar uma exceção caso o objeto não seja encontrado
    }
    
    public User insert(User obj) {
        return repository.save(obj);
    } 

    public void delete(Long id) {
        try {
        repository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException(id); // lança a exceção caso o id não seja encontrado  
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException(e.getMessage()); // lança a exceção caso o id seja encontrado mas não possa ser deletado por causa de integridade referencial
        }
    }

    
    public User update(Long id, User obj) { // User obj será os dados que serão atualizados
        User entity = repository.getReferenceById(id); // getReferenceById é para buscar o objeto no banco de dados
        updateData(entity, obj); // updateData é para atualizar os dados do objeto, entity é o objeto que está no banco de dados e obj é o objeto que veio da requisição
        return repository.save(entity); // repository.save é para salvar o objeto no banco de dados
    }

        
    
    private void updateData(User entity, User obj) { // updateData é para atualizar os dados do objeto, entity é o objeto que está no banco de dados e obj é o objeto que veio da requisição
        entity.setName(obj.getName()); // setName é para atualizar o nome do objeto
        entity.setEmail(obj.getEmail()); // setEmail é para atualizar o email do objeto
        entity.setPhone(obj.getPhone()); // setPhone é para atualizar o telefone do objeto
    }


}

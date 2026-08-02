package com.aprendendospring.course.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.List;
import com.aprendendospring.course.services.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.aprendendospring.course.entities.User;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import java.net.URI;
import org.springframework.web.bind.annotation.DeleteMapping;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @Autowired    
    private UserService service;

    @GetMapping
    public ResponseEntity<List<User>> findAll() {
        List<User> list = service.findAll(); 
        return ResponseEntity.ok().body(list); 
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id) {
        User obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping(value = "/insert")
    public ResponseEntity<User> insert(@RequestBody User obj) { // @RequestBody é para pegar o objeto que vem no corpo da requisição
        obj = service.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).body(obj);
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) { //PathVariable é para pegar o id que vem na url 
        service.delete(id); // Isso faz deletar 
        return ResponseEntity.noContent().build(); // Esse faz retornar a resposta de sucesso sem conteúdo
    }
}

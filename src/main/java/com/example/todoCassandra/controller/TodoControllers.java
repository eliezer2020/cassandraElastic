package com.example.todoCassandra.controller;

import com.example.todoCassandra.repository.TodoEntity;
import com.example.todoCassandra.repository.TodoRepo;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/api/v1")
public class TodoControllers {

  @Autowired
  TodoRepo repo;
  private final Map<UUID, TodoEntity> mockMap = new ConcurrentHashMap<>();

  @GetMapping
  public Iterable<TodoEntity> findAll(HttpServletRequest req) {

    return repo.findAll();
  }

  @GetMapping("/{uid}")
  public ResponseEntity<TodoEntity> findById(HttpServletRequest req,
      @PathVariable(value = "uid") String uid) {
    Optional<TodoEntity> todo = repo.findById(UUID.fromString(uid));
    return todo.isPresent() ?  ResponseEntity.ok().body(todo.get()):  new ResponseEntity<>(HttpStatus.NO_CONTENT)
    ;
  }

  @GetMapping("/status/{status}")
  public ResponseEntity<Iterable<TodoEntity>> findById(HttpServletRequest req,
      @PathVariable(value = "status") Boolean status) {
    List<TodoEntity> todos = repo.findByStatus(status);
    return !todos.isEmpty()? ResponseEntity.ok().body(todos): new ResponseEntity<>(HttpStatus.NO_CONTENT);

  }

  @DeleteMapping("{uid}")
  public ResponseEntity<TodoEntity> deleteById(@PathVariable(value = "uid") String uid){
    try{

      repo.deleteById(UUID.fromString(uid));
      return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }catch (Exception e){
      System.out.println(e);
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
  }

  @PostMapping
  public ResponseEntity<TodoEntity>  createTodo(@RequestBody TodoEntity todo){
    TodoEntity todo_=new TodoEntity();
    todo_.setTitle(todo.getTitle());
    todo_.setOrder(todo.getOrder());
    todo_.setUuid(UUID.randomUUID());
    repo.save(todo_);
    return new ResponseEntity<>(HttpStatus.CREATED);

  }

  @PutMapping("/status/{id}/{status}")
  public ResponseEntity<TodoEntity> setStatus(
      @PathVariable String id,@PathVariable Boolean status) {
    Optional<TodoEntity> todo = repo.findById(UUID.fromString(id));
    repo.setStatus(status, UUID.fromString(id));
    return todo.isPresent() ? new ResponseEntity<>( HttpStatus.ACCEPTED ): ResponseEntity.badRequest().body(null);

  }



}



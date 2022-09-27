package com.example.todoCassandra.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRepo extends CrudRepository<TodoEntity, UUID> {

  //customQuery
  @Query("SELECT * FROM todolist where completed=?0 ALLOW FILTERING")
  List<TodoEntity> findByStatus(boolean status);

  @Query("UPDATE todolist SET completed=?0 WHERE id=?1")
  Optional<TodoEntity> setStatus(boolean status, UUID id);

}

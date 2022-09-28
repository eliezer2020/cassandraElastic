package com.example.todoCassandra.elastic.queryops;

import com.example.todoCassandra.repository.TodoEntity;
import org.springframework.beans.factory.annotation.Autowired;


public class ElasticSearchQuery {



  @Autowired
  ElasticTodoServiceImpl todoElsService;



  public void createUpdateDoc(TodoEntity entity){
  todoElsService.saveEntityToDocument(entity);
  }

}

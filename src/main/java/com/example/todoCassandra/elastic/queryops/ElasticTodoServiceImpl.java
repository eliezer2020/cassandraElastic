package com.example.todoCassandra.elastic;

import com.example.todoCassandra.mappers.EntityToDocumentMapper;
import com.example.todoCassandra.repository.TodoEntity;

public class ElasticTodoServiceImpl implements
    ElasticTodoServ<TodoEntity> {

  EntityToDocumentMapper mapper= EntityToDocumentMapper.INSTANCE;
  @Override
  public void saveEntityToDocument(TodoEntity object) {
  try {
    TodoDocument doc= mapper.getDocFromEntity(object);
    System.out.println("sucess converting : "+doc);
  }catch(Exception e){
    System.out.println("error while transforming entity to doc : "+e);
  }


  }
}

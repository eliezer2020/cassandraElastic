package com.example.todoCassandra.elastic.queryops;

import org.springframework.stereotype.Component;


public interface ElasticTodoServ<T> {

  public void saveEntityToDocument(T object);
}

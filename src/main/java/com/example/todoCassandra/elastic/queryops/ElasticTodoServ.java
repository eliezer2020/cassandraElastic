package com.example.todoCassandra.elastic;

public interface ElasticTodoServ<T> {

  public void saveEntityToDocument(T object);
}

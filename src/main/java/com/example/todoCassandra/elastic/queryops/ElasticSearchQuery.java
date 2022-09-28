package com.example.todoCassandra.elastic;

import com.example.todoCassandra.repository.TodoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;

public class ElasticSearchQuery {

  @Autowired
  ElasticsearchOperations elasticTemplate;

  private final String indexname="todolist";

  public void createUpdateDoc(TodoEntity entity){

  }

}

package com.example.todoCassandra.elastic.queryops;

import com.example.todoCassandra.elastic.TodoDocument;
import com.example.todoCassandra.mappers.EntityToDocumentMapper;
import com.example.todoCassandra.repository.TodoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.stereotype.Service;

@Service
public class ElasticTodoServiceImpl implements
    ElasticTodoServ<TodoEntity> {

  private final String indexname = "todolist";
  EntityToDocumentMapper mapper = EntityToDocumentMapper.INSTANCE;
  @Autowired
  ElasticsearchOperations elasticTemplate;

  @Override
  public void saveEntityToDocument(TodoEntity object) {
    if(!elasticTemplate.indexOps(TodoDocument.class).exists()){
    elasticTemplate.indexOps(TodoDocument.class).create();
    }

    try {
      TodoDocument doc = mapper.getDocFromEntity(object);
      System.out.println("sucess converting : " + doc);
      elasticTemplate.save(doc);


    } catch (Exception e) {
      System.out.println("error while transforming or indexing  to doc : " + e);
    }


  }
}

package com.example.todoCassandra.mappers;

import com.example.todoCassandra.elastic.TodoDocument;
import com.example.todoCassandra.repository.TodoEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;


@Mapper
public interface EntityToDocumentMapper {

  //IMPL
  EntityToDocumentMapper INSTANCE= Mappers.getMapper(EntityToDocumentMapper.class);

  //TARGET SOURCE
  TodoDocument getDocFromEntity(TodoEntity entity);
}

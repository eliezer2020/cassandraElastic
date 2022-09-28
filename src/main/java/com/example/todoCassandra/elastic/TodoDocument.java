package com.example.todoCassandra.elastic;

import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(indexName = "todolist")
public class TodoDocument {
  @Id
  private UUID uuid;

  @Field(type = FieldType.Text, name = "title")
  private String title;
  @Field(type = FieldType.Boolean, name = "completed")
  private boolean completed;
  @Field(type = FieldType.Integer, name = "privilege")
  private int order;
}

package com.example.todoCassandra.repository;

import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.cassandra.core.mapping.CassandraType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;
@AllArgsConstructor
@NoArgsConstructor
@Table(value="todolist")
@Data
public class TodoEntity {


    @PrimaryKey(value = "id")
    @Column(value = "id")
    private UUID uuid;
    @Column(value = "title")
    private String title;
    @Column(value = "completed")
    private boolean completed;
    @Column(value="privilege")
    private int order;




}

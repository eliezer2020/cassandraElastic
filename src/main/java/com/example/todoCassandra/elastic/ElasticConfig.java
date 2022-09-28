package com.example.todoCassandra.elastic;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.RestClients;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;

@Configuration
public class ElasticConfig {
  @Value("${spring.data.elastic.connection.url}")
  String url;
  @Bean
  public RestHighLevelClient client() {
    System.out.println("******* elastic value :"+url);
    ClientConfiguration config
        = ClientConfiguration.builder()
        .connectedTo(url)
        .build();

    return RestClients.create(config).rest();
  }

  @Bean
  public ElasticsearchOperations elasticsearchTemplate() {
    return new ElasticsearchRestTemplate(client());
  }

}

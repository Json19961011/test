package com.mp.demo.configuration;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * createdata:2021-02-2021/2/5
 */
@Configuration
public class ElasticSearchClientConfig {

    //创建client对象
    @Bean
    public RestHighLevelClient restHighLevelClient(){
        RestHighLevelClient client = new RestHighLevelClient(RestClient.builder(new HttpHost("127.0.0.1", 9200, "http")));
        return client;
    }
}

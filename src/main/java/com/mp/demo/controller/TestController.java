package com.mp.demo.controller;

import com.mp.demo.entity.User;
import com.mp.demo.mapper.UserMapper;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * @author idea
 * @create 2021-01-21-19:18
 */
@RestController
@EnableScheduling
public class TestController {

    @Autowired
    private UserMapper userMapper;

    @Autowired//按照类型匹配
    private RestHighLevelClient restHighLevelClient;

    @RequestMapping("/testCreateIndex")
    public void testCreateIndex() throws IOException {
        //创建索引请求
        CreateIndexRequest request = new CreateIndexRequest("huangduidui_index");
        //客户端执行请求IndicesClient,请求后获得响应
        CreateIndexResponse createIndexResponse = restHighLevelClient.indices().create(request, RequestOptions.DEFAULT);
        System.out.println(createIndexResponse);
    }

   // @Cacheable(value = "test01",key = "'test'")
    @RequestMapping("/test")
    public String test(){
        System.out.println("调用方法====================================");
        return userMapper.selectList(null).toString();
        //System.out.println("调用结束====================================");
    }

//    @Scheduled(cron = "0/10 * * * * ?")
//    public void zidong(){
//
//        System.out.println("自动执行的方法成功+++++++++++++++++++++++++");
//    }

    @RequestMapping("/insertbyId")
    public void insertbyId(){
        User user = new User();
        user.setName("张三");
        user.setPassword("22222");
        userMapper.insert(user);
    }


}

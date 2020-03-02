package com.fnbo.reactiveapi.client;

import com.fnbo.reactiveapi.model.Comment;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.Type;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Service
public class DataClient {
    private final RestTemplate restTemplate;

    public DataClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<Comment> getAllComments() {
        return restTemplate.exchange("http://localhost:8565/api/v1/comments", HttpMethod.GET, null, new ParameterizedTypeReference<List<Comment>>() {}).getBody();
    }
}

package com.fnbo.reactiveapi.client;

import com.fnbo.reactiveapi.model.Comment;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static org.springframework.http.HttpMethod.GET;

@Service
public class DataClient {
    private final RestTemplate restTemplate;

    public DataClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<Comment> getAllComments() {
        return restTemplate.exchange("http://localhost:8565/api/v1/comments", GET, null,
                new ParameterizedTypeReference<List<Comment>>() {}).getBody();
    }
}

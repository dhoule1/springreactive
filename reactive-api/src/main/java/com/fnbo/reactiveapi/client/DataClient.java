package com.fnbo.reactiveapi.client;

import com.fnbo.reactiveapi.model.Comment;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

import static org.springframework.http.HttpMethod.GET;

@Service
public class DataClient {
    private final RestTemplate webClient;

    public DataClient(RestTemplate webClient) {
        this.webClient = webClient;
    }

    public List<Comment> getAllComments() {
        return webClient.exchange("http://localhost:8565/api/v1/comments", GET, null,
                new ParameterizedTypeReference<List<Comment>>() {}).getBody();
    }
}

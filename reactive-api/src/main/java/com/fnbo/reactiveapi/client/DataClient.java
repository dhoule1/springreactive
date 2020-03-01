package com.fnbo.reactiveapi.client;

import com.fnbo.reactiveapi.model.Comment;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

import static org.springframework.http.HttpMethod.GET;

@Service
public class DataClient {
    private final WebClient webClient;

    public DataClient(WebClient webClient) {
        this.webClient = webClient;
    }

    public Flux<Comment> getAllComments() {
        return webClient.get().uri("http://localhost:8565/api/v1/comments")
        .retrieve()
                .bodyToFlux(Comment.class);
    }
}

package com.fnbo.reactiveapi.client;

import com.fnbo.reactiveapi.model.Comment;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

@Service
public class DataClient {
    private final WebClient webClient;

    public DataClient(WebClient webClient) {
        this.webClient = webClient;
    }

    public Flux<Comment> getAllComments() {
        return webClient.get().uri("http://localhost:8565/api/v1/comments").retrieve().bodyToFlux(Comment.class);
    }
}

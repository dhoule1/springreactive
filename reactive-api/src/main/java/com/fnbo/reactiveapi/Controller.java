package com.fnbo.reactiveapi;

import com.fnbo.reactiveapi.client.DataClient;
import com.fnbo.reactiveapi.model.Comment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
public class Controller {

    private DataClient dataClient;

    public Controller(DataClient dataClient) {
        this.dataClient = dataClient;
    }

    @GetMapping("/api/v1/comments")
    public ResponseEntity<Mono<List<Comment>>> getComments() {
        return ResponseEntity.ok(dataClient.getAllComments());
    }
}

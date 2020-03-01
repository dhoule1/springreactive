package com.fnbo.reactivedata;

import com.fnbo.reactivedata.model.Comment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.List;

@RestController
public class Controller {
    private final CommentRepository dataClient;

    public Controller(CommentRepository dataClient) {
        this.dataClient = dataClient;
    }

    @GetMapping("/api/v1/comments")
    public ResponseEntity<List<Comment>> getComments() {
        List<Comment> comments = new ArrayList<>();
        dataClient.findAll().forEach(comments::add);
        return ResponseEntity.ok(comments);
    }
}

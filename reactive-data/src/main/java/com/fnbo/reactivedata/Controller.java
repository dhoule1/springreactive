package com.fnbo.reactivedata;

import com.fnbo.reactivedata.model.Comment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.StreamSupport;

@RestController
public class Controller {
    private final CommentRepository dataClient;

    public Controller(CommentRepository dataClient) {
        this.dataClient = dataClient;
    }

    @GetMapping("/api/v1/comments")
    public ResponseEntity<List<Comment>> getComments() {
        Iterable<Comment> all = dataClient.findAll();
        ArrayList<Comment> result = new ArrayList<>();
        all.forEach(result::add);
        return ResponseEntity.ok(result);
    }
}

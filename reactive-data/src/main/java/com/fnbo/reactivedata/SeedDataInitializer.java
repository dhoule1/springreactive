package com.fnbo.reactivedata;

import com.fnbo.reactivedata.model.Comment;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class SeedDataInitializer {

    private final CommentRepository commentRepository;

    public SeedDataInitializer(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void ready() {
        List<Comment> comments = Stream.of("First", "Second", "Third Comment")
                .map(text -> new Comment(null, text, LocalDateTime.now()))
                .collect(Collectors.toList());

        commentRepository.saveAll(comments);

    }
}

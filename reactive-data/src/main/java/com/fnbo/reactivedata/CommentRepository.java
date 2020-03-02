package com.fnbo.reactivedata;

import com.fnbo.reactivedata.model.Comment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface CommentRepository extends ReactiveCrudRepository<Comment, Long> {

}

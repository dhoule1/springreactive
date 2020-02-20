package com.fnbo.reactiveapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Comment {
    private long id;
    private String text;
    private LocalDateTime addTimestamp;
}

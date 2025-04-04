package com.tag.demo.data;

import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class FailureResponse {
    private List<String> content;

    public FailureResponse(List<String> content) {
        this.content = content;
    }
}
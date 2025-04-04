package com.tag.demo.data;

import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class SuccessResponse<T> {
    private T content;

    public SuccessResponse(T content) {
        this.content = content;
    }
}

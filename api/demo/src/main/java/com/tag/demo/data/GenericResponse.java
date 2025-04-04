package com.tag.demo.data;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class GenericResponse<T> implements AbstractResponse {

    @JsonProperty("data")
    private SuccessResponse<T> data;

    @JsonProperty("error")
    private FailureResponse error;

    @JsonProperty("code")
    private int code;

    @JsonProperty("timestamp")
    private String timestamp;

    @JsonProperty("message")
    private String message;

    public static <T> GenericResponse<T> success(T content, String message) {
        return new GenericResponse<>(
                new SuccessResponse<>(content),
                null,
                200,
                LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")),
                message);
    }

    public static GenericResponse<?> error(List<String> content, int code, String message) {
        return new GenericResponse<>(
                null,
                new FailureResponse(content),
                code,
                LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")),
                message);
    }

}

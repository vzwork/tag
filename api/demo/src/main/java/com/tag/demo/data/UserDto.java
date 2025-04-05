package com.tag.demo.data;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class UserDto {
    String email;
    String password;
    String nameFirst;
    String nameLast;
}

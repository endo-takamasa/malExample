package com.mal.api.controller.user.payload;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserResponse {

    private int id;
    private String name;
    private String email;
}

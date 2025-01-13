package com.mal.api.controller.user.payload;

import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserRequest {

    @Size(min = 0, max = 3)
    private int id;
    @Size(min = 0, max = 10)
    private String name;
    @Size(min = 0, max = 50)
    private String email;
}

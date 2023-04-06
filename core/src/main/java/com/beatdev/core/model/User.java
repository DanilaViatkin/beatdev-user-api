package com.beatdev.core.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Long id;
    private String email;
    private String password;
    private String imageURI;
    private String name;
    private Status status;
}

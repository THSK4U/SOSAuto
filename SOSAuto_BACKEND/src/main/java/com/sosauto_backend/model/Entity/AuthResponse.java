package com.sosauto_backend.model.Entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AuthResponse {

    @JsonProperty("jwt")
    private String jwt;
    @JsonProperty("message")
    private String message;

}

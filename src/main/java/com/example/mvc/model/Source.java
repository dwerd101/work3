package com.example.mvc.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Source implements Model {

    @JsonProperty("id")
    private long id;
    @JsonProperty("name")
    private String name;
}

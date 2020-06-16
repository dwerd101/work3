package com.example.mvc.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProfileResultView implements Model{
    @JsonProperty("profileId")
    private long profileId;
    @JsonProperty("sourceName")
    private String sourceName;
    @JsonProperty("ownersName")
    private String ownersName;
    @JsonProperty("tablesName")
    private String tablesName;
    @JsonProperty("fieldName")
    private String fieldName;
    @JsonProperty("nameDomain")
    private String nameDomain;
    @JsonProperty("comment")
    private String comment;
}

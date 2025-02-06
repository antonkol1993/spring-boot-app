package com.koleso.spring.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class PlayerCollectionDTO {

    @JsonProperty("playerIds")
    List<Long> ids;
    Long andrei;
    Long antion;
}

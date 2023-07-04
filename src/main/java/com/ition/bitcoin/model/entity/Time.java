package com.ition.bitcoin.model.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Time {
        @JsonProperty("updated")
        private String updated;

        @JsonProperty("updatedISO")
        private String updatedISO;

        @JsonProperty("updateduk")
        private String updateduk;


}

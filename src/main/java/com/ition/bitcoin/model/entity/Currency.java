package com.ition.bitcoin.model.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Currency {
        @JsonProperty("code")
        private String code;

        @JsonProperty("symbol")
        private String symbol;

        @JsonProperty("rate")
        private String rate;

        @JsonProperty("description")
        private String description;

        @JsonProperty("rate_float")
        public double rateFloat;
}

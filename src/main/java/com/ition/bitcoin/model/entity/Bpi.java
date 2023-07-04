package com.ition.bitcoin.model.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ition.bitcoin.model.entity.Currency;
import lombok.Data;

@Data
public class Bpi {
        @JsonProperty("USD")
        private Currency USD;

        @JsonProperty("GBP")
        private Currency GBP;

        @JsonProperty("EUR")
        private Currency EUR;

}

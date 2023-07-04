package com.ition.bitcoin.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ition.bitcoin.model.entity.Time;
import com.ition.bitcoin.model.entity.Bpi;
import lombok.Data;

@Data
public class BitcoinResponse {

    @JsonProperty("time")
    private Time time;

    @JsonProperty("disclaimer")
    private String disclaimer;

    @JsonProperty("chartName")
    private String chartName;

    @JsonProperty("bpi")
    private Bpi bpi;

    private  String wordRate;

}

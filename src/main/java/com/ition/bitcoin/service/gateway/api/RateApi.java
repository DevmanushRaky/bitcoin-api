package com.ition.bitcoin.service.gateway.api;

import com.ition.bitcoin.model.entity.Bpi;
import com.ition.bitcoin.model.entity.Currency;
import com.ition.bitcoin.model.entity.Time;
import com.ition.bitcoin.model.response.BitcoinResponse;
import com.ition.bitcoin.service.gateway.IBitcoinRateApi;
import org.json.JSONObject;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

@Component
public class RateApi implements IBitcoinRateApi {

    @Override
    public BitcoinResponse getBitcoinRate() {
        BitcoinResponse response = new BitcoinResponse();

        String apiUrl = "https://api.coindesk.com/v1/bpi/currentprice.json";
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        HttpEntity<?> entity = new HttpEntity<>(headers);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> resp = restTemplate.exchange(apiUrl, HttpMethod.GET, entity, String.class);
        // Parse the response
        JSONObject json = new JSONObject(resp.getBody());
        // Set the response fields

        // Initialize the Time object
        Time time = new Time();
        response.setTime(time);

        JSONObject timeObj = json.getJSONObject("time");
        response.getTime().setUpdated(timeObj.getString("updated"));
        response.getTime().setUpdatedISO(timeObj.getString("updatedISO"));
        response.getTime().setUpdateduk(timeObj.getString("updateduk"));

        response.setDisclaimer(json.getString("disclaimer"));
        response.setChartName(json.getString("chartName"));

        // Initialize the Bpi object
        Bpi bpi = new Bpi();
        response.setBpi(bpi);
        // Initialize the currency object
        Currency usdCurrency = new Currency();
        response.getBpi().setUSD(usdCurrency);
        response.getBpi().setGBP(usdCurrency);
        response.getBpi().setEUR(usdCurrency);

        response.getBpi().getUSD().setCode(json.getJSONObject("bpi").getJSONObject("USD").getString("code"));
        response.getBpi().getUSD().setSymbol(json.getJSONObject("bpi").getJSONObject("USD").getString("symbol"));
        response.getBpi().getUSD().setRate(json.getJSONObject("bpi").getJSONObject("USD").getString("rate"));
        response.getBpi().getUSD().setDescription(json.getJSONObject("bpi").getJSONObject("USD").getString("description"));
        response.getBpi().getUSD().setRateFloat(json.getJSONObject("bpi").getJSONObject("USD").getDouble("rate_float"));

        response.getBpi().getGBP().setCode(json.getJSONObject("bpi").getJSONObject("GBP").getString("code"));
        response.getBpi().getGBP().setSymbol(json.getJSONObject("bpi").getJSONObject("GBP").getString("symbol"));
        response.getBpi().getGBP().setRate(json.getJSONObject("bpi").getJSONObject("GBP").getString("rate"));
        response.getBpi().getGBP().setDescription(json.getJSONObject("bpi").getJSONObject("GBP").getString("description"));
        response.getBpi().getGBP().setRateFloat(json.getJSONObject("bpi").getJSONObject("GBP").getDouble("rate_float"));

        response.getBpi().getEUR().setCode(json.getJSONObject("bpi").getJSONObject("EUR").getString("code"));
        response.getBpi().getEUR().setSymbol(json.getJSONObject("bpi").getJSONObject("EUR").getString("symbol"));
        response.getBpi().getEUR().setRate(json.getJSONObject("bpi").getJSONObject("EUR").getString("rate"));
        response.getBpi().getEUR().setDescription(json.getJSONObject("bpi").getJSONObject("EUR").getString("description"));
        response.getBpi().getEUR().setRateFloat(json.getJSONObject("bpi").getJSONObject("EUR").getDouble("rate_float"));

        return response;
    }
}

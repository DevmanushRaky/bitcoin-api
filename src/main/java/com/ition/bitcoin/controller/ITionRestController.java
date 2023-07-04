package com.ition.bitcoin.controller;

import com.shopindia.payment.service.IitionRestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/bitcoin")
public class ITionRestController {

    @Autowired
    IitionRestService bitcoinService;

    // Get on demand settlement status
//    @RequestMapping(value = "/rate", method = RequestMethod.GET)
//    public ResponseEntity<BitcoinRateResponse> getBitcoinRate() {
//        BitcoinRateResponse getBitcoinRate = bitcoinService.getBitcoinRate();
//        return new ResponseEntity(getBitcoinRate, getBitcoinRate.getStatus().equals("CREATED") ? HttpStatus.OK : HttpStatus.EXPECTATION_FAILED);
//    }



}

package com.ition.bitcoin.controller;

import com.ition.bitcoin.model.response.BitcoinResponse;
import com.ition.bitcoin.service.ItionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ITionController {

    @Autowired
    private ItionService itionService;

    @GetMapping("/bitcoin")
    public String openBitcoinRequest() {
        return "Bitcoin";
    }

    @GetMapping("/bitcoin/rate")
    public String openBitcoinResponse(ModelMap model) {
        try {
            BitcoinResponse response = itionService.getBitcoinRate();
            model.addAttribute("response", response);
            return "Rate";
        } catch (Exception e) {
            model.addAttribute("error", "Error occurred while fetching the Bitcoin rate.");
            return "bitcoin";
        }
    }
}

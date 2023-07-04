package com.ition.bitcoin.service;


import com.ition.bitcoin.model.response.BitcoinResponse;
import com.ition.bitcoin.service.gateway.IBitcoinRateApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItionService  {

    @Autowired
    IBitcoinRateApi bitcoinRateApi;

    // Change rate in to words
    private String convertToWords(int number) {
        if (number == 0) {
            return "Zero";
        }

        String[] units = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
        String[] tens = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
        String[] teens = {"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
        String[] thousands = {"", "Thousand", "Million", "Billion", "Trillion"};

        int chunkSize = 3; // Process numbers in chunks of three digits
        String result = "";

        int chunkCount = 0;
        while (number > 0) {
            if (number % 1000 != 0) {
                String chunkWords = "";
                int chunk = number % 1000;

                // Process the hundreds place
                if (chunk >= 100) {
                    chunkWords += units[chunk / 100] + " Hundred ";
                    chunk %= 100;
                }

                // Process the tens and units places
                if (chunk >= 10 && chunk <= 19) {
                    chunkWords += teens[chunk % 10] + " ";
                } else if (chunk >= 20) {
                    chunkWords += tens[chunk / 10] + " ";
                    chunk %= 10;
                }

                if (chunk >= 1 && chunk <= 9) {
                    chunkWords += units[chunk] + " ";
                }

                chunkWords += thousands[chunkCount] + " ";
                result = chunkWords + result;
            }

            number /= 1000; // Move to the next chunk
            chunkCount++;
        }

        return result.trim();
    }


    public BitcoinResponse getBitcoinRate() {
        BitcoinResponse response = bitcoinRateApi.getBitcoinRate();
        // Handle the response
        if (response != null) {
            // return the response to the caller
            String rate = response.getBpi().getUSD().getRate();
            int rateInWords = Integer.parseInt(rate.replace(",", "").split("\\.")[0]);
            response.setWordRate(convertToWords(rateInWords));
            return response;
        } else {
            //  return fail response
            return response;
        }
    }



}



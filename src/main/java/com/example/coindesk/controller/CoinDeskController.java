package com.example.coindesk.controller;

import com.example.coindesk.entity.CoinNameMappingEntity;
import com.example.coindesk.function.CoinNameFunction;
import com.example.coindesk.model.CoinDeskInfoModel;
import com.example.coindesk.model.CoinNameModel;
import com.example.coindesk.model.ResponseModel;
import com.example.coindesk.service.CoinNameService;
import org.apache.commons.lang.StringUtils;
import org.apache.tomcat.util.json.JSONParser;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

@RestController
public class CoinDeskController {

    @Autowired
    private CoinNameService service;

    @Autowired
    CoinNameFunction coinNameFunction;

    @GetMapping("/coin-desk-api")
    public ResponseEntity getCoinDeskApi() {
        RestTemplate restTemplate = new RestTemplate();
        HttpStatus request = HttpStatus.OK;
        ResponseModel responseModel = new ResponseModel();
        List<CoinDeskInfoModel> dataList = new ArrayList<>();

        try {
            String url = "https://api.coindesk.com/v1/bpi/currentprice.json";
            ResponseEntity<String> responseEntity = restTemplate.getForEntity(url,String.class);

            if (StringUtils.isNotEmpty(responseEntity.getBody())) {
                String body = responseEntity.getBody();
                responseModel.setData(body);
            } else {
                throw new Exception("https://api.coindesk.com/v1/bpi/currentprice.json IS NOT WORK.");
            }

        } catch (Exception ex) {
            request = HttpStatus.EXPECTATION_FAILED;
            responseModel.setData(ex.toString());
        }

        return ResponseEntity.status(request).body(responseModel);
    }

    @GetMapping("/coin-desk-info")
    public ResponseEntity getCoinDeskInfo() {
        RestTemplate restTemplate = new RestTemplate();
        HttpStatus request = HttpStatus.OK;
        ResponseModel responseModel = new ResponseModel();
        List<CoinDeskInfoModel> dataList = new ArrayList<>();

        try {
            String url = "https://api.coindesk.com/v1/bpi/currentprice.json";
            ResponseEntity<String> responseEntity = restTemplate.getForEntity(url,String.class);
            String body = responseEntity.getBody();
            dataList = coinNameFunction.getCoinDeskInfo(body);

            responseModel.setData(dataList);
        } catch (Exception ex) {
            request = HttpStatus.EXPECTATION_FAILED;
            responseModel.setData(ex.toString());
        }

        return ResponseEntity.status(request).body(responseModel);
    }

    @PostMapping("/coin-names")
    public ResponseEntity insertCoinName(@RequestBody CoinNameModel coinNameModel) {
        HttpStatus request = HttpStatus.OK;
        ResponseModel responseModel = new ResponseModel();

        try {
            service.insertCoinName(coinNameModel.getCoinNameEN(), coinNameModel.getCoinNameTC());
            responseModel.setData("INSERT COMPLETE.");
        } catch (Exception ex) {
            request = HttpStatus.EXPECTATION_FAILED;
            responseModel.setData(ex.toString());
        }

        return ResponseEntity.status(request).body(responseModel);
    }

    @GetMapping("/coin-names")
    public ResponseEntity getCoinName() {
        HttpStatus request = HttpStatus.OK;
        ResponseModel responseModel = new ResponseModel();
        List<CoinNameMappingEntity> dataList;

        try {
            dataList = service.findCoinNameAll();
            responseModel.setData(dataList);
        } catch (Exception ex) {
            request = HttpStatus.EXPECTATION_FAILED;
            responseModel.setData(ex.toString());
        }

        return ResponseEntity.status(request).body(responseModel);
    }

    @PutMapping("/coin-names")
    public ResponseEntity updateCoinName(@RequestBody CoinNameModel coinNameModel) {
        HttpStatus request = HttpStatus.OK;
        ResponseModel responseModel = new ResponseModel();
        List<CoinNameMappingEntity> dataList;

        try {
            service.updateCoinName(coinNameModel.getCoinNameEN(), coinNameModel.getCoinNameTC());
            dataList = service.findCoinNameAll();
            responseModel.setData(dataList);
        } catch (Exception ex) {
            request = HttpStatus.EXPECTATION_FAILED;
            responseModel.setData(ex.toString());
        }

        return ResponseEntity.status(request).body(responseModel);
    }

    @DeleteMapping("/coin-names/{coinName}")
    public ResponseEntity deleteCoinName(@PathVariable String coinName) {
        HttpStatus request = HttpStatus.OK;
        ResponseModel responseModel = new ResponseModel();

        try {
            service.deleteCoinNameById(coinName);
            responseModel.setData("DELETE COMPLETE.");
        } catch (Exception ex) {
            request = HttpStatus.EXPECTATION_FAILED;
            responseModel.setData(ex.toString());
        }

        return ResponseEntity.status(request).body(responseModel);
    }
}

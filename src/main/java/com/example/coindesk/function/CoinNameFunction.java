package com.example.coindesk.function;

import com.example.coindesk.entity.CoinNameMappingEntity;
import com.example.coindesk.model.CoinDeskInfoModel;
import com.example.coindesk.service.CoinNameService;
import com.fasterxml.jackson.databind.ObjectMapper;
import jdk.nashorn.internal.parser.JSONParser;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.DataInput;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class CoinNameFunction {

    @Autowired
    CoinNameService service;

    public List<CoinDeskInfoModel> getCoinDeskInfo(String body) throws Exception {
        List<CoinDeskInfoModel> dataList = new ArrayList<>();
        SimpleDateFormat dateParser = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss+00:00");
        SimpleDateFormat dateFormatter  = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

        JSONObject jsonObject = new JSONObject(body);
        Date date = dateParser.parse(jsonObject.getJSONObject("time").get("updatedISO").toString());
        String updateTime = dateFormatter.format(date);

        HashMap<String,Object> jsonMap = new ObjectMapper().readValue(jsonObject.getJSONObject("bpi").toString(), HashMap.class);

        for (Map.Entry<String, Object> entry : jsonMap.entrySet()) {
            HashMap<String,Object> coinDetailMap = (HashMap<String, Object>) entry.getValue();

            String code = coinDetailMap.get("code").toString();
            String rate = coinDetailMap.get("rate").toString();
            String coinName = service.findCoinNameById(code);

            CoinDeskInfoModel coinDeskInfoModel = new CoinDeskInfoModel();
            coinDeskInfoModel.setCoinName(code);
            coinDeskInfoModel.setCoinNameTC(coinName);
            coinDeskInfoModel.setRate(rate);
            coinDeskInfoModel.setUpdateTime(updateTime);

            dataList.add(coinDeskInfoModel);
        }

        return dataList;
    }
}

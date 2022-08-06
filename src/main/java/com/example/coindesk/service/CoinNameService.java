package com.example.coindesk.service;

import com.example.coindesk.entity.CoinNameMappingEntity;
import com.example.coindesk.repository.CoinNameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoinNameService {

    @Autowired
    private CoinNameRepository coinNameRepository;

    public List<CoinNameMappingEntity> findCoinNameAll() throws Exception {
        return coinNameRepository.findAll();
    }

    public void deleteCoinNameById(String id) throws Exception {
        coinNameRepository.deleteById(id);
    }

    public void insertCoinName(String id, String coinNameTC) throws Exception {
        CoinNameMappingEntity entity = new CoinNameMappingEntity();
        entity.setCoinNameEN(id);
        entity.setCoinNameTC(coinNameTC);
        coinNameRepository.save(entity);
    }

    public void updateCoinName(String id, String coinNameTC) throws Exception {
        CoinNameMappingEntity entity = new CoinNameMappingEntity();
        entity.setCoinNameEN(id);
        entity.setCoinNameTC(coinNameTC);
        coinNameRepository.save(entity);
    }

    public String findCoinNameById(String id) {
        String name;

        try {
            name = coinNameRepository.findById(id).get().getCoinNameTC();
        } catch (Exception ex) {
            name = "No Mapping Data.";
        }

        return name;
    }
}

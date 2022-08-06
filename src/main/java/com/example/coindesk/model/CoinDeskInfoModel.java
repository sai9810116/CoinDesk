package com.example.coindesk.model;

public class CoinDeskInfoModel {
    private String coinName;
    private String coinNameTC;
    private String rate;
    private String updateTime;

    public String getCoinName() {
        return coinName;
    }

    public void setCoinName(String coinName) {
        this.coinName = coinName;
    }

    public String getCoinNameTC() {
        return coinNameTC;
    }

    public void setCoinNameTC(String coinNameTC) {
        this.coinNameTC = coinNameTC;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }
}

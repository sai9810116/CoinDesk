package com.example.coindesk.entity;

import com.sun.istack.NotNull;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "COIN_NAME_MAPPING")
public class CoinNameMappingEntity {

    @Id
    @Column(name = "COIN_NAME_EN", columnDefinition="VARCHAR(5)")
    @NotNull
    private String coinNameEN;

    @Column(name = "COIN_NAME_TC", columnDefinition="VARCHAR(10)")
    @NotNull
    private String coinNameTC;

    public String getCoinNameEN() {
        return coinNameEN;
    }

    public void setCoinNameEN(String coinNameEN) {
        this.coinNameEN = coinNameEN;
    }

    public String getCoinNameTC() {
        return coinNameTC;
    }

    public void setCoinNameTC(String coinNameTC) {
        this.coinNameTC = coinNameTC;
    }
}

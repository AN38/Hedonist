package com.example.hedonist;

public class OrderModel {
    private BEVERAGE beverage = BEVERAGE.COFFEE;

    public BEVERAGE getBeverage() {
        return beverage;
    }

    public void setBeverage(BEVERAGE beverage) {
        this.beverage = beverage;
    }

    enum BEVERAGE {
        COFFEE,
        MILKSHAKE,
        TEA
    }

    enum EXTRA {
        SUGAR,
        MILK,

    }
}

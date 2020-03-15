package com.vlasova.entity;

import java.util.Objects;

public class CallPrices {
    private int insideNetworkPrice;
    private int outsideNetworkPrice;
    private int stationaryPhonePrice;

    public CallPrices() {
    }

    public CallPrices(int insideNetworkPrice, int outsideNetworkPrice, int stationaryPhonePrice) {
        this.insideNetworkPrice = insideNetworkPrice;
        this.outsideNetworkPrice = outsideNetworkPrice;
        this.stationaryPhonePrice = stationaryPhonePrice;
    }

    public int getInsideNetworkPrice() {
        return insideNetworkPrice;
    }

    public void setInsideNetworkPrice(int insideNetworkPrice) {
        this.insideNetworkPrice = insideNetworkPrice;
    }

    public int getOutsideNetworkPrice() {
        return outsideNetworkPrice;
    }

    public void setOutsideNetworkPrice(int outsideNetworkPrice) {
        this.outsideNetworkPrice = outsideNetworkPrice;
    }

    public int getStationaryPhonePrice() {
        return stationaryPhonePrice;
    }

    public void setStationaryPhonePrice(int stationaryPhonePrice) {
        this.stationaryPhonePrice = stationaryPhonePrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CallPrices callPrices = (CallPrices) o;
        return insideNetworkPrice == callPrices.insideNetworkPrice &&
                outsideNetworkPrice == callPrices.outsideNetworkPrice &&
                stationaryPhonePrice == callPrices.stationaryPhonePrice;
    }

    @Override
    public int hashCode() {
        return Objects.hash(insideNetworkPrice, outsideNetworkPrice, stationaryPhonePrice);
    }

    @Override
    public String toString() {
        return "CallPrice{" +
                "insideNetworkPrice=" + insideNetworkPrice +
                ", outsideNetworkPrice=" + outsideNetworkPrice +
                ", stationaryPhonePrice=" + stationaryPhonePrice +
                '}';
    }
}
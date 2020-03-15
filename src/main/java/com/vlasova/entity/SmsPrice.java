package com.vlasova.entity;

import java.util.Objects;

public class SmsPrice {
    private int insideNetworkPrice;
    private int outsideNetworkPrice;

    public SmsPrice() {
    }

    public SmsPrice(int insideNetworkPrice, int outsideNetworkPrice) {
        this.insideNetworkPrice = insideNetworkPrice;
        this.outsideNetworkPrice = outsideNetworkPrice;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SmsPrice smsPrice = (SmsPrice) o;
        return insideNetworkPrice == smsPrice.insideNetworkPrice &&
                outsideNetworkPrice == smsPrice.outsideNetworkPrice;
    }

    @Override
    public int hashCode() {
        return Objects.hash(insideNetworkPrice, outsideNetworkPrice);
    }

    @Override
    public String toString() {
        return "SmsPrice{" +
                "insideNetworkPrice=" + insideNetworkPrice +
                ", outsideNetworkPrice=" + outsideNetworkPrice +
                '}';
    }
}
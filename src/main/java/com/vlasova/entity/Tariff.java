package com.vlasova.entity;

import java.util.Objects;

public class Tariff {
    private int id;
    private String name;
    private String operatorName;
    private int payroll;
    private CallPrices callPrices;
    private SmsPrice smsPrice;
    private Parameters parameters;

    public Tariff(int id, String name, String operatorName, int payroll,
                  CallPrices callPrices, SmsPrice smsPrice, Parameters parameters) {
        this.id = id;
        this.name = name;
        this.operatorName = operatorName;
        this.payroll = payroll;
        this.callPrices = callPrices;
        this.smsPrice = smsPrice;
        this.parameters = parameters;
    }

    public Tariff() {
        callPrices = new CallPrices();
        smsPrice = new SmsPrice();
        parameters = new Parameters();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOperatorName() {
        return operatorName;
    }

    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName;
    }

    public int getPayroll() {
        return payroll;
    }

    public void setPayroll(int payroll) {
        this.payroll = payroll;
    }

    public CallPrices getCallPrices() {
        return callPrices;
    }

    public void setCallPrices(CallPrices callPrices) {
        this.callPrices = callPrices;
    }

    public SmsPrice getSmsPrice() {
        return smsPrice;
    }

    public void setSmsPrice(SmsPrice smsPrice) {
        this.smsPrice = smsPrice;
    }

    public Parameters getParameters() {
        return parameters;
    }

    public void setParameters(Parameters parameters) {
        this.parameters = parameters;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tariff tariff = (Tariff) o;
        return id == tariff.id &&
                payroll == tariff.payroll &&
                name.equals(tariff.name) &&
                operatorName.equals(tariff.operatorName) &&
                callPrices.equals(tariff.callPrices) &&
                smsPrice.equals(tariff.smsPrice) &&
                parameters.equals(tariff.parameters);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, operatorName, payroll, callPrices, smsPrice, parameters);
    }

    @Override
    public String toString() {
        return "Tariff{" +
                "id=" + id +
                ", tariffName='" + name + '\'' +
                ", operatorName='" + operatorName + '\'' +
                ", payroll=" + payroll +
                ", callPrice=" + callPrices +
                ", smsPrice=" + smsPrice +
                ", parameters=" + parameters +
                '}';
    }
}

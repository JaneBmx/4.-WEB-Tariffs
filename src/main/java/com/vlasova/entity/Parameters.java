package com.vlasova.entity;

import java.util.Objects;

public class Parameters {
    private int countOfFavoriteNumbers;
    private Billing billing;
    private int connectionFee;

    public Parameters() {
    }

    public Parameters(int countOfFavoriteNumbers, Billing billing, int connectionFee) {
        this.countOfFavoriteNumbers = countOfFavoriteNumbers;
        this.billing = billing;
        this.connectionFee = connectionFee;
    }

    public int getCountOfFavoriteNumbers() {
        return countOfFavoriteNumbers;
    }

    public void setCountOfFavoriteNumbers(int countOfFavoriteNumbers) {
        this.countOfFavoriteNumbers = countOfFavoriteNumbers;
    }

    public Billing getBilling() {
        return billing;
    }

    public void setBilling(Billing billing) {
        this.billing = billing;
    }

    public int getConnectionFee() {
        return connectionFee;
    }

    public void setConnectionFee(int connectionFee) {
        this.connectionFee = connectionFee;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Parameters that = (Parameters) o;
        return countOfFavoriteNumbers == that.countOfFavoriteNumbers &&
                connectionFee == that.connectionFee &&
                billing == that.billing;
    }

    @Override
    public int hashCode() {
        return Objects.hash(countOfFavoriteNumbers, billing, connectionFee);
    }

    @Override
    public String toString() {
        return "Parameters{" +
                "countOfFavoriteNumbers=" + countOfFavoriteNumbers +
                ", tariffing=" + billing +
                ", connectionFee=" + connectionFee +
                '}';
    }
}
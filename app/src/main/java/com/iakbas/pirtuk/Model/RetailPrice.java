package com.iakbas.pirtuk.Model;
public class RetailPrice{
    public double amount;
    public String currencyCode;
    public int amountInMicros;

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public int getAmountInMicros() {
        return amountInMicros;
    }

    public void setAmountInMicros(int amountInMicros) {
        this.amountInMicros = amountInMicros;
    }
}

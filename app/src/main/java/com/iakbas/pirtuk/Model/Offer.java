package com.iakbas.pirtuk.Model;

public class Offer{
    public int finskyOfferType;
    public ListPrice listPrice;
    public RetailPrice retailPrice;

    public int getFinskyOfferType() {
        return finskyOfferType;
    }

    public void setFinskyOfferType(int finskyOfferType) {
        this.finskyOfferType = finskyOfferType;
    }

    public ListPrice getListPrice() {
        return listPrice;
    }

    public void setListPrice(ListPrice listPrice) {
        this.listPrice = listPrice;
    }

    public RetailPrice getRetailPrice() {
        return retailPrice;
    }

    public void setRetailPrice(RetailPrice retailPrice) {
        this.retailPrice = retailPrice;
    }
}

package com.gzj.model;

import java.io.Serializable;
import java.util.Objects;

/**
 * @projectName: JavaWeb
 * @package: com.gzj.model
 * @className: Merchant_dish
 * @author: Gzj
 * @description: TODO
 * @date: 2023/12/21 23:49
 * @version: 1.0
 */
public class Merchant_dish implements Serializable {
    private int DishID;
    private int MerchantID;

    public Merchant_dish(){

    }

    public Merchant_dish(int dishID, int merchantID) {
        DishID = dishID;
        MerchantID = merchantID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Merchant_dish that = (Merchant_dish) o;
        return DishID == that.DishID && MerchantID == that.MerchantID;
    }

    @Override
    public int hashCode() {
        return Objects.hash(DishID, MerchantID);
    }

    @Override
    public String toString() {
        return "Merchant_dish{" +
                "DishID=" + DishID +
                ", MerchantID=" + MerchantID +
                '}';
    }

    public int getDishID() {
        return DishID;
    }

    public void setDishID(int dishID) {
        DishID = dishID;
    }

    public int getMerchantID() {
        return MerchantID;
    }

    public void setMerchantID(int merchantID) {
        MerchantID = merchantID;
    }
}

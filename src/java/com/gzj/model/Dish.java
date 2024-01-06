package com.gzj.model;

import java.io.Serializable;
import java.util.Objects;

/**
 * @projectName: JavaWeb
 * @package: com.gzj.model
 * @className: Dish
 * @author: Gzj
 * @description: TODO
 * @date: 2023/12/21 23:43
 * @version: 1.0
 */
public class Dish implements Serializable {
    private int DishID;
    private String OrderID;
    private String DishName;
    private String DishDescription;
    private float Price;
    private boolean DishStatus;
    private String image_url;

    public Dish(){

    }

    public Dish(int dishID, String orderID, String dishName, String dishDescription, float price, boolean dishStatus, String image_url) {
        DishID = dishID;
        OrderID = orderID;
        DishName = dishName;
        DishDescription = dishDescription;
        Price = price;
        DishStatus = dishStatus;
        this.image_url = image_url;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dish dish = (Dish) o;
        return DishID == dish.DishID && OrderID == dish.OrderID && DishName == dish.DishName && DishDescription == dish.DishDescription && Float.compare(dish.Price, Price) == 0 && DishStatus == dish.DishStatus && image_url == dish.image_url;
    }

    @Override
    public int hashCode() {
        return Objects.hash(DishID, OrderID, DishName, DishDescription, Price, DishStatus, image_url);
    }

    @Override
    public String toString() {
        return "Dish{" +
                "DishID=" + DishID +
                ", OrderID=" + OrderID +
                ", DishName=" + DishName +
                ", DishDescription=" + DishDescription +
                ", Price=" + Price +
                ", DishStatus=" + DishStatus +
                ", image_url=" + image_url +
                '}';
    }

    public int getDishID() {
        return DishID;
    }

    public void setDishID(int dishID) {
        DishID = dishID;
    }

    public String getOrderID() {
        return OrderID;
    }

    public void setOrderID(String orderID) {
        OrderID = orderID;
    }

    public String getDishName() {
        return DishName;
    }

    public void setDishName(String dishName) {
        DishName = dishName;
    }

    public String getDishDescription() {
        return DishDescription;
    }

    public void setDishDescription(String dishDescription) {
        DishDescription = dishDescription;
    }

    public float getPrice() {
        return Price;
    }

    public void setPrice(float price) {
        Price = price;
    }

    public boolean isDishStatus() {
        return DishStatus;
    }

    public void setDishStatus(boolean dishStatus) {
        DishStatus = dishStatus;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }
}
